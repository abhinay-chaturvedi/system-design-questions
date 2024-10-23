package org.abhinay.hotel_management_system;

import java.time.LocalDate;

public class Reservation {
    private final String id;
    private final Guest guest;
    private final Room room;
    private ReservationStatus reservationStatus;
    private final LocalDate checkInDate;
    private final LocalDate checkOutDate;

    public Reservation(String id, Guest guest, Room room, LocalDate checkInDate, LocalDate checkOutDate) {
        this.id = id;
        this.guest = guest;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.reservationStatus = ReservationStatus.CONFIRMED;
    }
    public synchronized void cancel() {
        if(this.reservationStatus == ReservationStatus.CONFIRMED) {
            this.reservationStatus = ReservationStatus.CANCELLED;
            this.room.checkOut();
        } else {
            throw new IllegalStateException("Reservation is not confirmed!");
        }
    }
    public Guest getGuest() {
        return guest;
    }

    public String getId() {
        return id;
    }

    public Room getRoom() {
        return room;
    }

    public ReservationStatus getReservationStatus() {
        return reservationStatus;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }
}
