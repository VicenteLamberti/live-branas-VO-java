package br.com.vicente;

public class ParkingService {



    private final ParkedCarRepository parkedCarDAO;

    private final Clock clock;



   private final Period workingHours;


    public ParkingService(Clock clock, ParkedCarRepository parkedCarDAO, Period workingHours) {
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
        var parkedCar = this.parkedCarDAO.get(plateVO.getValue());
        if(parkedCar == null){
            throw new RuntimeException("Parked car not found");
        }

        var checkoutDate = this.clock.getCurrentDate();
        parkedCar.checkout( checkoutDate);
        this.parkedCarDAO.update(parkedCar);
        return new Ticket(parkedCar.getPrice());

    }




}
