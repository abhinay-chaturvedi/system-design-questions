package org.abhinay.parking_lot;

import org.abhinay.parking_lot.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Level {
    private List<ParkingSpot> parkingSpots;
    private final int floor;

    public Level(int floor) {
        this.floor = floor;
        this.parkingSpots = new ArrayList<>();
    }

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }
    public ParkingSpot setParkingSpot(ParkingSpot parkingSpot) {
        parkingSpots.add(parkingSpot);
        return parkingSpot;
    }
    // if u want the parking thread safe then we can utilize synchronised keyword
    public synchronized boolean parkVehicle(Vehicle vehicle) {
        for(ParkingSpot parkingSpot: parkingSpots) {
            if(parkingSpot.getAvailability() && parkingSpot.getVehicleType() == vehicle.getVehicleType()){
                return parkingSpot.park(vehicle);
            }
        }
        return false;
    }
    public synchronized boolean unParkVehicle(Vehicle vehicle) {
        for(ParkingSpot parkingSpot: parkingSpots) {
            if(!parkingSpot.getAvailability() && parkingSpot.unPark(vehicle)) {
                return true;
            }
        }
        return false;
    }
    public void displayAvailability() {

        System.out.println("Level " + floor + " Availability:");
        for(ParkingSpot parkingSpot: parkingSpots) {
            System.out.println("Spot " + parkingSpot.getSpotNumber() + ": " + (parkingSpot.getAvailability() ? "Available For"  : "Occupied By ")+" "+parkingSpot.getVehicleType());
        }
    }
}
