package pl.wsb.hotel;

import java.time.Month;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Client client1 = new Client("John", "Kowalski", LocalDate.of(1991, Month.APRIL, 12));
        Room room1 = new Room( 23.45, 5, true, "Small room with 1 bed");
        RoomReservation reservation1 = new RoomReservation(client1.getId(), room1.getId(), LocalDate.now());

        System.out.println("\nClient: " + client1.getFullName() + ", age: " + client1.getAge());
        System.out.println("Reservation info: " + reservation1.getReservationInfo());

        Client client2 = new Client("Adam", "Nowak", LocalDate.of(2015, Month.JULY, 20));
        Room room2 = new Room(33.5, 4, true, "Medium size room with 1 bed");
        RoomReservation reservation2 = new RoomReservation(client2.getId(), room2.getId(), LocalDate.now());
        reservation2.confirmReservation();

        System.out.println("\nClient: " + client2.getFullName() + ", age: " + client2.getAge());
        System.out.println("Reservation info: " + reservation2.getReservationInfo());

        PremiumClient premiumClient = new PremiumClient("Bill", "Gates", LocalDate.of(1965, Month.JANUARY, 20));
        Room room3 = new Room( 143.5, 7, true, "Big size room with 5 beds");
        LocalDate now = LocalDate.now();
        RoomReservation reservation3 = new RoomReservation(premiumClient.getId(), room3.getId(), now);

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
        hotel.addClient(client1.getFirstName(), client1.getLastName(), client1.getBirthDate());
        hotel.addClient(client2.getFirstName(), client2.getLastName(), client2.getBirthDate());
        hotel.addRoom(room1);
        hotel.addRoom(room2);
        hotel.addRoomReservation(reservation1);
        hotel.addSpecialService(timeService);
        hotel.addSpecialService(luggageService);

        Hotel hotelPremium = new Hotel("Hotel premium");
        hotelPremium.addClient(premiumClient.getFirstName(), premiumClient.getLastName(), premiumClient.getBirthDate());
        hotelPremium.addRoom(room3);
        hotelPremium.addRoomReservation(reservation3);
        hotelPremium.addSpecialService(timeService);
        hotelPremium.addSpecialService(timeService2);

        System.out.println("\nHotel: " + hotel.getName());
        System.out.println("Hotel clients: " + hotel.getClients());
        System.out.println("Hotel rooms: " + hotel.getRooms());
        System.out.println("Hotel reservations: " + hotel.getRoomReservations());
        System.out.println("Hotel services: " + hotel.getSpecialServices());
        System.out.println("Hotel underage clients: " + hotel.getNumberOfUnderageClients());

        System.out.println("\nHotel premium: " + hotelPremium.getName());
        System.out.println("Hotel clients: " + hotelPremium.getClients());
        System.out.println("Hotel rooms: " + hotelPremium.getRooms());
        System.out.println("Hotel reservations: " + hotelPremium.getRoomReservations());
        System.out.println("Hotel services: " + hotelPremium.getSpecialServices());
        System.out.println("Hotel unconfirmed reservations: " + hotelPremium.getNumberOfUnconfirmedReservation(now));
    }
}
