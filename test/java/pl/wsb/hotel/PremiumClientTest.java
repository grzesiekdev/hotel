package pl.wsb.hotel;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class PremiumClientTest {

    @Test
    void testGetFullName() {
        PremiumClient premiumClient = new PremiumClient("John", "Doe", LocalDate.of(1990, 5, 15));

        assertEquals("[premium] John Doe", premiumClient.getFullName());
    }

    @Test
    void testInheritedProperties() {
        PremiumClient premiumClient = new PremiumClient("Jane", "Smith", LocalDate.of(1985, 10, 20));

        assertEquals("Jane", premiumClient.getFirstName());
        assertEquals("Smith", premiumClient.getLastName());
        assertEquals(LocalDate.of(1985, 10, 20), premiumClient.getBirthDate());
    }
}