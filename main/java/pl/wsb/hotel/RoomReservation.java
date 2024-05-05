package pl.wsb.hotel;

import java.time.LocalDate;
import java.util.UUID;

public class RoomReservation {
    private String id;
    private LocalDate date;
    private Boolean isConfirmed;
    private String clientId;
    private String roomId;

    public RoomReservation(String clientId, String roomId, LocalDate date) {
        this.id = UUID.randomUUID().toString();
        this.date = date;
        this.isConfirmed = false;
        this.clientId = clientId;
        this.roomId = roomId;
    }

    public String getId() {
        return id;
    }

    public void confirmReservation() {
        this.isConfirmed = true;
    }

    public String getReservationInfo() {
        return String.format("Date: %s, is confirmed: %s, client: %s, room: %s", this.date, this.isConfirmed, this.clientId, this.roomId);
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getClientId() {
        return this.clientId;
    }

    public void setClient(String clientId) {
        this.clientId = clientId;
    }

    public Boolean getConfirmed() {
        return isConfirmed;
    }

    public void setConfirmed(Boolean confirmed) {
        isConfirmed = confirmed;
    }

    public String getRoom() {
        return this.roomId;
    }

    public void setRoom(String roomId) {
        this.roomId = roomId;
    }

    @Override
    public String toString() {
        return "RoomReservation{" +
                "date=" + date +
                ", isConfirmed=" + isConfirmed +
                '}';
    }
}
