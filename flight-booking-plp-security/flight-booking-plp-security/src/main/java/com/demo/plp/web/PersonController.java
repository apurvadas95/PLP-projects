package com.demo.plp.web;

import java.security.Principal;
import java.util.List;

import com.demo.plp.dao.UserDao;
import com.demo.plp.model.Bookings;
import com.demo.plp.model.Flights;
import com.demo.plp.model.PersonDetails;
import com.demo.plp.service.BookingService;
import com.demo.plp.service.FlightService;
import com.demo.plp.service.UserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.demo.plp.model.Person;

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
	public ModelAndView addPerson(Person p, Errors errors)
	{
		ModelAndView mav=userService.register(p,errors);

		return mav;
	}

	@RequestMapping(value="/addPerson.htm")
	public ModelAndView addPerson(HttpServletRequest request)
	{
		ModelAndView mav = new ModelAndView("addPerson");
		Object object = request.getSession().getAttribute(LOGGED_IN_USER);

		if (object != null && object instanceof Person) {

			//return profile(request);
		}
		return  mav;
	}



	/*	//TO LOGIN A REGISTERED USER
        @RequestMapping(value="/login.htm", method=RequestMethod.POST)
        public ModelAndView login(HttpServletRequest request, Person p)
        {

            ModelAndView mav = userService.login(p);
            ModelAndView mavPerson=userService.getPerson(p.getEmailId());


            // Saving logged in user to session
            p = (Person) mavPerson.getModel().get("person");
            if (p != null) {
                request.getSession().setAttribute("loggedInUser", p);

            }
            else {
                mav.setViewName("login");
            }

            return  mav;

        }*/
	@RequestMapping(value="/login.htm",method = RequestMethod.GET)
	public ModelAndView login(Principal principal)
	{
		ModelAndView mav = new ModelAndView("login");

		return mav;
	}

	@RequestMapping(value="/loginFailure",method = RequestMethod.GET)
	public ModelAndView loginFailure(Principal principal)
	{
		ModelAndView mav = new ModelAndView("login");

		mav.addObject("error", "AUTH_FAILED");
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
	public ModelAndView profile(Principal principal)
	{
		ModelAndView mav = new ModelAndView("login");

		principal.getName();
		mav.addObject("principal",principal);
		mav.setViewName("profile");

		return mav;
	}

	//TO VIEW AVAILABLE FLIGHTS
	@Transactional
	@RequestMapping("/flights.htm")
	public ModelAndView flights(Principal principal)
	{
		ModelAndView mav=new ModelAndView("login");
		Object object = null;

		if (object != null && object instanceof Person) {
			Person loggedInUser = (Person)object;
			mav=new ModelAndView("flights");

		}
		//List<Flights> flights=sessionFactory.getCurrentSession().createQuery("From Flights").list();

		//mav.addObject("flights",flights);
		return mav;
	}



	//TO BOOK A FLIGHT FOR SOMEONE ELSE
	@RequestMapping(value = "/other.htm", method = RequestMethod.POST)
	public ModelAndView book(Principal principal,Bookings bookings, Flights flights)
	{
		ModelAndView mav=new ModelAndView("login");

		if (principal != null && principal.getName() != null) {

			String email = principal.getName();
			bookings.setEmailId(email);
			bookingService.book(bookings,flights);
			mav=bookingService.bookingHistory(email);

		}

		return mav;
	}

	//TO BOOK A FLIGHT FOR SOMEONE ELSE
	@RequestMapping(value = "/self.htm", method = RequestMethod.POST)
	public ModelAndView bookForSelf(Principal principal, Bookings bookings, Flights flights)
	{
		String error="Booking failed";


		if (principal != null && principal.getName() != null) {

			String email = principal.getName();
			bookings.setEmailId(email);

			ModelAndView personModelAndView = userService.getPerson(email);
			Person person = (Person)personModelAndView.getModel().get("person");

			bookings.setName(person.getName());
			bookings.setAge(person.getAge());
			bookingService.book(bookings,flights);
			ModelAndView mav=bookingService.bookingHistory(email);
			return mav;
		}
		ModelAndView mav=new ModelAndView("flights");
		return  mav.addObject("error",error);


	}


	//TO VIEW THE FLIGHT BOOKING HISTORY
	@RequestMapping(value = "/bookingHistory.htm", method = RequestMethod.GET)
	public ModelAndView bookingHistory(Principal principal)
	{

		ModelAndView mav = new ModelAndView("bookingHistory");
		if (principal != null && principal.getName() != null) {
			String email = principal.getName();
			mav=bookingService.bookingHistory(email);

		}

		return mav;
	}

	@RequestMapping(value = "/bookingHistory.htm", method = RequestMethod.POST)
	public ModelAndView bookingHistoryCancel(Principal principal,Bookings bookings)
	{
		ModelAndView mav=new ModelAndView("login");

		if (principal != null && principal.getName() != null) {

			String email = principal.getName();
			bookingService.cancelTicket(bookings);
			mav = bookingService.bookingHistory(email);
		}

		return mav;
	}

	//TO DELETE A PARTICULAR TICKET FOR A PARTICULAR DETAILS
	@RequestMapping(value = "/delete.htm", method = RequestMethod.POST)
	public ModelAndView deleteTicket(Principal principal,Integer ticketNo)
	{
		ModelAndView mav=new ModelAndView("login");

		if (principal != null && principal.getName() != null) {
			String email = principal.getName();
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

		mav = flightService.searchFlights();

		return  mav;
	}

	@RequestMapping(value = "/searchFlights.htm",method = RequestMethod.POST)
	public ModelAndView searchFlights(Principal principal, Flights flights)
	{

		ModelAndView mav=new ModelAndView("login");

		if (principal != null && principal.getName() != null) {
			mav = flightService.flights(flights);
		}
		return mav;
	}

	//TO EDIT USERS PROFILE TO ADD ADDRESS DETAILS
	@RequestMapping(value = "/editProfile.htm", method=RequestMethod.GET)
	public ModelAndView editProfile (Principal principal)
	{

		String error="NO_USER_IN_SESSION";
		if (null != principal
				&& null != principal.getName()) {

			return userService.getPerson(principal.getName());

		}

		ModelAndView mav=new ModelAndView("login");
		mav.addObject(error);
		return mav;
	}


	@RequestMapping(value = "/editProfile.htm", method=RequestMethod.POST)
	public ModelAndView editProfile (Person person, Principal principal)
	{

		ModelAndView mav = new ModelAndView("editProfile");

		if (principal != null
				&& principal.getName() != null) {

			String email = principal.getName();
			person.setEmailId(email);
			return userService.editProfile(person);
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
		List<Person> persons = sessionFactory.getCurrentSession().
			createQuery("FROM Person").list();

		ModelAndView mav = new ModelAndView("allPersons");
		mav.addObject("persons", persons);
		return mav;
	}*/
