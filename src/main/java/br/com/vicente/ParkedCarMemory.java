package br.com.vicente;

import java.util.HashMap;
import java.util.Map;

public class ParkedCarMemory implements ParkedCarDAO {

    private Map<String,ParkedCar> parkedCars = new HashMap<>();

    @Override
    public void save(ParkedCar parkedCar) {
        this.parkedCars.put(parkedCar.getPlate(),parkedCar);
    }

    @Override
    public void update(ParkedCar parkedCar) {
        this.parkedCars.put(parkedCar.getPlate(),parkedCar);
    }

    @Override
    public ParkedCar get(String plate) {
        return this.parkedCars.get(plate);
    }
}
