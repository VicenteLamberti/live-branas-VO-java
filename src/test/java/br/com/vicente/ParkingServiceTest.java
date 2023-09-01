package br.com.vicente;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class ParkingServiceTest {


    @Test
    void deveEntrarESairDoEstacionamentoCalculandoOValorDaTarifa(){
        var clock = new FakerClock();

        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        LocalDateTime start = LocalDateTime.from(formatter.parse("2021-03-01T08:00:00"));
        LocalDateTime end = LocalDateTime.from(formatter.parse("2021-03-01T22:00:00"));

        var period = new Period(start,end);

        ParkedCarRepositoryMemory memory =  new ParkedCarRepositoryMemory();
        var checking = new Checkin(clock,memory ,period);
        var plate = "AAA9999";
        var expectedTicketPrice = 20;
        String dateChecking = "2021-03-01T10:00:00";


        LocalDateTime instantChecking = LocalDateTime.from(formatter.parse(dateChecking));


        clock.setCurrentDate(instantChecking);

        checking.execute(plate);
        String dateCheckout = "2021-03-01T12:00:00";

        LocalDateTime instantCheckout = LocalDateTime.from(formatter.parse(dateCheckout));


        clock.setCurrentDate(instantCheckout);

        var checkout = new Checkout(clock,memory ,period);
        var ticket = checkout.execute(plate);

        Assertions.assertEquals(expectedTicketPrice, ticket.getPrice());
    }

    @Test
    void naoLancarUmErroCasoUmCarroNaoEncontradoTenteSair(){

        var clock = new FakerClock();

        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        LocalDateTime start = LocalDateTime.from(formatter.parse("2021-03-01T08:00:00"));
        LocalDateTime end = LocalDateTime.from(formatter.parse("2021-03-01T22:00:00"));

        var period = new Period(start,end);
        var checkout = new Checkout(clock, new ParkedCarRepositoryMemory(),period);

        RuntimeException runtimeException = assertThrows(RuntimeException.class, () -> checkout.execute("AAA9999"));
        Assertions.assertEquals("Parked car not found",runtimeException.getMessage());

    }


    @Test
    void naoDeveEntrarComPlacaInvalida(){
        var clock = new FakerClock();

        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        LocalDateTime start = LocalDateTime.from(formatter.parse("2021-03-01T08:00:00"));
        LocalDateTime end = LocalDateTime.from(formatter.parse("2021-03-01T22:00:00"));

        var period = new Period(start,end);

        var checking = new Checkin(clock, new ParkedCarRepositoryMemory(),period);
        var plate = "AA99";
        var expectedTicketPrice = 20;
        String dateChecking = "2021-03-01T10:00:00";

        LocalDateTime instantChecking = LocalDateTime.from(formatter.parse(dateChecking));

        clock.setCurrentDate(instantChecking);
        RuntimeException runtimeException = assertThrows(RuntimeException.class, () -> checking.execute(plate));
        Assertions.assertEquals("Invalid plate",runtimeException.getMessage());

    }


    @Test
    void naoDeveEntrarAntesDeAbrirEstacionamento(){
        var clock = new FakerClock();
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        LocalDateTime start = LocalDateTime.from(formatter.parse("2021-03-01T08:00:00"));
        LocalDateTime end = LocalDateTime.from(formatter.parse("2021-03-01T22:00:00"));

        var period = new Period(start,end);

        var checking = new Checkin(clock, new ParkedCarRepositoryMemory(),period);
        var plate = "AAA9999";
        var expectedTicketPrice = 20;
        String dateChecking = "2021-03-01T07:00:00";

        LocalDateTime instantChecking = LocalDateTime.from(formatter.parse(dateChecking));

        clock.setCurrentDate(instantChecking);

        RuntimeException runtimeException = assertThrows(RuntimeException.class, () -> checking.execute(plate));
        Assertions.assertEquals("Parking is closed",runtimeException.getMessage());

    }

    @Test
    void naoDeveEntrarDepoisDeFecharEstacionamento(){
        var clock = new FakerClock();

        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        LocalDateTime start = LocalDateTime.from(formatter.parse("2021-03-01T08:00:00"));
        LocalDateTime end = LocalDateTime.from(formatter.parse("2021-03-01T22:00:00"));

        var period = new Period(start,end);

        var checking = new Checkin(clock, new ParkedCarRepositoryMemory(),period);
        var plate = "AAA9999";
        var expectedTicketPrice = 20;
        String dateChecking = "2021-03-01T23:00:00";


        LocalDateTime instantChecking = LocalDateTime.from(formatter.parse(dateChecking));

        clock.setCurrentDate(instantChecking);

        RuntimeException runtimeException = assertThrows(RuntimeException.class, () -> checking.execute(plate));
        Assertions.assertEquals("Parking is closed",runtimeException.getMessage());

    }
}