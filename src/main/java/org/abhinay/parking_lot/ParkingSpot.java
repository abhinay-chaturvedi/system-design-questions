package org.abhinay.parking_lot;

import org.abhinay.parking_lot.vehicle.Vehicle;
import org.abhinay.parking_lot.vehicle.VehicleType;

public class ParkingSpot {
    private boolean isAvailable;
    private Vehicle parkedVehicle;
    private final VehicleType type;
    private final int spotNumber;

    public ParkingSpot(VehicleType type, int spotNumber) {
        this.isAvailable = true;
        this.parkedVehicle = null;
        this.type = type;
        this.spotNumber = spotNumber;
    }
    public boolean getAvailability() {
        return this.isAvailable;
    }
    public boolean setAvailability() {
        this.isAvailable = true;
        return true;
    }
    public boolean resetAvailability() {
        this.isAvailable = false;
         return true;
    }
    public int getSpotNumber() {
        return spotNumber;
    }
    public VehicleType getVehicleType() {
        return type;
    }
    public boolean park(Vehicle vehicle) {
        this.parkedVehicle = vehicle;
//        this.type = vehicle.getVehicleType();
        this.isAvailable = false;
        return true;
    }
    public boolean unPark(Vehicle vehicle) {
        if(vehicle.equals(this.parkedVehicle)) {
            this.parkedVehicle = null;
            this.isAvailable = true;
            return true;
        }

        return false;
    }

}
