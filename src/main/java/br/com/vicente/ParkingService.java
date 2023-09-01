package br.com.vicente;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParkingService {



    private final ParkedCarDAO parkedCarDAO;

    private final Clock clock;



   private final Period workingHours;


    public ParkingService(Clock clock, ParkedCarDAO parkedCarDAO, Period workingHours) {
        this.clock = clock;
        this.parkedCarDAO = parkedCarDAO;
        this.workingHours =workingHours;
    }

    public void checking(String plate){

        Plate plateVO = new Plate(plate);

        var checkingDate = this.clock.getCurrentDate();

        if(this.workingHours.isOutOfPeriod(checkingDate)){
            throw new RuntimeException("Parking is closed");
        }

        ParkedCar parkedCar = new ParkedCar(plateVO, checkingDate);
        this.parkedCarDAO.save(parkedCar);
    }

    public Ticket checkout(String plate){
        Plate plateVO = new Plate(plate);
        var parkedCar = this.parkedCarDAO.get(plateVO);
        if(parkedCar == null){
            throw new RuntimeException("Parked car not found");
        }

        var checkoutDate = this.clock.getCurrentDate();
        parkedCar.checkout(checkoutDate);
        var period = new Period(parkedCar.getCheckingDate(), parkedCar.getCheckoutDate());
        parkedCar.setDuration(period.getDurationInHours());

        long price = parkedCar.getDuration() * 10;
        parkedCar.setPrice(price);
        this.parkedCarDAO.update(parkedCar);
        return new Ticket(parkedCar.getPrice());

    }




}
