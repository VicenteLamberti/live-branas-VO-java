package br.com.vicente;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;

public class ParkedCar {

    private Plate plate;
    private LocalDateTime checkingDate;
    private LocalDateTime checkoutDate;
    private long duration;
    private long price;

    public ParkedCar(Plate plate, LocalDateTime checkingDate) {
        this.plate = plate;
        this.checkingDate = checkingDate;
    }

    public Plate getPlate() {
        return plate;
    }

    public void setPlate(Plate plate) {
        this.plate = plate;
    }

    public LocalDateTime getCheckingDate() {
        return checkingDate;
    }

    public void setCheckingDate(LocalDateTime checkingDate) {
        this.checkingDate = checkingDate;
    }

    public LocalDateTime getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(LocalDateTime checkoutDate) {
        this.checkoutDate = checkoutDate;
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

    public void setPrice(long price) {
        this.price = price;
    }
}
