package org.abhinay.parking_lot;

import org.abhinay.parking_lot.vehicle.Vehicle;
import org.abhinay.parking_lot.vehicle.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class Level {
    private List<ParkingSpot> parkingSpots;
    private final int floor;

    public Level(int floor, int numSpots) {
        this.floor = floor;
        this.parkingSpots = new ArrayList<>(numSpots);
        // So Basically we are going to create the spots in the ration 50, 40, 10
        // 50 for bikes, 40 cars and 10 trucks
        int numBikes = (int) (.5 * numSpots);
        int numCars = (int) (.4 * numSpots);
        for(int i = 1; i <= numBikes; i++) {
            this.parkingSpots.add(new ParkingSpot(VehicleType.MOTORCYCLE, i));
        }
        for(int i = numBikes + 1; i <= numBikes + numCars; i++) {
            this.parkingSpots.add(new ParkingSpot(VehicleType.CAR, i));
        }
        for(int i = numBikes + numCars + 1; i <= numSpots; i++) {
            this.parkingSpots.add(new ParkingSpot(VehicleType.TRUCK, i));
        }
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
