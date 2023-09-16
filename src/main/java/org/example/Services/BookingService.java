package org.example.Services;

import org.example.DAO.BookingDAO;
import org.example.DAO.FlightDAO;
import org.example.Entities.Booking;
import org.example.Entities.Flight;
import org.example.Entities.Passenger;
import java.util.Scanner;

public class BookingService {
    BookingDAO bookingDAO = new BookingDAO();
    FlightDAO flightDAO = new FlightDAO();
    Booking booking = new Booking();

    public void getBookings(){
        bookingDAO.getAll().forEach(f -> System.out.println(f));
    }

    public void booked() {
        System.out.println("Enter the id: ");
        Scanner scanner = new Scanner(System.in);
        Booking book = new Booking();
        int bookId = scanner.nextInt();
        Flight flight2 = new Flight();
        for (Flight flight1 : flightDAO.getAll()) {
            if (flight1.getId() == bookId) {
                flight2 = flight1;
                book.setFlight(flight2);
                System.out.println(flight2);
                break;
            }
        }

        System.out.println("Enter the passenger number: ");
        int passengerNumber = scanner.nextInt();

        for (int i = 0; i < passengerNumber; i++) {
            System.out.println("Enter the name: ");
            String name1 = scanner.next();

            System.out.println("Enter the surname: ");
            String surname1 = scanner.next();

            Passenger passenger = new Passenger(name1, surname1);
            Booking bookNew = new Booking(flight2, passenger);

            booking.saveBooking(bookNew);
        }
    }

    public void cancelBooking() {
        System.out.println("Please enter the booking ID you want to cancel: ");
        Scanner scanner = new Scanner(System.in);
        int bookingId = scanner.nextInt();

        boolean bookingFound = false;
        for (Booking existingBooking : bookingDAO.getAll()) {
            if (existingBooking.getId() == bookingId) {
                booking.removeBooking(existingBooking);
                bookingFound = true;
                System.out.println("Booking ID " + bookingId + " canceled.");
                break;
            }
        }

        if (!bookingFound) {
            System.out.println("Booking ID " + bookingId + " not found.");
        }
    }

}


