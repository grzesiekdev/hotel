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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Boolean getConfirmed() {
        return isConfirmed;
    }

    public void setConfirmed(Boolean confirmed) {
        isConfirmed = confirmed;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "RoomReservation{" +
                "date=" + date +
                ", isConfirmed=" + isConfirmed +
                '}';
    }
}
