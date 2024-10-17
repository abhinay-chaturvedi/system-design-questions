package org.abhinay.car_rental_system;

public class CarRentalSystem {

    private static CarRentalSystem instance;


    public static CarRentalSystem getInstance() {
        if(instance  == null) {
            instance = new CarRentalSystem();
        }
        return instance;
    }
}
