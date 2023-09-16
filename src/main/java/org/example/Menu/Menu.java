package org.example.Menu;

import org.example.Controllers.BookingController;
import org.example.Controllers.FlightController;
import org.example.Entities.Booking;

import java.util.Scanner;

public class Menu {
    public void mainmenu() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while (choice != 4) {
            System.out.println("1 - Register");
            System.out.println("2 - Login");
            System.out.println("3 - View flights");
            System.out.println("4 - Exit");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Register register = new Register();
                    register.register();
                    break;
                case 2:
                    boolean backToMainMenu = false;
                    Login login = new Login();
                    login.login();
                    if(login.getAbc() == 1) {
                        int menuchoice = 0;
                        while (menuchoice != 5) {

                            System.out.println("1 - View flights");
                            System.out.println("2 - Make booking");
                            System.out.println("3 - Show bookings");
                            System.out.println("4 - Cancel booking");
                            System.out.println("5 - Logout");

                            menuchoice = scanner.nextInt();

                            BookingController bookingController = new BookingController();

                            switch (menuchoice) {
                                case 1:
                                    FlightController flightController = new FlightController();
                                    flightController.getFlight();
                                    break;
                                case 2:
                                    bookingController.booked();
                                    break;
                                case 3:
                                    bookingController.getBookings();
                                    break;
                                case 4:
                                    bookingController.cancelBooking();
                                    break;
                                case 5:
                                    System.out.println("Logging out");
                                    break;
                                default:
                                    System.out.println("Try again!");
                            }
                        }
                    }
                    else {
                        backToMainMenu = true;
                    }
                    break;
                case 3:
                    FlightController flightController = new FlightController();
                    flightController.getFlight();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Try again!");
            }
        }
        System.out.println("Goodbye!");
    }
}

