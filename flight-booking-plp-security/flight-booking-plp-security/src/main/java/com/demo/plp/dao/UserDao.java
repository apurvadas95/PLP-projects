package com.demo.plp.dao;
import com.demo.plp.model.Person;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;


public interface UserDao {
   ModelAndView login(Person p);
   ModelAndView register(Person p,Errors errors);
   ModelAndView editProfile(Person person);
   ModelAndView getPerson(String emailId);


}
