package br.com.vicente;

public interface ParkedCarDAO {

    void save(ParkedCar parkedCar);
    void update(ParkedCar parkedCar);
    ParkedCar get(Plate plate);
}
