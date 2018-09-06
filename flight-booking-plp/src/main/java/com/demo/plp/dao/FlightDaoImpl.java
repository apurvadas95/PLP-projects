package com.demo.plp.dao;


import com.demo.plp.entity.Flights;
import com.demo.plp.model.FlightsModel;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
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

    public ModelAndView flights(FlightsModel flightsModel) {

//        String source=flights.getSource();
//        String destination=flights.getDestination();
//        //SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-mm-yyyy");
//
//        // String dateString= flights.getDate().toString();
//        long date=flights.getDate();

        Flights flights = new Flights(flightsModel);

        //flights.setDate(date);
        List<Flights> flightsList=(ArrayList)new ArrayList<Flights>();
        List<FlightsModel> flightsModelList=new ArrayList<>();

        Query query=sessionFactory.getCurrentSession().createQuery("FROM Flights where source=:source and destination=:destination and date=:date");
        query.setParameter("source",flights.getSource());
        query.setParameter("destination",flights.getDestination());
        query.setParameter("date",flights.getDate());

        flightsList = query.list();
        for(Flights item:flightsList){
            FlightsModel flightsModel1=new FlightsModel(item);
            flightsModelList.add(flightsModel1);
        }
      //  List<FlightsModel> flightsModelList=new ArrayList(flightsList);
        //flightsModelList.add((FlightsModel) flightsList);


        ModelAndView mav = new ModelAndView("flights");
        mav.addObject("flights",flightsModelList );
        return mav;
    }



}
