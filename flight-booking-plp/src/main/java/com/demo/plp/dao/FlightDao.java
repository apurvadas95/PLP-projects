package com.demo.plp.dao;

import com.demo.plp.entity.Flights;
import com.demo.plp.model.FlightsModel;
import org.springframework.web.servlet.ModelAndView;

public interface FlightDao {

    ModelAndView searchFlights();
    ModelAndView flights(FlightsModel flightsModel);
}
