package com.demo.plp.service;

import com.demo.plp.dao.FlightDao;
import com.demo.plp.entity.Flights;
import com.demo.plp.model.FlightsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

@Service
@Transactional
public class FlightServiceImpl implements FlightService {

    @Autowired
    FlightDao flightDao;

    public ModelAndView searchFlights() {

        ModelAndView mav=flightDao.searchFlights();
        return mav;
    }

    public ModelAndView flights(FlightsModel flightsModel) {

        ModelAndView mav=flightDao.flights(flightsModel);
        return mav;
    }


}
