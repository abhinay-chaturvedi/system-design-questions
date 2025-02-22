package org.abhinay.parking_lot;

import org.abhinay.parking_lot.vehicle.Car;
import org.abhinay.parking_lot.vehicle.Motorcycle;
import org.abhinay.parking_lot.vehicle.Truck;

public class ParkingLotDemo {
    public void run() {
        System.out.println("Running parking lot system!");
        ParkingLot parkingLot  = ParkingLot.getInstance();
        Level level1 = new Level(1, 4);
//        level1.setParkingSpot(new ParkingSpot(VehicleType.CAR, 1));
//        level1.setParkingSpot(new ParkingSpot(VehicleType.TRUCK, 2));
//        level1.setParkingSpot(new ParkingSpot(VehicleType.MOTORCYCLE, 3));
        Level level2 = new Level(2, 3);
//        level2.setParkingSpot(new ParkingSpot(VehicleType.CAR, 1));
//        level2.setParkingSpot(new ParkingSpot(VehicleType.TRUCK, 2));
//        level2.setParkingSpot(new ParkingSpot(VehicleType.MOTORCYCLE, 3));
        parkingLot.setLevel(level1);
        parkingLot.setLevel(level2);
        parkingLot.displayAvailability();
        Car car1 = new Car("123");
        Car car2 = new Car("124");
        Truck truck1 = new Truck("321");
        Truck truck2 = new Truck("421");
        Motorcycle motor1 = new Motorcycle("motor1");
        Motorcycle motor2 = new Motorcycle("motor2");
        parkingLot.parkVehicle(car1);
        parkingLot.parkVehicle(motor1);
        parkingLot.parkVehicle(truck1);
        parkingLot.parkVehicle(car2);
        parkingLot.parkVehicle(truck2);
        parkingLot.parkVehicle(motor2);
        parkingLot.unParkVehicle(car2);
        parkingLot.displayAvailability();
    }
}
