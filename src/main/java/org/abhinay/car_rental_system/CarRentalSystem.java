package org.abhinay.car_rental_system;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class CarRentalSystem {

    private static CarRentalSystem instance;
    private final Map<String, Car> cars;
    private final Map<String, Reservation> reservations;
    private final PaymentProcessor paymentProcessor;

    public CarRentalSystem() {
        this.cars = new ConcurrentHashMap<>();
        this.reservations = new ConcurrentHashMap<>();
        this.paymentProcessor = new CreditCardPaymentProcessor();
    }


    public static synchronized CarRentalSystem getInstance() {
        if(instance  == null) {
            instance = new CarRentalSystem();
        }
        return instance;
    }
    public void addCar(Car car) {
        this.cars.put(car.getLic_plate_num(), car);
    }
    public void removeCar(String licPlateNum) {
        this.cars.remove(licPlateNum);
    }
    public void addReservation(Reservation reservation) {
        this.reservations.put(reservation.getId(), reservation);
    }
    public List<Car> searchCars(String make, String model, LocalDate startDate, LocalDate endDate) {
        List<Car> cars = new ArrayList<>();
        for(Car car: this.cars.values()) {
            if(car.getMake().equalsIgnoreCase(make) && car.getModel().equalsIgnoreCase(model)) {
                // here we will have required car but we need to check whether this has been booked or not
                if(isCarAvailable(car, startDate, endDate)) cars.add(car);
            }
        }
        return  cars;
    }
    public boolean isCarAvailable(Car car, LocalDate startDate, LocalDate endDate) {
        for(Reservation reservation: reservations.values()) {
            if(car.equals(reservation.getCar())) {
                if(startDate.isBefore(reservation.getEndDate()) && endDate.isAfter(startDate)) return false;
            }
        }
        return true;
    }
    public synchronized Reservation makeReservation(Customer customer, Car car, LocalDate startDate, LocalDate endDate) {
        if(isCarAvailable(car, startDate, endDate)) {
            String reservationId = generateReservationId();
            Reservation reservation = new Reservation(reservationId, car, customer, startDate, endDate);
            this.reservations.put(reservationId, reservation);
            car.setAvailable(false);
            return reservation;
        }
        return null;
    }
    public synchronized void cancelReservation(String reservationId) {
        Reservation reservation = this.reservations.get(reservationId);
        this.reservations.remove(reservationId);
        if(reservation != null) {
            reservation.getCar().setAvailable(true);
        }

    }
    public boolean processPayment(Reservation reservation) {
        return paymentProcessor.processPayment(reservation.getTotalPrice());
    }
    public String generateReservationId() {
        return  "RES" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
    public void runCarRentalSystem() {
//        CarRentalSystem rentalSystem = CarRentalSystem.getInstance();
        this.addCar(new Car("Toyota", "Camry", 2022, "ABC123", 50.0));
        this.addCar(new Car("Honda", "Civic", 2021, "XYZ789", 45.0));
        this.addCar(new Car("Ford", "Mustang", 2023, "DEF456", 80.0));

        Customer customer1 = new Customer("Abhinay", "ABC321", "8756467641");
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plusDays(3);
        // here now first we will search the cars that are available for booking
        List<Car> list = this.searchCars("Honda", "Civic", startDate, endDate);
        System.out.println("hi there!" + list.size());
//        list.stream().forEach((item) -> {
//            System.out.println(item.getLic_plate_num());
//            System.out.println("hi inside");
////            return item;
//        });
        if(!list.isEmpty()) {
            System.out.println("yeah! car is available going to make the reservation");
            Car selectedCar = list.get(0);
            Reservation reservation = this.makeReservation(customer1, selectedCar, startDate, endDate);
            if(reservation != null) {
                boolean pStatus = paymentProcessor.processPayment(reservation.getTotalPrice());
                if(pStatus) {
                    System.out.println("payment success");
                    System.out.println("Your order has been placed!" + reservation.getId());
                } else {
                    System.out.println("Payment failed!");
                    this.cancelReservation(reservation.getId());
                }
            } else {
                System.out.println("This particular car is not available for the booking!");
            }
        } else {
            System.out.println("There is no car available right now.");
        }
    }
}
