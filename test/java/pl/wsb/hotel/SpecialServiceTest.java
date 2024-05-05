package pl.wsb.hotel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SpecialServiceTest {
    @Test
    public void testTimeService() {
        SpecialService timeService = new TimeService("Time Service");

        assertEquals(100, timeService.calculateCost());
        assertEquals("Order confirmed and will be performed instantly", timeService.confirmService());
        assertEquals("Time Service", timeService.getName());
        timeService.setName("New Time Service");
        assertEquals("New Time Service", timeService.getName());
    }

    @Test
    public void testLuggageService() {
        SpecialService luggageService = new LuggageService("Luggage Service");

        assertEquals(200, luggageService.calculateCost());
        assertEquals("Luggage Service", luggageService.getName());
        luggageService.setName("New Luggage Service");
        assertEquals("New Luggage Service", luggageService.getName());
    }

}