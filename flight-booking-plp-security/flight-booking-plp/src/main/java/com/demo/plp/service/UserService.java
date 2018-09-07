package com.demo.plp.service;

import com.demo.plp.model.Bookings;
import com.demo.plp.model.Flights;
import com.demo.plp.model.Person;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public interface UserService {

    ModelAndView login(Person p);
    ModelAndView register(Person p, Errors errors);
    ModelAndView editProfile(Person person);
    ModelAndView getPerson(String emailid);


}
