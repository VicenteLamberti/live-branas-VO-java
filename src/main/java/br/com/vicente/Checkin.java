 package br.com.vicente;

public class Checkin {



    private final ParkedCarRepository parkedCarDAO;

    private final Clock clock;



   private final Period workingHours;


    public Checkin(Clock clock, ParkedCarRepository parkedCarDAO, Period workingHours) {
        this.clock = clock;
        this.parkedCarDAO = parkedCarDAO;
        this.workingHours =workingHours;
    }

    public void execute(String plate){

        Plate plateVO = new Plate(plate);

        var checkingDate = this.clock.getCurrentDate();

        if(this.workingHours.isOutOfPeriod(checkingDate)){
            throw new RuntimeException("Parking is closed");
        }

        ParkedCar parkedCar = new ParkedCar(plateVO, checkingDate);
        this.parkedCarDAO.save(parkedCar);
    }






}
