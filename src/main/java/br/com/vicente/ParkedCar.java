package br.com.vicente;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;

public class ParkedCar {
    private static final long PRICE_PER_HOUR = 10;

    private Plate plate;
    private LocalDateTime checkingDate;
    private LocalDateTime checkoutDate;
    private long duration;
    private long price;
    private Period period;

    public ParkedCar(Plate plate, LocalDateTime checkingDate) {
        this.plate = plate;
        this.checkingDate = checkingDate;
    }

    public Plate getPlate() {
        return plate;
    }



    public LocalDateTime getCheckingDate() {
        return checkingDate;
    }



    public LocalDateTime getCheckoutDate() {
        return checkoutDate;
    }



    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public long getPrice() {
        return price;
    }



    public void checkout(LocalDateTime checkoutDate){
        this.checkoutDate = checkoutDate;
        this.period = new Period(this.checkingDate,this.checkoutDate);
        this.price = this.calculatePrice();
    }

    public long calculatePrice(){
        if(this.period == null){
            throw new RuntimeException();
        }
        return this.period.getDurationInHours() * this.PRICE_PER_HOUR;
    }
}
