package com.demo.plp.service;

import com.demo.plp.entity.Person;
import com.demo.plp.model.PersonModel;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

public interface UserService {

    Boolean login(PersonModel p);
    Boolean register(PersonModel p, Errors errors);
    PersonModel editProfile(PersonModel person);
    PersonModel getPerson(String emailid);


}
