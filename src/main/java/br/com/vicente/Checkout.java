 package br.com.vicente;

public class Checkout {



    private final ParkedCarRepository parkedCarDAO;

    private final Clock clock;



   private final Period workingHours;


    public Checkout(Clock clock, ParkedCarRepository parkedCarDAO, Period workingHours) {
        this.clock = clock;
        this.parkedCarDAO = parkedCarDAO;
        this.workingHours =workingHours;
    }


    public Ticket execute(String plate){
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
