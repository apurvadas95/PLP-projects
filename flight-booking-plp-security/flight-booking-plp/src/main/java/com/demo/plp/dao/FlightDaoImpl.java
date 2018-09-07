package com.demo.plp.dao;


import com.demo.plp.model.Flights;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
public class FlightDaoImpl implements FlightDao{

    @Autowired
    SessionFactory sessionFactory;


    public ModelAndView searchFlights() {

        List<Flights> flights = sessionFactory.getCurrentSession().
                createQuery("select distinct source,destination FROM Flights").list();
        ModelAndView mav=new ModelAndView("searchFlights");

        mav.addObject("flights",flights);
        return mav;
    }

    public ModelAndView flights(Flights flights) {

        String source=flights.getSource();
        String destination=flights.getDestination();
        //SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-mm-yyyy");

        // String dateString= flights.getDate().toString();
        Date date=flights.getDate();
        //flights.setDate(date);
        List<Flights> flightsList=new ArrayList<Flights>();

        Query query=sessionFactory.getCurrentSession().createQuery("FROM Flights where source=:source and destination=:destination and date=:date");
        query.setParameter("source",source);
        query.setParameter("destination",destination);
        query.setParameter("date",date);

        flightsList = query.list();


        ModelAndView mav = new ModelAndView("flights");
        mav.addObject("flights",flightsList );
        return mav;
    }



}
