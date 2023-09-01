package br.com.vicente;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingServiceTest {

    @Test
    void deveEntrarESairDoEstacionamentoCalculandoOValorDaTarifa(){
        var parkingService = new ParkingService();
        var plate = "AAA999";
        var expectedTicketPrice = 20;
        parkingService.checkin(plate);
        var ticket = parkingService.checkout(plate);

        Assertions.assertEquals(expectedTicketPrice, ticket.price());
    }

}