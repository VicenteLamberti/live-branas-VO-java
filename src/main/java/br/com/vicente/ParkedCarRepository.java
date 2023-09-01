package br.com.vicente;

public interface ParkedCarRepository {

    void save(ParkedCar parkedCar);
    void update(ParkedCar parkedCar);
    ParkedCar get(String plate);
}
