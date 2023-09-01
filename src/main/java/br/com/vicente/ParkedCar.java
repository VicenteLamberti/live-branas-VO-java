package br.com.vicente;

import java.time.Duration;
import java.time.Instant;

public class ParkedCar {

    private String plate;
    private Instant checkingDate;
    private Instant checkoutDate;
    private Duration duration;
    private long price;

    public ParkedCar(String plate, Instant checkingDate) {
        this.plate = plate;
        this.checkingDate = checkingDate;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public Instant getCheckingDate() {
        return checkingDate;
    }

    public void setCheckingDate(Instant checkingDate) {
        this.checkingDate = checkingDate;
    }

    public Instant getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(Instant checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}
