package pl.wsb.hotel;

import java.time.Month;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Client client1 = new Client("1", "John", "Kowalski", LocalDate.of(1991, Month.APRIL, 12), "123-456-789", "john.kowalski@gmail.com", "Bakery st. 120-98");
        Room room1 = new Room("1", "Small room with 1 bed", 23.45, 5, true, 450, true);
        RoomReservation reservation1 = new RoomReservation(LocalDate.now(), client1, room1);

        System.out.println("\nClient: " + client1.getFullName() + ", age: " + client1.getAge());
        System.out.println("Reservation info: " + reservation1.getReservationInfo());

        Client client2 = new Client("2", "Adam", "Nowak", LocalDate.of(1981, Month.JULY, 20), "908-123-456", "adam.nowak@test.com", "Test st. 120-00");
        Room room2 = new Room("2", "Medium size room with 1 bed", 33.5, 1, false, 500, false);
        RoomReservation reservation2 = new RoomReservation(LocalDate.now(), client2, room2);
        reservation2.confirmReservation();

        System.out.println("\nClient: " + client2.getFullName() + ", age: " + client2.getAge());
        System.out.println("Reservation info: " + reservation2.getReservationInfo());

        PremiumClient premiumClient = new PremiumClient("3", "Bill", "Gates", LocalDate.of(1965, Month.JANUARY, 20), "543-123-543", "bill.gates@microsoft.com", "Silicon Valley 23");
        Room room3 = new Room("3", "Big size room with 5 beds", 143.5, 7, true, 5200, true);
        RoomReservation reservation3 = new RoomReservation(LocalDate.now(), premiumClient, room3);

        System.out.println("\nClient: " + premiumClient.getFullName() + ", age: " + premiumClient.getAge());
        System.out.println("Reservation info: " + reservation3.getReservationInfo());

        TimeService timeService = new TimeService("\nTime service 1");
        System.out.println(timeService.getName() + " cost: " + timeService.calculateCost());
        System.out.println(timeService.getName() + " info: " + timeService.confirmService());
        timeService.orderService();

        TimeService timeService2 = new TimeService("\nTime service 2");
        System.out.println(timeService2.getName() + " cost: " + timeService2.calculateCost());
        System.out.println(timeService2.getName() + " info: " + timeService2.confirmService());
        timeService.orderService();

        LuggageService luggageService = new LuggageService("\nLuggage service 1");
        System.out.println(luggageService.getName() + " cost: " + luggageService.calculateCost());
        System.out.println(luggageService.getName() + " info: " + luggageService.confirmService());
        luggageService.orderService();

        Hotel hotel = new Hotel("Hotel 1");
        hotel.addClient(client1);
        hotel.addClient(client2);
        hotel.addRoom(room1);
        hotel.addRoom(room2);
        hotel.addRoomReservation(reservation1);
        hotel.addSpecialService(timeService);
        hotel.addSpecialService(luggageService);

        Hotel hotelPremium = new Hotel("Hotel premium");
        hotelPremium.addClient(premiumClient);
        hotelPremium.addRoom(room3);
        hotelPremium.addRoomReservation(reservation3);
        hotelPremium.addSpecialService(timeService);
        hotelPremium.addSpecialService(timeService2);

        System.out.println("\nHotel: " + hotel.getName());
        System.out.println("Hotel clients: " + hotel.getClients());
        System.out.println("Hotel rooms: " + hotel.getRooms());
        System.out.println("Hotel reservations: " + hotel.getRoomReservations());
        System.out.println("Hotel services: " + hotel.getSpecialServices());

        System.out.println("\nHotel premium: " + hotelPremium.getName());
        System.out.println("Hotel clients: " + hotelPremium.getClients());
        System.out.println("Hotel rooms: " + hotelPremium.getRooms());
        System.out.println("Hotel reservations: " + hotelPremium.getRoomReservations());
        System.out.println("Hotel services: " + hotelPremium.getSpecialServices());
    }
}
