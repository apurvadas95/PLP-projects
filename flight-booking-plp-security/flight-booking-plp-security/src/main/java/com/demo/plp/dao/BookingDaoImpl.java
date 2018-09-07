package com.demo.plp.dao;

import com.demo.plp.model.Bookings;
import com.demo.plp.model.Flights;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class BookingDaoImpl implements BookingDao{

    @Autowired
    SessionFactory sessionFactory;


    public ModelAndView bookingHistory(String email) {


        //Query query=sessionFactory.getCurrentSession().
        /*Query query =sessionFactory.getCurrentSession().createQuery("FROM Bookings bks  where bks.emailId=:email");
        //createQuery("FROM Bookings INNER JOIN Flights ON Bookings.flightNo=Flights.flightNo where Bookings.emailId='ankita@gmail.com' and Bookings.status=1");
        List<?> bookings=query.list();
        query.setParameter("email",email);*/
        ModelAndView mav = new ModelAndView("bookingHistory");

        Criteria bookingCriteria = sessionFactory.getCurrentSession().createCriteria(Bookings.class);
        bookingCriteria.add(Restrictions.eq("emailId", email));

        List<Bookings> bookingList = bookingCriteria.list();

        for(Bookings bookings:bookingList){
            bookings.getFlights().toString();
        }

        if (bookingCriteria != null) {
            mav.addObject("bookings", bookingList);
        }

        return mav;
    }

    public ModelAndView book(Bookings bookings, Flights flights) {

        int status=1;

        Flights flightFromDB = (Flights) sessionFactory.getCurrentSession().get(Flights.class, flights.getFlightNo());

        bookings.setFlights(flightFromDB);
        bookings.setStatus(status);

        sessionFactory.getCurrentSession().save(bookings);

        ModelAndView mav = null;
        return mav;
    }

    public ModelAndView cancelTicket(Bookings bookings) {

        int ticketNo=bookings.getTicketNo();
        Query query= sessionFactory.getCurrentSession().createQuery("update Bookings set status=0 where ticketNo=:ticketNo");
        query.setParameter("ticketNo",ticketNo);
        query.executeUpdate();

        ModelAndView mav = new ModelAndView("bookingHistory");
        mav.addObject("bookings",bookings );

        return mav;
    }


    public void deleteTicket(Integer ticketNo) {
        Query query= sessionFactory.getCurrentSession().createQuery("delete from Bookings where ticketNo=:ticketNo");
        query.setParameter("ticketNo",ticketNo);
        query.executeUpdate();
    }

}
