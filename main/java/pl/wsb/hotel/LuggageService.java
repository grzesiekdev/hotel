package pl.wsb.hotel;
import java.time.LocalDateTime;

public class LuggageService extends SpecialService{
    public LuggageService(String name) {
        super(name);
    }

    @Override
    void orderService() {
        System.out.println("Hotel is currently storing client luggage.");
    }

    @Override
    int calculateCost() {
        return 200;
    }

    @Override
    String confirmService() {
        return "Order confirmed and will be performed at " + LocalDateTime.now().plusHours(3);
    }
}
