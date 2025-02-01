package org.abhinay.hotel_management_system;

import org.abhinay.hotel_management_system.payment.CreditCardPayment;
import org.abhinay.hotel_management_system.payment.Payment;

import java.time.LocalDate;

public class HotelManagementDemo {
    public void run() {
        HotelManagementSystem hotelManagementSystem = HotelManagementSystem.getInstance();
        Guest guest1 = new Guest("G001", "John Doe", "john@example.com", "1234567890");
        Guest guest2 = new Guest("G002", "Jane Smith", "jane@example.com", "9876543210");
        // Here i am stopping will start from here tomorrow
        hotelManagementSystem.addGuest(guest1);
        hotelManagementSystem.addGuest(guest2);
        Room room1 = new Room("R001", RoomType.SINGLE, 100.0);
        Room room2 = new Room("R002", RoomType.DOUBLE, 200.0);
        hotelManagementSystem.addRoom(room1);
        hotelManagementSystem.addRoom(room2);

        // here i am going to book the room
        LocalDate checkInDate = LocalDate.now();
        LocalDate checkOutDate = checkInDate.plusDays(3);
        Reservation reservation1 = hotelManagementSystem.bookRoom(guest1, room1, checkInDate, checkOutDate);
        if(reservation1 != null) {
            System.out.println("Reservation done!" + reservation1.getId());
        } else {
            System.out.println("Room not available!");
        }
        hotelManagementSystem.checkIn(reservation1.getId());
        System.out.println("CheckedIn: " + reservation1.getId());

        // here i am checking out
        Payment payment1 = new CreditCardPayment();
        hotelManagementSystem.checkOut(reservation1.getId(), payment1);
        System.out.println("CheckedOut: " + reservation1.getId());

        hotelManagementSystem.cancelReservation(reservation1.getId());
        System.out.println("Reservation cancelled: " + reservation1.getId());

    }
}
