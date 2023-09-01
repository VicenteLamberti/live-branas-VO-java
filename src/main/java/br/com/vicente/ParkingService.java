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

   private static final int OPEN_HOUR = 8;
   private static final int CLOSE_HOUR = 22;


    public ParkingService(Clock clock, ParkedCarDAO parkedCarDAO) {
        this.clock = clock;
        this.parkedCarDAO = parkedCarDAO;
    }

    public void checking(String plate){

        Plate plateVO = new Plate(plate);

        var checkingDate = this.clock.getCurrentDate();

        if(checkingDate.getHour() < OPEN_HOUR){
            throw new RuntimeException("Parking is closed");
        }
        if(checkingDate.getHour() > CLOSE_HOUR){
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
        parkedCar.setCheckoutDate(checkoutDate);
        var period = new Period(parkedCar.getCheckingDate(), parkedCar.getCheckoutDate());
        parkedCar.setDuration(period.getDurationInHours());

        long price = parkedCar.getDuration() * 10;
        parkedCar.setPrice(price);
        this.parkedCarDAO.update(parkedCar);
        return new Ticket(parkedCar.getPrice());

    }




}
