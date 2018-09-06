package com.demo.plp.dao;

import com.demo.plp.entity.Bookings;
import com.demo.plp.entity.Flights;
import com.demo.plp.model.BookingsModel;
import com.demo.plp.model.FlightsModel;
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
        List<BookingsModel> bookingsModelsList=new ArrayList<>();

        for(Bookings item:bookingList){
            BookingsModel bookingsModel=new BookingsModel(item);
            bookingsModelsList.add(bookingsModel);
        }

       /* for(Bookings bookings:bookingList){
            bookings.getFlights().toString();
        }*/
        if (bookingCriteria != null) {
            mav.addObject("bookings", bookingsModelsList);
        }

        return mav;
    }

    public ModelAndView book(BookingsModel bookingsModel, FlightsModel flightsModel) {

        int status=1;

        Flights flights = new Flights(flightsModel);

        Flights flightFromDB = (Flights) sessionFactory.getCurrentSession().get(Flights.class, flights.getFlightNo());

        bookingsModel.setFlights(new FlightsModel(flightFromDB));
        bookingsModel.setStatus(status);

        sessionFactory.getCurrentSession().save(new Bookings(bookingsModel));

        ModelAndView mav = null;
        return mav;
    }

    public ModelAndView cancelTicket(BookingsModel bookings) {

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
