package br.com.vicente;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;

public class ParkedCar {

    private String plate;
    private LocalDateTime checkingDate;
    private LocalDateTime checkoutDate;
    private Duration duration;
    private long price;

    public ParkedCar(String plate, LocalDateTime checkingDate) {
        this.plate = plate;
        this.checkingDate = checkingDate;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
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
