package com.demo.plp.dao;

import com.demo.plp.model.*;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.hsqldb.rights.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDao{

    @Autowired
    private SessionFactory sessionFactory;

    public ModelAndView login(Person p){

        String errorInvalid="INVALID_USER";
        String email=p.getEmailId();
        String password=p.getPassword();
        ModelAndView mav = new ModelAndView("profile");
        //  ModelAndView mavError=new ModelAndView("login");
        // List<Person> personList=new ArrayList<Person>();
        try {
           /* Query query = sessionFactory.getCurrentSession().createQuery("FROM Person where emailId=:email and password=:password");
            query.setParameter("email", email);
            query.setParameter("password", password);
            personList = query.list();*/

            Person person = (Person) sessionFactory.getCurrentSession().get(Person.class, email);
            if (person != null && person.getPassword().equals(password)) {
                mav.addObject("person", person);
            }
            else {
                mav.setViewName("login");
                mav.addObject("errorInvalid", errorInvalid);
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        finally {
            return mav;
        }
    }

    public ModelAndView register(Person p, Errors errors) {

        ModelAndView mav = new ModelAndView("addPerson");

        if (null != p) {
            Users user =  new Users();

            user.setRoleId(1);
            user.setPerson(p);
            user.setPassword(p.getPassword());
            user.setEnabled(1);

            try {
                sessionFactory.getCurrentSession().save(user);
                //sessionFactory.getCurrentSession().flush();
                mav.addObject("err", "false");

            }
            catch (ConstraintViolationException sql){

                mav.addObject("err", "true");
                return mav;

            }
        }

        return mav;
    }

    public ModelAndView editProfile(Person newPerson) {

        /*
        To fetch a row from table without using HQL
        Google kar lena
         */
        String primaryKey = newPerson.getEmailId();

        Person personFromDB = (Person)sessionFactory.getCurrentSession().get(Person.class, primaryKey);
        //p.setPersonDetails(person.getPersonDetails());

        PersonDetails personDetails = personFromDB.getPersonDetails();
        if (null != personDetails) {
            personDetails.setAddress(newPerson.getPersonDetails().getAddress());
        }
        else {
            personFromDB.setPersonDetails(newPerson.getPersonDetails());
        }
        /**
         * https://www.baeldung.com/hibernate-save-persist-update-merge-saveorupdate
         */
//        sessionFactory.getCurrentSession().update(personFromDB);
//
        ModelAndView mav = new ModelAndView("editProfile");
        mav.addObject("person", personFromDB);

        return mav;
    }

    public ModelAndView getPerson(String emailId) {

        ModelAndView mav = new ModelAndView("editProfile");

        Query query= sessionFactory.getCurrentSession().createQuery("from Person where emailId =:emailId");
        query.setParameter("emailId",emailId);

        List<Person> personList = query.list();
        Person person = new Person();

        if (personList != null
                && personList.size() > 0) {
            person = personList.get(0);
        }

        mav.addObject("person",person);

        return mav;
    }

}


