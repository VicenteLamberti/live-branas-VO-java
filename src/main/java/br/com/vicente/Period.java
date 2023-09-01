package br.com.vicente;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Period {
    private LocalDateTime start;
    private LocalDateTime end;

    public Period(LocalDateTime start, LocalDateTime end) {
        if(start.isAfter(end)){
            throw new RuntimeException("Invalid period");
        }
        this.start = start;
        this.end = end;
    }

    public long getDurationInHours(){
        return Duration.between(start, end).toHours();
    }
}
