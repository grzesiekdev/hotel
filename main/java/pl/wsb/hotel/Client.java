package pl.wsb.hotel;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

public class Client {
    private String id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String phoneNumber;
    private String email;
    private String address;
    private Collection<String> roomIdHistory;

    public Client(String firstName, String lastName, LocalDate birthDate) {
        this.id = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.roomIdHistory = new ArrayList<>();
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

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void addRoomIdToReservationHistory(String id) {
        this.roomIdHistory.add(id);
    }

    public Collection<String> getRoomIdHistory() {
        return this.roomIdHistory;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
