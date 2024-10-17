package org.abhinay.car_rental_system;

import java.util.Date;

public class Reservation {
    private final String id;
    private Customer customer;
    private Car car;
    private Date startDate;
    private Date endDate;
    private double totalPrice;

    public Reservation(String id) {
        this.id = id;
    }
}
