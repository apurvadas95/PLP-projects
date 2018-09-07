package com.demo.plp.service;

import com.demo.plp.dao.FlightDao;
import com.demo.plp.model.Flights;
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

    public ModelAndView flights(Flights flights) {

        ModelAndView mav=flightDao.flights(flights);
        return mav;
    }


}
