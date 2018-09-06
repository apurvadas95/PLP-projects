package com.demo.plp.service;

import com.demo.plp.dao.UserDao;
import com.demo.plp.entity.Person;
import com.demo.plp.model.PersonModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    public Boolean login(PersonModel p) {

        return userDao.login(p);
    }

    public Boolean register(PersonModel p, Errors errors) {

        Boolean bool=userDao.register(p,errors);
        return bool;
    }
    public PersonModel editProfile(PersonModel person) {
        return userDao.editProfile(person);
    }

    public PersonModel getPerson(String emailId) {
        return userDao.getPerson(emailId);
    }





}


