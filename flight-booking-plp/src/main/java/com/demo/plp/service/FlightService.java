package com.demo.plp.service;

import com.demo.plp.entity.Flights;
import com.demo.plp.model.FlightsModel;
import org.springframework.web.servlet.ModelAndView;

public interface FlightService {

    ModelAndView searchFlights();
    ModelAndView flights(FlightsModel flightsModel);
}
