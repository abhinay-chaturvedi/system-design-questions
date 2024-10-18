package org.abhinay.car_rental_system;

public class Car {
    private final String make;
    private final String model;
    private final long year;
    private final String lic_plate_num;
    private final double rentalPrice;
    private boolean available;

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public long getYear() {
        return year;
    }

    public String getLic_plate_num() {
        return lic_plate_num;
    }

    public double getRentalPrice() {
        return rentalPrice;
    }

    public boolean isAvailable() {
        return available;
    }

    public Car(String make, String model, long year, String licPlateNum, double rentalPrice) {
        this.make = make;
        this.model = model;
        this.year = year;
        lic_plate_num = licPlateNum;
        this.rentalPrice = rentalPrice;
        this.available = true;
    }
}
