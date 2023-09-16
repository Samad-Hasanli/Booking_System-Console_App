package org.example.Database;

import org.example.Entities.Booking;
import org.example.Entities.User;
import org.example.Entities.Flight;
import org.example.Utils.FlightGenerator;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Database{
    private static File userFile = new File("src/main/java/org/example/Database/DBFiles", "user.txt");
    private static File flightFile = new File("src/main/java/org/example/Database/DBFiles", "flight.txt");
    private static File bookingFile = new File("src/main/java/org/example/Database/DBFiles", "booking.txt");

    private static List <User> users = new ArrayList<>();
    private static List <Flight> flights = new ArrayList<>();
    private static List <Booking> bookings = new ArrayList<>();

    private static Database database;

    public Database(){
    }

    public static Database getInstance(){
        if(database == null){
            database = new Database();
        }
        return database;
    }

    public List<User> getUsers() {
        return users;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void initDatabase(){
        if(userFile.exists()){
            loadFileToList(userFile, users);
        }
        if(flightFile.exists()) {
            loadFileToList(flightFile, flights);
        }
        if(bookingFile.exists()) {
            loadFileToList(bookingFile, bookings);
        }
        else{
            flights.addAll(FlightGenerator.genFlight(20));
            saveListToFile(flightFile, flights);
        }
    }

    public void closeDatabase(){
        saveListToFile(userFile, users);
        saveListToFile(flightFile, flights);
        saveListToFile(bookingFile, bookings);
    }

    private void saveListToFile(File file, List list){
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            oos.close();
            fos.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void loadFileToList(File file, List list){
        try {
            FileInputStream fis = new FileInputStream(file);
            if(fis.available() > 0){
                ObjectInputStream ois = new ObjectInputStream(fis);
                List data = (List) ois.readObject();
                list.addAll(data);
                ois.close();
                fis.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

