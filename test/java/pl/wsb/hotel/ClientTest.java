package pl.wsb.hotel;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClientTest {

    @Test
    void testGetAge() {
        Client client = new Client("John", "Doe", LocalDate.now().minusYears(25));

        assertEquals(25, client.getAge());
    }

    @Test
    void testGetFullName() {
        Client client = new Client("Jane", "Smith", LocalDate.of(1990, 8, 15));

        assertEquals("Jane Smith", client.getFullName());
    }

    @Test
    void testSetFirstName() {
        Client client = new Client("John", "Doe", LocalDate.of(1980, 5, 10));

        client.setFirstName("Alice");
        assertEquals("Alice", client.getFirstName());
    }

    @Test
    void testSetLastName() {
        Client client = new Client("John", "Doe", LocalDate.of(1980, 5, 10));

        client.setLastName("Smith");
        assertEquals("Smith", client.getLastName());
    }

    @Test
    void testSetBirthDate() {
        Client client = new Client("John", "Doe", LocalDate.of(1980, 5, 10));

        LocalDate newBirthDate = LocalDate.of(1990, 3, 20);
        client.setBirthDate(newBirthDate);
        assertEquals(newBirthDate, client.getBirthDate());
    }

    @Test
    void testAddRoomIdToReservationHistory() {
        Client client = new Client("John", "Doe", LocalDate.of(1980, 5, 10));

        client.addRoomIdToReservationHistory(UUID.randomUUID().toString());
        assertEquals(1, client.getRoomIdHistory().size());
    }
}
