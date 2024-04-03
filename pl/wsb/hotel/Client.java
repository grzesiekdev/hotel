package pl.wsb.hotel;

import java.time.LocalDate;
import java.time.Period;

public class Client {
    private String id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String phoneNumber;
    private String email;
    private String address;

    public Client(String id, String firstName, String lastName, LocalDate birthDate, String phoneNumber, String email, String address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }
    public int getAge() {
        if (this.birthDate == null) {
            return 0;
        } else {
            LocalDate currentDate = LocalDate.now();
            Period period = Period.between(this.birthDate, currentDate);
            return period.getYears();
        }
    }

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }
}
