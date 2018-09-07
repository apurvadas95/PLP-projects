package com.demo.plp.dao;

import com.demo.plp.model.Flights;
import org.springframework.web.servlet.ModelAndView;

public interface FlightDao {

    ModelAndView searchFlights();
    ModelAndView flights(Flights flights);
}
