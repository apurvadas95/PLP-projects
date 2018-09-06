package com.demo.plp.service;

import com.demo.plp.dao.BookingDao;
import com.demo.plp.entity.Bookings;
import com.demo.plp.entity.Flights;
import com.demo.plp.model.BookingsModel;
import com.demo.plp.model.FlightsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

@Service
@Transactional
public class BookingServiceImpl implements BookingService{

    @Autowired
    BookingDao bookingDao;


    public ModelAndView bookingHistory(String email) {

        ModelAndView mav=bookingDao.bookingHistory(email);
        return mav;
    }

    public ModelAndView book(BookingsModel bookings, FlightsModel flightsModel) {


        ModelAndView mav=bookingDao.book(bookings, flightsModel);
        return mav;
    }

    public ModelAndView cancelTicket(BookingsModel bookings) {

        ModelAndView mav=bookingDao.cancelTicket(bookings);
        return mav;
    }


    public void deleteTicket(Integer ticketNo) {

        bookingDao.deleteTicket(ticketNo);
    }


}
