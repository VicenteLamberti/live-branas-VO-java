package br.com.vicente;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class ParkingService {

    private Map<String,ParkedCar> parkedCars = new HashMap<>();

    private final Clock clock;


    public ParkingService(Clock clock) {
        this.clock = clock;
    }

    public void checking(String plate){
        var checkingDate = this.clock.getCurrentDate();
        this.parkedCars.put(plate,new ParkedCar(plate,checkingDate));
    }

    public Ticket checkout(String plate){
        var parkedCar = this.parkedCars.get(plate);
        if(parkedCar == null){
            throw new RuntimeException("Parked car not found");
        }
        var checkoutDate = this.clock.getCurrentDate();
        Duration duration = Duration.between(parkedCar.getCheckingDate(), checkoutDate);
        var hours = duration.toHours();
        var price = hours * 10;
        return new Ticket(price);

    }




}
