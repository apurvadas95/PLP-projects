package org.spring.security.sample.web;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import org.spring.security.sample.model.Person;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PersonController {

	@Autowired
	private SessionFactory sessionFactory;

	@RequestMapping(value="/addPerson.htm", method=RequestMethod.POST)
	public ModelAndView addPerson(Person p, Errors errors)
	{
		if (errors.hasErrors())
		{
			ModelAndView mav = new ModelAndView("addPerson");
			mav.addObject("errors", errors);
			return mav;
		}
		
		sessionFactory.getCurrentSession().save(p);	
		return new ModelAndView("redirect:/allPersons.htm");
	}

	@RequestMapping(value="/addPerson.htm")
	public String addPerson()
	{
		return "addPerson";
	}

	@RequestMapping(value="/login.htm")
	public String login()
	{
		return "login";
	}

	@RequestMapping(value="/login.htm",method = RequestMethod.POST)
	public String login(HttpServletRequest request)
	{
		return "addPerson";
	}
	
	
	@RequestMapping("/allPersons.htm")
	public ModelAndView allPersons()
	{

		ModelAndView mav = new ModelAndView("allPersons");
		return mav;
	}

	@RequestMapping("/profile.htm")
	public ModelAndView profile () {
		return new ModelAndView("profile");
	}
	
}
