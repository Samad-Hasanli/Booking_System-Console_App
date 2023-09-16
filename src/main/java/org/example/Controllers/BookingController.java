package org.example.Controllers;

import org.example.DAO.BookingDAO;
import org.example.Entities.Booking;
import org.example.Services.BookingService;

public class BookingController {

    BookingService bookingService = new BookingService();
    public void getBookings(){
        bookingService.getBookings();
    }

    public void booked(){
        bookingService.booked();
    }

    public void cancelBooking(){
        bookingService.cancelBooking();
    }


}
