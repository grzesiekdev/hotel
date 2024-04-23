package pl.wsb.hotel;

import java.util.ArrayList;

public class Hotel {
    private String name;
    private ArrayList<SpecialService> specialServices;
    private ArrayList<Client> clients;
    private ArrayList<RoomReservation> roomReservations;
    private ArrayList<Room> rooms;

    public Hotel(String name) {
        this.name = name;
        this.specialServices = new ArrayList<>();
        this.clients = new ArrayList<>();
        this.roomReservations = new ArrayList<>();
        this.rooms = new ArrayList<>();
    }

    public ArrayList<SpecialService> getSpecialServices() {
        return specialServices;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public ArrayList<RoomReservation> getRoomReservations() {
        return roomReservations;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addSpecialService(SpecialService specialService) {
        this.specialServices.add(specialService);
    }

    public void addClient(Client client) {
        this.clients.add(client);
    }

    public void addRoomReservation(RoomReservation roomReservation) {
        this.roomReservations.add(roomReservation);
    }

    public void addRoom(Room room) {
        this.rooms.add(room);
    }
}
