package br.com.vicente;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

public interface Clock {

    LocalDateTime getCurrentDate();
}
