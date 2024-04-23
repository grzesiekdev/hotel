package pl.wsb.hotel;

import java.time.LocalDate;

public class PremiumClient extends Client{
    public PremiumClient(String id, String firstName, String lastName, LocalDate birthDate, String phoneNumber, String email, String address) {
        super(id, firstName, lastName, birthDate, phoneNumber, email, address);
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
