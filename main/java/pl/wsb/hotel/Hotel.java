package pl.wsb.hotel;

import pl.wsb.hotel.exceptions.ClientNotFoundException;
import pl.wsb.hotel.exceptions.ReservationNotFoundException;
import pl.wsb.hotel.exceptions.RoomNotFoundException;
import pl.wsb.hotel.exceptions.RoomReservedException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

public class Hotel implements HotelCapability {
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
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addSpecialService(SpecialService specialService) {
        this.specialServices.add(specialService);
    }

    @Override
    public String addClient(String firstName, String lastName, LocalDate birthDate) {
        Client client = new Client(firstName, lastName, birthDate);
        this.clients.add(client);

        return client.getId();
    }

    public void addRoomReservation(RoomReservation roomReservation) {
        this.roomReservations.add(roomReservation);
    }

    public void addRoom(Room room) {
        this.rooms.add(room);
    }

    @Override
    public String getClientFullName(String clientId) {
        Client client = this.findClientById(clientId);
        if (client != null) {
            return client.getFullName();
        } else {
            return "Client not found";
        }
    }

    @Override
    public int getNumberOfUnderageClients() {
        int counter = 0;
        for (Client client : this.clients) {
            if (client.getAge() < 18) {
                counter++;
            }
        }

        return counter;
    }

    @Override
    public String addRoom(double area, int floor, boolean hasKingSizeBed, String description) {
        Room room = new Room(area, floor, hasKingSizeBed, description);
        this.rooms.add(room);

        return room.getId();
    }

    @Override
    public double getRoomArea(String roomId) {
        Room room = this.findRoomById(roomId);
        if (room != null) {
            return room.getArea();
        } else {
            return 0;
        }
    }

    @Override
    public int getNumberOfRoomsWithKingSizeBed(int floor) {
        int counter = 0;
        for (Room room : this.rooms) {
            if ((room.getFloor() == floor) && room.getHasKingSizeBed()) {
                counter++;
            }
        }

        return counter;
    }

    @Override
    public String addNewReservation(String clientId, String roomId, LocalDate date) throws ClientNotFoundException, RoomNotFoundException, RoomReservedException {
        Client client = this.findClientById(clientId);
        Room room = this.findRoomById(roomId);
        RoomReservation roomReservationCheck = this.findRoomReservationByRoomId(roomId);

        if (client == null) {
            throw new ClientNotFoundException("Client not found");
        }
        else if (room == null) {
            throw new RoomNotFoundException("Room not found");
        }
        else if ((roomReservationCheck != null) && (roomReservationCheck.getDate().equals(date))) {
            throw new RoomReservedException(roomId, date);
        }
        else {
            RoomReservation roomReservation = new RoomReservation(clientId, roomId, date);
            this.roomReservations.add(roomReservation);
            client.addRoomIdToReservationHistory(roomReservation.getId());
            return roomReservation.getId();
        }

    }

    @Override
    public String confirmReservation(String reservationId) throws ReservationNotFoundException {
        RoomReservation roomReservation = this.findRoomReservationById(reservationId);
        if (roomReservation == null) {
            throw new ReservationNotFoundException("Reservation not found");
        } else {
            roomReservation.confirmReservation();
            return roomReservation.getId();
        }
    }

    @Override
    public boolean isRoomReserved(String roomId, LocalDate date) throws RoomNotFoundException {
        Room room = this.findRoomById(roomId);
        if (room == null) {
            throw new RoomNotFoundException("Room not found");
        } else {
            RoomReservation roomReservationCheck = this.findRoomReservationByRoomId(roomId);
            return (roomReservationCheck != null) && (roomReservationCheck.getDate().equals(date));
        }
    }

    @Override
    public int getNumberOfUnconfirmedReservation(LocalDate date) {
        int counter = 0;
        for (RoomReservation roomReservation : this.roomReservations) {
            if (roomReservation.getDate().equals(date) && !roomReservation.getConfirmed()) {
                counter++;
            }
        }

        return counter;
    }

    @Override
    public Collection<String> getRoomIdsReservedByClient(String clientId) throws ClientNotFoundException {
        Client client = this.findClientById(clientId);
        if (client == null) {
            throw new ClientNotFoundException("Client not found");
        } else {
            return client.getRoomIdHistory();
        }
    }

    private Client findClientById(String clientId) {
        for (Client client : this.clients) {
            if (client.getId().equals(clientId)) {
                return client;
            }
        }
        return null;
    }

    private Room findRoomById(String roomId) {
        for (Room room : this.rooms) {
            if (room.getId().equals(roomId)) {
                return room;
            }
        }
        return null;
    }

    private RoomReservation findRoomReservationByRoomId(String roomId) {
        for (RoomReservation roomReservation : this.roomReservations) {
            if (roomReservation.getRoom().equals(roomId)) {
                return roomReservation;
            }
        }
        return null;
    }

    private RoomReservation findRoomReservationById(String roomReservationId) {
        for (RoomReservation roomReservation : this.roomReservations) {
            if (roomReservation.getId().equals(roomReservationId)) {
                return roomReservation;
            }
        }
        return null;
    }
}
