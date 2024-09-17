package org.abhinay.parking_lot;

import org.abhinay.parking_lot.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private static ParkingLot instance;
    private List<Level> levels;

    // To make use of singleton pattern we need to make the constructor private;
    private ParkingLot() {
        this.levels = new ArrayList<>();
    }
    // If u want to make it thread safe then u can just make use of
    // the synchronised keyword;
    public static synchronized ParkingLot getInstance() {
        if(instance == null) {
            instance = new ParkingLot();
        }
        return instance;
    }
    public List<Level> getLevel () {
        return levels;
    }
    public Level setLevel(Level level) {
        levels.add(level);
        return level;
    }
    public boolean parkVehicle(Vehicle vehicle) {

        for(Level level: levels) {
            if(level.parkVehicle(vehicle)) {
                System.out.println("Vehicle parked successfully");
                return true;
            }
        }
        return false;
    }
    public boolean unParkVehicle(Vehicle vehicle) {
        for(Level level: levels) {
            if(level.unParkVehicle(vehicle)) {
                System.out.println("Vehicle unParked successfully");
                return true;
            }
        }
        return false;
    }
    public void displayAvailability() {
        for(Level level: levels) {
            level.displayAvailability();
        }
    }
}
