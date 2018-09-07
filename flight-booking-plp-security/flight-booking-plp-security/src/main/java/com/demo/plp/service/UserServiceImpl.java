package com.demo.plp.service;

import com.demo.plp.dao.UserDao;
import com.demo.plp.model.Bookings;
import com.demo.plp.model.Flights;
import com.demo.plp.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    public ModelAndView login(Person p){

        ModelAndView mav=userDao.login(p);
        return  mav;
    }

    public ModelAndView register(Person p, Errors errors) {

        ModelAndView mav=userDao.register(p,errors);
        return mav;
    }
    public ModelAndView editProfile(Person person) {
        return userDao.editProfile(person);
    }

    public ModelAndView getPerson(String emailId) {
        return userDao.getPerson(emailId);
    }





}


