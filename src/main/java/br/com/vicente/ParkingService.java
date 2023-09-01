package br.com.vicente;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class ParkingService {

    private Map<String,ParkedCar> parkedCars = new HashMap<>();

    public void checkin(String plate){
        var checkingDate = Instant.now();
        this.parkedCars.put(plate,new ParkedCar(plate,checkingDate));
    }

    public Ticket checkout(String plate){
        var parkedCar = this.parkedCars.get(plate);
        var checkoutDate = Instant.now();
        Duration duration = Duration.between(checkoutDate, parkedCar.getCheckingDate());
        var hours = duration.toHours();
        var price = hours * 10;
        return new Ticket(price);

    }




}
