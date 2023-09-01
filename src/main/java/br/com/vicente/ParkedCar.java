package br.com.vicente;

import java.time.Instant;

public class ParkedCar {

    private String plate;
    private Instant checkingDate;

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
}
