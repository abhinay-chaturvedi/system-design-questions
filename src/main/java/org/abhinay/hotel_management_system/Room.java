package org.abhinay.hotel_management_system;

public class Room {
    private final String id;
    private final RoomType roomType;
    private final double price;
    private RoomStatus roomStatus;
    private Guest guest;

    public Room(String id, RoomType roomType, double price) {
        this.id = id;
        this.roomType = roomType;
        this.price = price;
        this.roomStatus = RoomStatus.AVAILABLE;
        this.guest = null;
    }
    // Here is the method to book the room
    public synchronized void bookRoom(Guest guest) {
        if(this.roomStatus != RoomStatus.AVAILABLE) {
            throw new IllegalStateException("Room is not available for booking!");
        } else {
            this.roomStatus = RoomStatus.BOOKED;
            this.guest = guest;
        }
    }
    // Here is the method to check in to the room
    public synchronized void checkIn() {
        if(this.roomStatus != RoomStatus.BOOKED) {
            throw new IllegalStateException("Room is not booked!");
        } else {
            this.roomStatus = RoomStatus.OCCUPIED;
        }
    }
    // Here is the method to check out from the room
    public void checkOut() {
        if(this.roomStatus != RoomStatus.OCCUPIED) {
            throw new IllegalStateException("Room is not occupied!");
        } else {
            this.roomStatus = RoomStatus.AVAILABLE;
            this.guest = null;
        }

    }

    public String getId() {
        return id;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public double getPrice() {
        return price;
    }

    public RoomStatus getRoomStatus() {
        return roomStatus;
    }

    public Guest getGuest() {
        return guest;
    }
}
