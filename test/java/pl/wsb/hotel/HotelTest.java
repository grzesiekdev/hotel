package pl.wsb.hotel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.wsb.hotel.exceptions.ClientNotFoundException;
import pl.wsb.hotel.exceptions.ReservationNotFoundException;
import pl.wsb.hotel.exceptions.RoomNotFoundException;
import pl.wsb.hotel.exceptions.RoomReservedException;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

class HotelTest {
    Hotel hotel;
    @BeforeEach
    void setUp() {
        hotel = new Hotel("Test hotel");
    }

    @Test
    public void testGetSpecialServices_ReturnsEmptyList_WhenNoSpecialServices() {
        ArrayList<SpecialService> result = hotel.getSpecialServices();

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testGetSpecialServices_ReturnsCorrectList() {
        SpecialService timeService = new TimeService("Time Service");
        SpecialService luggageService = new LuggageService("Luggage service");
        ArrayList<SpecialService> expected = new ArrayList<>(Arrays.asList(timeService, luggageService));

        hotel.addSpecialService(timeService);
        hotel.addSpecialService(luggageService);

        ArrayList<SpecialService> result = hotel.getSpecialServices();

        assertEquals(expected.size(), result.size());
        assertTrue(result.containsAll(expected));
    }

    @Test
    public void testGetClients_ReturnsEmptyList_WhenNoClients() {
        ArrayList<Client> result = hotel.getClients();

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testGetAndSetClients_ReturnsCorrectList() {
        String client1Id = hotel.addClient("John", "Doe", LocalDate.of(1985, 5, 15));
        String client2Id = hotel.addClient("Jane", "Smith", LocalDate.of(1990, 8, 20));

        Client client1 = this.findClientById(hotel.getClients(), client1Id);
        Client client2 = this.findClientById(hotel.getClients(), client2Id);

        ArrayList<Client> expected = new ArrayList<>();
        expected.add(client1);
        expected.add(client2);

        ArrayList<Client> result = hotel.getClients();
        assertEquals(expected.size(), result.size());
        assertTrue(result.containsAll(expected));
    }

    @Test
    public void testGetRoomReservations_ReturnsEmptyList_WhenNoReservations() {
        ArrayList<RoomReservation> result = hotel.getRoomReservations();

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testGetRoomReservations_ReturnsCorrectList() {
        Client client = new Client("John", "Doe", LocalDate.of(1985, 5, 15));
        Room room1 = new Room(20.0, 1, true, "Room 101");
        Room room2 = new Room(25.0, 2, false, "Room 102");
        RoomReservation reservation1 = new RoomReservation(client.getId(), room1.getId(), LocalDate.of(2024, 5, 1));
        RoomReservation reservation2 = new RoomReservation(client.getId(), room2.getId(), LocalDate.of(2024, 5, 2));
        ArrayList<RoomReservation> expected = new ArrayList<>();
        expected.add(reservation1);
        expected.add(reservation2);

        hotel.addRoomReservation(reservation1);
        hotel.addRoomReservation(reservation2);

        ArrayList<RoomReservation> result = hotel.getRoomReservations();

        assertEquals(expected.size(), result.size());
        assertTrue(result.containsAll(expected));
    }

    @Test
    public void testGetRooms_ReturnsEmptyList_WhenNoRooms() {
        ArrayList<Room> result = hotel.getRooms();

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testGetRooms_ReturnsCorrectList() {
        Room room1 = new Room(20.0, 1, true, "Room 101");
        Room room2 = new Room(25.0, 2, false, "Room 102");
        ArrayList<Room> expected = new ArrayList<>();
        expected.add(room1);
        expected.add(room2);

        hotel.addRoom(room1);
        hotel.addRoom(room2);

        ArrayList<Room> result = hotel.getRooms();

        assertEquals(expected.size(), result.size());
        assertTrue(result.containsAll(expected));
    }

    @Test
    public void testGetName_ReturnsCorrectName() {
        String expectedName = "Test hotel";

        String result = hotel.getName();

        assertEquals(expectedName, result);
    }

    @Test
    public void testSetName_SetsCorrectName() {
        String newName = "New Test hotel";

        hotel.setName(newName);

        assertEquals(newName, hotel.getName());
    }

    @Test
    public void testGetClientFullName_ReturnsFullName_WhenClientExists() {
        String clientId = hotel.addClient("John", "Doe", LocalDate.of(1985, 5, 15));

        String result = hotel.getClientFullName(clientId);

        assertEquals("John Doe", result);
    }

    @Test
    public void testGetClientFullName_ReturnsClientNotFound_WhenClientDoesNotExist() {
        String result = hotel.getClientFullName("nonexistentId");

        assertEquals("Client not found", result);
    }

    @Test
    public void testGetNumberOfUnderageClients_ReturnsZero_WhenNoUnderageClients() {
        int result = hotel.getNumberOfUnderageClients();

        assertEquals(0, result);
    }

    @Test
    public void testGetNumberOfUnderageClients_ReturnsCorrectCount() {
        hotel.addClient("John", "Doe", LocalDate.of(2009, 5, 15));
        hotel.addClient("Jane", "Smith", LocalDate.of(2002, 8, 20));
        hotel.addClient("Alex", "Brown", LocalDate.of(1998, 10, 10));
        hotel.addClient("Emily", "Johnson", LocalDate.of(2010, 3, 25));

        int result = hotel.getNumberOfUnderageClients();

        assertEquals(2, result);
    }

    @Test
    public void testGetRoomArea_ReturnsZero_WhenRoomNotFound() {
        double result = hotel.getRoomArea("nonexistentId");

        assertEquals(0.0, result);
    }

    @Test
    public void testGetRoomArea_ReturnsCorrectArea() {
        Room room1 = new Room(20.0, 1, true, "Room 101");
        Room room2 = new Room(25.0, 2, false, "Room 102");
        hotel.addRoom(room1);
        hotel.addRoom(room2);

        double result1 = hotel.getRoomArea(room1.getId());
        double result2 = hotel.getRoomArea(room2.getId());

        assertEquals(20.0, result1);
        assertEquals(25.0, result2);
    }

    @Test
    public void testGetNumberOfRoomsWithKingSizeBed_ReturnsZero_WhenNoMatchingRooms() {
        int result = hotel.getNumberOfRoomsWithKingSizeBed(1);

        assertEquals(0, result);
    }

    @Test
    public void testGetNumberOfRoomsWithKingSizeBed_ReturnsCorrectCount() {
        Room room1 = new Room(20.0, 1, true, "Room 101");
        Room room2 = new Room(25.0, 1, true, "Room 102");
        Room room3 = new Room(22.0, 2, false, "Room 201");
        Room room4 = new Room(18.0, 3, true, "Room 301");
        hotel.addRoom(room1);
        hotel.addRoom(room2);
        hotel.addRoom(room3);
        hotel.addRoom(room4);

        int resultFloor1 = hotel.getNumberOfRoomsWithKingSizeBed(1);
        int resultFloor2 = hotel.getNumberOfRoomsWithKingSizeBed(2);
        int resultFloor3 = hotel.getNumberOfRoomsWithKingSizeBed(3);

        assertEquals(2, resultFloor1);
        assertEquals(0, resultFloor2);
        assertEquals(1, resultFloor3);
    }

    @Test
    public void testAddNewReservation_AddsReservationSuccessfully() throws ClientNotFoundException, RoomNotFoundException, RoomReservedException {
        LocalDate date = LocalDate.of(2024, 5, 10);

        String clientId = hotel.addClient("John", "Doe", LocalDate.of(1985, 5, 15));
        String roomId = hotel.addRoom(20.0, 1, true, "Room 101");

        String reservationId = hotel.addNewReservation(clientId, roomId, date);

        assertNotNull(reservationId);
    }

    @Test
    public void testAddNewReservation_ThrowsClientNotFoundException() {
        Room room = new Room(20.0, 1, true, "Room 101");

        LocalDate date = LocalDate.of(2024, 5, 10);
        String invalidClientId = "invalidClientId";

        assertThrows(ClientNotFoundException.class, () -> {
            hotel.addNewReservation(invalidClientId, room.getId(), date);
        });
    }

    @Test
    public void testAddNewReservation_ThrowsRoomNotFoundException() {
        String clientId = hotel.addClient("John", "Doe", LocalDate.of(1985, 5, 15));

        LocalDate date = LocalDate.of(2024, 5, 10);
        String invalidRoomId = "invalidRoomId";

        assertThrows(RoomNotFoundException.class, () -> {
            hotel.addNewReservation(clientId, invalidRoomId, date);
        });
    }

    @Test
    public void testAddNewReservation_ThrowsRoomReservedException() throws ClientNotFoundException, RoomNotFoundException, RoomReservedException {
        String clientId = hotel.addClient("John", "Doe", LocalDate.of(1985, 5, 15));
        String roomId = hotel.addRoom(20.0, 1, true, "Room 101");

        LocalDate date = LocalDate.of(2024, 5, 10);
        hotel.addNewReservation(clientId, roomId, date);

        assertThrows(RoomReservedException.class, () -> {
            hotel.addNewReservation(clientId, roomId, date);
        });
    }

    @Test
    public void testConfirmReservation_ConfirmsReservationSuccessfully() throws ReservationNotFoundException, ClientNotFoundException, RoomNotFoundException {
        String clientId = hotel.addClient("John", "Doe", LocalDate.of(1985, 5, 15));
        String roomId = hotel.addRoom(20.0, 1, true, "Room 101");

        LocalDate date = LocalDate.of(2024, 5, 10);
        String reservationId = hotel.addNewReservation(clientId, roomId, date);

        RoomReservation roomReservation = findRoomReservationById(hotel.getRoomReservations(), reservationId);

        hotel.addRoomReservation(roomReservation);
        String confirmedReservationId = hotel.confirmReservation(reservationId);

        assertNotNull(confirmedReservationId);
        assert roomReservation != null;
        assertTrue(roomReservation.getConfirmed());
    }

    @Test
    public void testConfirmReservation_ThrowsReservationNotFoundException() {
        String invalidReservationId = "invalidReservationId";

        assertThrows(ReservationNotFoundException.class, () -> {
            hotel.confirmReservation(invalidReservationId);
        });
    }

    @Test
    public void testIsRoomReserved_ReturnsTrue_WhenRoomIsReservedOnSpecifiedDate() throws RoomNotFoundException, ClientNotFoundException {
        LocalDate date = LocalDate.of(2024, 5, 10);
        String roomId = hotel.addRoom(20.0, 1, true, "Room 101");
        String clientId = hotel.addClient("John", "Doe", LocalDate.of(1985, 5, 15));

        String reservationId = hotel.addNewReservation(clientId, roomId, date);
        hotel.confirmReservation(reservationId);

        boolean result = hotel.isRoomReserved(roomId, date);

        assertTrue(result);
    }

    @Test
    public void testIsRoomReserved_ReturnsFalse_WhenRoomIsNotReservedOnSpecifiedDate() throws RoomNotFoundException {
        LocalDate date = LocalDate.of(2024, 5, 11);
        String roomId = hotel.addRoom(20.0, 1, true, "Room 101");

        boolean result = hotel.isRoomReserved(roomId, date);

        assertFalse(result);
    }

    @Test
    public void testIsRoomReserved_ThrowsRoomNotFoundException() {
        String invalidRoomId = "invalidRoomId";
        LocalDate date = LocalDate.of(2024, 5, 10);

        assertThrows(RoomNotFoundException.class, () -> {
            hotel.isRoomReserved(invalidRoomId, date);
        });
    }

    @Test
    public void testGetNumberOfUnconfirmedReservation_ReturnsZero_WhenNoUnconfirmedReservations() {
        LocalDate date = LocalDate.of(2024, 5, 10);

        int result = hotel.getNumberOfUnconfirmedReservation(date);

        assertEquals(0, result);
    }

    @Test
    public void testGetNumberOfUnconfirmedReservation_ReturnsCorrectCount() {
        LocalDate date = LocalDate.of(2024, 5, 10);
        RoomReservation reservation1 = new RoomReservation("1", "1", date);
        RoomReservation reservation2 = new RoomReservation("2", "2", date);
        RoomReservation reservation3 = new RoomReservation("3", "3", date); // Different date
        reservation1.confirmReservation();
        hotel.addRoomReservation(reservation1);
        hotel.addRoomReservation(reservation2);
        hotel.addRoomReservation(reservation3);

        int result = hotel.getNumberOfUnconfirmedReservation(date);

        assertEquals(2, result);
    }

    @Test
    public void testGetRoomIdsReservedByClient_ReturnsEmptyCollection_WhenClientHasNoReservations() throws ClientNotFoundException {
        String clientId = hotel.addClient("John", "Doe", LocalDate.of(1990, 5, 15));
        Collection<String> result = hotel.getRoomIdsReservedByClient(clientId);

        assertTrue(result.isEmpty());
    }

    @Test
    public void testGetRoomIdsReservedByClient_ReturnsCorrectRoomIds() throws ClientNotFoundException, RoomNotFoundException {
        LocalDate date = LocalDate.of(2024, 5, 10);
        String clientId = hotel.addClient("John", "Doe", date);
        String roomId1 = hotel.addRoom(20.0, 1, true, "Room 101");
        String roomId2 = hotel.addRoom(25.0, 2, false, "Room 102");
        String reservationId1 = hotel.addNewReservation(clientId, roomId1, date);
        String reservationId2 = hotel.addNewReservation(clientId, roomId2, date);

        Collection<String> result = hotel.getRoomIdsReservedByClient(clientId);

        assertEquals(2, result.size());

        assertTrue(result.contains(reservationId1));
        assertTrue(result.contains(reservationId2));
    }

    @Test
    public void testGetRoomIdsReservedByClient_ThrowsClientNotFoundException() {
        String invalidClientId = "invalidClientId";

        assertThrows(ClientNotFoundException.class, () -> {
            hotel.getRoomIdsReservedByClient(invalidClientId);
        });
    }

    private Client findClientById(ArrayList<Client> clients, String clientId) {
        for (Client client : clients) {
            if (client.getId().equals(clientId)) {
                return client;
            }
        }
        return null;
    }

    private Room findRoomById(ArrayList<Room> rooms, String roomId) {
        for (Room room : rooms) {
            if (room.getId().equals(roomId)) {
                return room;
            }
        }
        return null;
    }

    private RoomReservation findRoomReservationById(ArrayList<RoomReservation> roomReservations, String roomId) {
        for (RoomReservation roomReservation : roomReservations) {
            if (roomReservation.getId().equals(roomId)) {
                return roomReservation;
            }
        }
        return null;
    }
}