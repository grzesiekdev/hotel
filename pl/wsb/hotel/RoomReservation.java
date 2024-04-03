package pl.wsb.hotel;

import java.time.LocalDate;

public class RoomReservation {
    private LocalDate date;
    private Boolean isConfirmed;
    private Client client;
    private Room room;

    public RoomReservation(LocalDate date, Client client, Room room) {
        this.date = date;
        this.isConfirmed = false;
        this.client = client;
        this.room = room;
    }

    public void confirmReservation() {
        this.isConfirmed = true;
    }

    public String getReservationInfo() {
        return String.format("Date: %s, is confirmed: %s, client: %s, room: %s, description: %s", this.date, this.isConfirmed, this.client.getFullName(), this.room.getId(), this.room.getDescription());
    }
}
