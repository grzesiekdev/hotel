package pl.wsb.hotel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RoomTest {

    @Test
    void testGettersAndSetters() {
        Room room = new Room(100.0, 2, true, "Test Room");

        assertEquals(100.0, room.getArea());
        assertEquals(2, room.getFloor());
        assertTrue(room.getHasKingSizeBed());
        assertEquals("Test Room", room.getDescription());

        room.setArea(150.0);
        assertEquals(150.0, room.getArea());

        room.setFloor(3);
        assertEquals(3, room.getFloor());

        room.setHasKingSizeBed(false);
        assertFalse(room.getHasKingSizeBed());

        room.setDescription("Updated Test Room");
        assertEquals("Updated Test Room", room.getDescription());

        room.setNumberOfBeds(2);
        assertEquals(2, room.getNumberOfBeds());

        room.setPrice(200);
        assertEquals(200, room.getPrice());

        room.setFurnished(true);
        assertTrue(room.getFurnished());
    }
}