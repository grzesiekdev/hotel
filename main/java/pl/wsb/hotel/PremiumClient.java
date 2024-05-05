package pl.wsb.hotel;

import java.time.LocalDate;

public class PremiumClient extends Client{
    public PremiumClient(String firstName, String lastName, LocalDate birthDate) {
        super(firstName, lastName, birthDate);
    }

    enum PremiumAccountType {
        PREMIUM,
        PREMIUM_PLUS
    }

    @Override
    public String getFullName() {
        return "[premium] " + super.getFullName();
    }
}
