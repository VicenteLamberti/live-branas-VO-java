package br.com.vicente;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class ParkingServiceTest {


    @Test
    void deveEntrarESairDoEstacionamentoCalculandoOValorDaTarifa(){
        var clock = new FakerClock();

        var parkingService = new ParkingService(clock, new ParkedCarMemory());
        var plate = "AAA9999";
        var expectedTicketPrice = 20;
        String dateChecking = "2021-03-01T10:00:00";

        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        LocalDateTime localDateTime = LocalDateTime.from(formatter.parse(dateChecking));

        Instant instantChecking = localDateTime.toInstant(ZoneOffset.UTC);
        clock.setCurrentDate(instantChecking);

        parkingService.checking(plate);
        String dateCheckout = "2021-03-01T12:00:00";

        localDateTime = LocalDateTime.from(formatter.parse(dateCheckout));

        Instant instantCheckout = localDateTime.toInstant(ZoneOffset.UTC);
        clock.setCurrentDate(instantCheckout);

        var ticket = parkingService.checkout(plate);

        Assertions.assertEquals(expectedTicketPrice, ticket.getPrice());
    }

    @Test
    void naoLancarUmErroCasoUmCarroNaoEncontradoTenteSair(){

        var clock = new FakerClock();

        var parkingService = new ParkingService(clock,new ParkedCarMemory());

        Assertions.assertThrows(RuntimeException.class,()->parkingService.checkout("AAA999"));

    }


    @Test
    void naoDeveEntrarComPlacaInvalida(){
        var clock = new FakerClock();

        var parkingService = new ParkingService(clock,new ParkedCarMemory());
        var plate = "AA99";
        var expectedTicketPrice = 20;
        String dateChecking = "2021-03-01T10:00:00";

        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        LocalDateTime localDateTime = LocalDateTime.from(formatter.parse(dateChecking));

        Instant instantChecking = localDateTime.toInstant(ZoneOffset.UTC);
        clock.setCurrentDate(instantChecking);

        Assertions.assertThrows(RuntimeException.class,()->parkingService.checking(plate));

    }

}