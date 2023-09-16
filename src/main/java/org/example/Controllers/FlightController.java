package org.example.Controllers;

import org.example.Entities.Flight;
import org.example.Services.FlightService;

public class FlightController {
    FlightService flightService = new FlightService();

    public void getFlight(){
        flightService.getFlight();
    }

}
