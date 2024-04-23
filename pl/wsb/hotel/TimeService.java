package pl.wsb.hotel;
import java.time.LocalDateTime;

public class TimeService extends SpecialService {
    public TimeService(String name) {
        super(name);
    }

    @Override
    void orderService() {
        System.out.println(LocalDateTime.now());
    }

    @Override
    int calculateCost() {
        return 100;
    }

    @Override
    String confirmService() {
        return "Order confirmed and will be performed instantly";
    }
}
