package com.demo.plp.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.demo.plp.entity.Bookings;
import com.demo.plp.entity.Flights;
import com.demo.plp.model.BookingsModel;
import com.demo.plp.model.FlightsModel;
import com.demo.plp.model.PersonModel;
import com.demo.plp.service.BookingService;
import com.demo.plp.service.FlightService;
import com.demo.plp.service.UserService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class PersonController {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private UserService userService;

	@Autowired
	private BookingService bookingService;

	@Autowired
	private FlightService flightService;

	public static final String LOGGED_IN_USER = "loggedInUser";

	//TO REGISTER A NEW USER
	@RequestMapping(value="/addPerson.htm", method=RequestMethod.POST)
	public ModelAndView addPerson(PersonModel p, Errors errors) {
		Boolean bool = userService.register(p, errors);
		ModelAndView mav=new ModelAndView("addPerson");

		if (bool == true) {
			//mav.setViewName("login");
			mav.addObject("err", "false");
			return mav;

		}
		mav.addObject("err", "true");
		return mav;
	}

	@RequestMapping(value="/addPerson.htm")
	public ModelAndView addPerson(HttpServletRequest request)
	{
		ModelAndView mav = new ModelAndView("addPerson");
		Object object = request.getSession().getAttribute(LOGGED_IN_USER);

		if (object != null && object instanceof PersonModel) {

			return profile(request);
		}
		return  mav;
	}



	//TO LOGIN A REGISTERED USER
	@RequestMapping(value="/login.htm", method=RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request, PersonModel personToLogIn)
	{

		Boolean isLoginSuccess = userService.login(personToLogIn);
		PersonModel personModel = null;

		ModelAndView mav = new ModelAndView("login");

		if (isLoginSuccess == true) {
			personModel = userService.getPerson(personToLogIn.getEmailId());
			request.getSession().setAttribute("loggedInUser", personModel);
			mav.setViewName("profile");
			mav.addObject("person", personModel);
		}

		return  mav;

	}
	@RequestMapping(value="/login.htm",method = RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		Object object = session.getAttribute(LOGGED_IN_USER);
		ModelAndView mav = new ModelAndView("login");

		if (object != null && object instanceof PersonModel) {
			return profile(request);
		}

		return mav;
	}



	//TO LOGOUT A USER
	@RequestMapping(value="/logout.htm",method = RequestMethod.GET)
	public String logout(HttpServletRequest request)
	{
		request.getSession().invalidate();
		return "login";
	}


	//TO VIEW PROFILE OF A USER AFTER LOGIN
	@RequestMapping(value="/profile.htm")
	public ModelAndView profile(HttpServletRequest request)
	{
		ModelAndView mav = new ModelAndView("login");
		Object object = request.getSession().getAttribute(LOGGED_IN_USER);

		if (object != null && object instanceof PersonModel) {

			mav.setViewName("profile");
			mav.addObject("person", object);
			return mav;
		}
		return mav;
	}


	//TO VIEW AVAILABLE FLIGHTS
	@Transactional
	@RequestMapping("/flights.htm")
	public ModelAndView flights(HttpServletRequest request)
	{
		ModelAndView mav=new ModelAndView("login");
		Object object = request.getSession().getAttribute(LOGGED_IN_USER);

		if (object != null && object instanceof PersonModel) {
			PersonModel loggedInUser = (PersonModel)object;
			mav=new ModelAndView("flights");

		}
		//List<Flights> flights=sessionFactory.getCurrentSession().createQuery("From Flights").list();

		//mav.addObject("flights",flights);
		return mav;
	}



	//TO BOOK A FLIGHT FOR SOMEONE ELSE
	@RequestMapping(value = "/other.htm", method = RequestMethod.POST)
	public ModelAndView book(HttpServletRequest request, BookingsModel bookings, FlightsModel flights)
	{
		ModelAndView mav=new ModelAndView("login");
		Object object = request.getSession().getAttribute(LOGGED_IN_USER);

		if (object != null && object instanceof PersonModel) {
			PersonModel loggedInUser = (PersonModel)object;
			String email =loggedInUser.getEmailId();
			bookings.setEmailId(email);
			bookingService.book(bookings,flights);
			mav=bookingService.bookingHistory(email);

		}

		    return mav;
	}

	//TO BOOK A FLIGHT FOR SOMEONE ELSE
	@RequestMapping(value = "/self.htm", method = RequestMethod.POST)
	public ModelAndView bookForSelf(HttpServletRequest request, BookingsModel bookings, FlightsModel flightsModel)
	{
		String error="Booking failed";
		Object object = request.getSession().getAttribute(LOGGED_IN_USER);

		if (object != null && object instanceof PersonModel) {
			PersonModel loggedInUser = (PersonModel)object;
			String email =loggedInUser.getEmailId();
			bookings.setEmailId(email);
			bookings.setName(loggedInUser.getName());
			bookings.setAge(loggedInUser.getAge());
			bookingService.book(bookings,flightsModel);
			ModelAndView mav=bookingService.bookingHistory(email);
			return mav;
		}
		ModelAndView mav=new ModelAndView("flights");
		return  mav.addObject("error",error);


	}


	//TO VIEW THE FLIGHT BOOKING HISTORY
	@RequestMapping(value = "/bookingHistory.htm", method = RequestMethod.GET)
	public ModelAndView bookingHistory(HttpServletRequest request)
	{

		ModelAndView mav=new ModelAndView("login");
		Object object = request.getSession().getAttribute(LOGGED_IN_USER);

		if (object != null && object instanceof PersonModel) {
			PersonModel loggedInUser = (PersonModel)object;
			String email =loggedInUser.getEmailId();
		     mav=bookingService.bookingHistory(email);

		}

		return mav;
	}

	@RequestMapping(value = "/bookingHistory.htm", method = RequestMethod.POST)
	public ModelAndView bookingHistoryCancel(HttpServletRequest request,BookingsModel bookings)
	{
		ModelAndView mav=new ModelAndView("login");
		Object object = request.getSession().getAttribute(LOGGED_IN_USER);

		if (object != null && object instanceof PersonModel) {
			PersonModel loggedInUser = (PersonModel) object;
			String email = loggedInUser.getEmailId();
			bookingService.cancelTicket(bookings);
		    mav = bookingService.bookingHistory(email);
		}

		return mav;
	}

	//TO DELETE A PARTICULAR TICKET FOR A PARTICULAR DETAILS
	@RequestMapping(value = "/delete.htm", method = RequestMethod.POST)
	public ModelAndView deleteTicket(HttpServletRequest request,Integer ticketNo)
	{
		ModelAndView mav=new ModelAndView("login");
		Object object = request.getSession().getAttribute(LOGGED_IN_USER);

		if (object != null && object instanceof PersonModel) {
			PersonModel loggedInUser = (PersonModel) object;
			String email = loggedInUser.getEmailId();
			bookingService.deleteTicket(ticketNo);

			mav = bookingService.bookingHistory(email);
		}
		//mav.addObject("bookings",bookings );

		return mav;
	}

	//TO SEARCH FLIGHTS FOR A PARTICULAR DATE , SOuRCE, DESTINATION
	@RequestMapping("/searchFlights.htm")
	public ModelAndView searchFlights(HttpServletRequest request)
	{
		ModelAndView mav=new ModelAndView("login");
		Object object = request.getSession().getAttribute(LOGGED_IN_USER);

		if (object != null && object instanceof PersonModel) {

			mav = flightService.searchFlights();
			return mav;
		}
		return  mav;
	}

	@RequestMapping(value = "/searchFlights.htm",method = RequestMethod.POST)
	public ModelAndView searchFlights(HttpServletRequest request,FlightsModel flights)
	{

		/*SimpleDateFormat f = new SimpleDateFormat("dd-MMM-yyyy");

		Date d= null;
		try {
			d = f.parse(String.valueOf(flights.getDate()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		long milliseconds = d.getTime();
		flights.setDate(milliseconds);*/
		ModelAndView mav=new ModelAndView("login");
		Object object = request.getSession().getAttribute(LOGGED_IN_USER);

		if (object != null && object instanceof PersonModel) {
			mav = flightService.flights(flights);
		}
		return mav;
	}

	//TO EDIT USERS PROFILE TO ADD ADDRESS DETAILS
	@RequestMapping(value = "/editProfile.htm", method=RequestMethod.GET)
	public ModelAndView editProfile (HttpServletRequest request)
	{

		String error="NO_USER_IN_SESSION";
		Object object = request.getSession().getAttribute(LOGGED_IN_USER);
		ModelAndView mav = new ModelAndView("login");

		if (object != null && object instanceof PersonModel) {
			mav.setViewName("editProfile");
			PersonModel person = (PersonModel) object;
			String emailId=person.getEmailId();
			return mav.addObject("person", userService.getPerson(emailId));

		}

		mav.addObject(error);
		return mav;
	}


	@RequestMapping(value = "/editProfile.htm", method=RequestMethod.POST)
	public ModelAndView editProfile (HttpServletRequest request,PersonModel person)
	{
		ModelAndView mav = new ModelAndView("login");
		Object object = request.getSession().getAttribute(LOGGED_IN_USER);

		if (object instanceof PersonModel) {
			mav.setViewName("editProfile");
			PersonModel loggedInUser = (PersonModel) object;
			String email = loggedInUser.getEmailId();
			person.setEmailId(email);
			mav.addObject("person", userService.editProfile(person));
		}
		return mav;

	}

	/*@RequestMapping(value="/passengerDetails.htm",method = RequestMethod.GET)
	public String passengerDetails()
	{
		final ModelAndView view = getFlights();
		return "passengerDetails";
	}*/


	/*@RequestMapping(value="/other.htm",method = RequestMethod.POST)
	public ModelAndView passengerDetailsOther(Bookings person)
	{

		ModelAndView mav=userService.passengerDetailsOther(person);
		return mav;
	}*/


}



























































/*	@RequestMapping("/allPersons.htm")
	public ModelAndView allPersons()
	{
		List<PersonModel> persons = sessionFactory.getCurrentSession().
			createQuery("FROM PersonModel").list();

		ModelAndView mav = new ModelAndView("allPersons");
		mav.addObject("persons", persons);
		return mav;
	}*/
