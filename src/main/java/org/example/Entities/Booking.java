package org.example.Entities;

import org.example.DAO.BookingDAO;
import org.example.DAO.FlightDAO;
import org.example.Database.Database;

import java.io.Serializable;
import java.util.Objects;
import java.util.Scanner;

public class Booking implements Serializable{
    private static final long serialVersionUID = 1L;
    private static int idCounter = 1;
    private int id;
    private Flight flight;
    private Passenger passenger;

    public Booking(Flight flight, Passenger passenger) {
        this.id = idCounter++;
        this.flight = flight;
        this.passenger = passenger;
    }

    public Booking(int id, Flight flight, Passenger passenger) {
        idCounter = id;
        this.id = id;
        this.flight = flight;
        this.passenger = passenger;
    }

    public Booking() {
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public int getId(){
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return id == booking.id && Objects.equals(flight, booking.flight) && Objects.equals(passenger, booking.passenger);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, flight, passenger);
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", flight=" + flight +
                ", passenger=" + passenger +
                '}';
    }

    BookingDAO bookingDAO = new BookingDAO();

    public void saveBooking(Booking booking){
        bookingDAO.create(booking);
    }

    public void removeBooking(Booking booking) {
        bookingDAO.delete(booking);
    }



}
