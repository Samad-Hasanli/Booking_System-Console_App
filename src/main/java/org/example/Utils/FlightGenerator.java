package org.example.Utils;

import org.example.Entities.Airline;
import org.example.Entities.Airport;
import org.example.Entities.Flight;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class FlightGenerator{

    private static Random random = new Random();

    public static int genCapacity(){
        return random.nextInt();
    }

    public static Airline genAirline(){
        int pick = new Random().nextInt(Airline.values().length);
        return Airline.values()[pick];
    }

    public static Airport genAirport(){
        int pick = new Random().nextInt(Airport.values().length);
        return Airport.values()[pick];
    }


    public static LocalDateTime genTakeOffTime(){
        LocalDate startDate = LocalDate.of(2023, 1, 1);
        long start = startDate.toEpochDay();

        LocalDate endDate = LocalDate.of(2023,12,31);
        long end = endDate.toEpochDay();

        long randomDay = ThreadLocalRandom.current().longs(start, end).findAny().getAsLong();
        LocalDate randomDate = LocalDate.ofEpochDay(randomDay);
        LocalTime randomTime = LocalTime.of(random.nextInt(24),random.nextInt(60));



        return LocalDateTime.of(randomDate,randomTime);

    }
    public static List<Flight> genFlight(int nor){
        List <Flight> flights = new ArrayList<>();
        for (int i = 0; i < nor; i++){
            int capacity = genCapacity();
            LocalDateTime takeOffTime = genTakeOffTime();
            Airline airline = genAirline();
            Airport from = genAirport();
            Airport to = genAirport();
            while(from.equals(to)){
                from = genAirport();
                to = genAirport();
            }
            flights.add(new Flight(capacity, from.getCode() , to.getCode(), airline.getCode(), takeOffTime , airline , from , to));

        }


        return flights;
    }

    public static void main(String[] args) {
        FlightGenerator fg = new FlightGenerator();
        fg.genFlight(20).forEach(f -> System.out.println(f));
    }
}
