package br.com.vicente;

import java.time.Instant;

public class FakerClock implements Clock{

    private Instant currentDate = Instant.now();
    @Override
    public Instant getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Instant date){
        this.currentDate = date;
    }
}
