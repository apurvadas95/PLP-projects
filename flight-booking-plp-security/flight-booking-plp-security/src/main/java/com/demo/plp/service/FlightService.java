package com.demo.plp.service;

import com.demo.plp.model.Flights;
import org.springframework.web.servlet.ModelAndView;

public interface FlightService {

    ModelAndView searchFlights();
    ModelAndView flights(Flights flights);
}
