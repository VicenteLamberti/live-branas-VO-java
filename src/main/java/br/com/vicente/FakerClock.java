package br.com.vicente;

import java.time.Instant;
import java.time.LocalDateTime;

public class FakerClock implements Clock{

    private LocalDateTime currentDate = LocalDateTime.now();
    @Override
    public LocalDateTime getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(LocalDateTime date){
        this.currentDate = date;
    }
}
