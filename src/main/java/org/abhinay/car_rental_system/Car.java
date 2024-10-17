package org.abhinay.car_rental_system;

public class Car {
    private final String model;
    private final long year;
    private final String lic_plate_num;
    private final double rentalPrice;

    public Car(String model, long year, String licPlateNum, double rentalPrice) {
        this.model = model;
        this.year = year;
        lic_plate_num = licPlateNum;
        this.rentalPrice = rentalPrice;
    }
}
