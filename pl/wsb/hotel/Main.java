package pl.wsb.hotel;

import java.time.Month;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Client client1 = new Client("1", "John", "Kowalski", LocalDate.of(1991, Month.APRIL, 12), "123-456-789", "john.kowalski@gmail.com", "Bakery st. 120-98");
        Room room1 = new Room("1", "Small room with 1 bed", 23.45, 5, true, 450, true);
        RoomReservation reservation1 = new RoomReservation(LocalDate.now(), client1, room1);

        System.out.println("Client: " + client1.getFullName() + ", age: " + client1.getAge());
        System.out.println("Reservation info: " + reservation1.getReservationInfo());

        Client client2 = new Client("2", "Adam", "Nowak", LocalDate.of(1981, Month.JULY, 20), "908-123-456", "adam.nowak@test.com", "Test st. 120-00");
        Room room2 = new Room("2", "Medium size room with 1 bed", 33.5, 1, false, 500, false);
        RoomReservation reservation2 = new RoomReservation(LocalDate.now(), client2, room2);
        reservation2.confirmReservation();

        System.out.println("Client: " + client2.getFullName() + ", age: " + client2.getAge());
        System.out.println("Reservation info: " + reservation2.getReservationInfo());
    }
}
