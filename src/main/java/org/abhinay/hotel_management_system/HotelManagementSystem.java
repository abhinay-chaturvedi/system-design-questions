package org.abhinay.hotel_management_system;

import org.abhinay.hotel_management_system.payment.Payment;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class HotelManagementSystem {
    private static HotelManagementSystem instance;
    private final Map<String, Room> rooms;
    private final Map<String, Reservation> reservations;
    private final Map<String, Guest> guests;

    public HotelManagementSystem() {
        this.rooms = new ConcurrentHashMap<>();
        this.reservations = new ConcurrentHashMap<>();
        this.guests = new ConcurrentHashMap<>();
    }
    public synchronized static  HotelManagementSystem getInstance() {
        if(instance == null) {
            instance = new HotelManagementSystem();
        }
        return instance;
    }
    public void addGuest(Guest guest) {
        this.guests.put(guest.getId(), guest);
    }
    public Guest getGuest(String guestId) {
        return this.guests.getOrDefault(guestId, null);
    }
    public void addRoom(Room room) {
        this.rooms.put(room.getId(), room);
    }
    public Room getRoom(String roomId) {
        return this.rooms.getOrDefault(roomId, null);
    }
    public synchronized Reservation bookRoom(Guest guest, Room room, LocalDate checkInDate, LocalDate checkOutDate) {
        if(room.getRoomStatus() == RoomStatus.AVAILABLE) {
            room.bookRoom(guest);
            String id = generateId();
            Reservation reservation = new Reservation(id, guest, room, checkInDate, checkOutDate);
            this.reservations.put(id, reservation);
            return reservation;
        }
        return null;
    }
    public synchronized void cancelReservation(String reservationId) {
        Reservation reservation = this.reservations.getOrDefault(reservationId, null);
        if(reservation == null) {
            System.out.println("reservation does not exist!");
        } else {
            System.out.println("cancelling the reservation!");
            reservation.cancel();
            this.reservations.remove(reservationId);
        }
    }
    public synchronized void checkIn(String reservationId) {
        Reservation reservation = this.reservations.getOrDefault(reservationId, null);
        if(reservation != null && reservation.getReservationStatus() == ReservationStatus.CONFIRMED) {
            reservation.getRoom().checkIn();
        } else {
            throw new IllegalStateException("Invalid reservation or reservation is not confirmed!");
        }
    }
    public synchronized void checkOut(String reservationId, Payment payment) {
        Reservation reservation = this.reservations.getOrDefault(reservationId, null);
        if(reservation == null) {
            System.out.println("Reservation does not exists!");
            return ;
        }
        if(reservation.getReservationStatus() == ReservationStatus.CONFIRMED) {
            Room room = reservation.getRoom();
            double amount = room.getPrice() * ChronoUnit.DAYS.between(reservation.getCheckInDate(), reservation.getCheckOutDate());
            if(payment.processPayment(amount)) {
                room.checkOut();
                this.reservations.remove(reservationId);
            } else {
                throw new IllegalStateException("Payment failed!");
            }
        }

    }


    private String generateId() {
        return "RES" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
}
