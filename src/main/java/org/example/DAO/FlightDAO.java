package org.example.DAO;

import org.example.Database.Database;
import org.example.Entities.Flight;
import org.example.Entities.User;

import java.util.List;

public class FlightDAO {
    private Database db = Database.getInstance();

    public List<Flight> getAll(){
        return db.getFlights();
    }
}
