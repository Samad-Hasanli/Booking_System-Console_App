package org.example.Entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Flight implements Serializable {
    private static final long serialVersionUID = 1L;
    private static int idCounter = 1;
    private int id;
    private int capacity;
    private String fromCode;
    private String toCode;
    private String airlineCode;
    private LocalDateTime takeOffTime;
    private Airline airline;
    private Airport from;
    private Airport to;


    public Flight(int capacity, String fromCode, String toCode, String airlineCode, LocalDateTime takeOffTime, Airline airline, Airport from, Airport to) {
        this.id = idCounter++;
        this.capacity = capacity;
        this.fromCode = fromCode;
        this.toCode = toCode;
        this.airlineCode = airlineCode;
        this.takeOffTime = takeOffTime;
        this.airline = airline;
        this.from = from;
        this.to = to;

    }



    public Flight(int id, int capacity, String fromCode, String toCode, String airlineCode, LocalDateTime takeOffTime, Airline airline, Airport from, Airport to) {
        idCounter = id;
        this.id = id;
        this.capacity = capacity;
        this.fromCode = fromCode;
        this.toCode = toCode;
        this.airlineCode = airlineCode;
        this.takeOffTime = takeOffTime;
        this.airline = airline;
        this.from = from;
        this.to = to;

    }
    public Flight(){

    }

    public static int getIdCounter() {
        return idCounter;
    }

    public static void setIdCounter(int idCounter) {
        Flight.idCounter = idCounter;
    }

    public int getId() {
        return id;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getFromCode() {
        return fromCode;
    }

    public String getToCode() {
        return toCode;
    }

    public String getAirlineCode() {
        return airlineCode;
    }

    public LocalDateTime getTakeOffTime() {
        return takeOffTime;
    }

    public Airline getAirline() {
        return airline;
    }

    public Airport getFrom() {
        return from;
    }

    public Airport getTo() {
        return to;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return id == flight.id && capacity == flight.capacity && Objects.equals(fromCode, flight.fromCode) && Objects.equals(toCode, flight.toCode) && Objects.equals(airlineCode, flight.airlineCode) && Objects.equals(takeOffTime, flight.takeOffTime) && airline == flight.airline && from == flight.from && to == flight.to;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, capacity, fromCode, toCode, airlineCode, takeOffTime, airline, from, to);
    }

    @Override
    public String toString() {
        return "Flight" + "\t" +
                "id => " + id +
                " capacity => " + capacity + "\t" +
                " Take off time => " + DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm").format(takeOffTime) + "\t" +
                " Airline => " + airline +
                "("  + airlineCode  + ")" +
                " From => " + from  +
                "(" + fromCode + ")" +
                " To => " + to +
                "(" + toCode + ")";
    }



}
