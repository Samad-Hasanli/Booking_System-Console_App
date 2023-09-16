package org.example.Services;

import org.example.DAO.FlightDAO;
import org.example.Entities.Flight;

import java.util.List;

public class FlightService {
    FlightDAO flightDAO = new FlightDAO();
    public void getFlight(){
         flightDAO.getAll().forEach(f-> System.out.println(f));
    }
}
