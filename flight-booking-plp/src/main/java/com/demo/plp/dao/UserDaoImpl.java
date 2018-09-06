package com.demo.plp.dao;

import com.demo.plp.entity.Person;
import com.demo.plp.entity.PersonDetails;
import com.demo.plp.model.PersonDetailsModel;
import com.demo.plp.model.PersonModel;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDao{

    @Autowired
    private SessionFactory sessionFactory;

    public Boolean login(PersonModel p){

        String errorInvalid="INVALID_USER";
        String email=p.getEmailId();
        String password=p.getPassword();
        Person person = null;
       // ModelAndView mav = new ModelAndView("profile");
      //  ModelAndView mavError=new ModelAndView("login");
       // List<Person> personList=new ArrayList<Person>();
        try {
           /* Query query = sessionFactory.getCurrentSession().createQuery("FROM Person where emailId=:email and password=:password");
            query.setParameter("email", email);
            query.setParameter("password", password);add
            personList = query.list();*/

           person = (Person) sessionFactory.getCurrentSession().get(Person.class, email);
           }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        finally {
            if (person != null && person.getPassword().equals(password)) {
                return true;
            }
            return false;
        }
    }

    public Boolean register(PersonModel personModel, Errors errors) {

       // ModelAndView mav = new ModelAndView("addPerson");
        Person person=new Person(personModel);

        try {
            sessionFactory.getCurrentSession().save(person);
            sessionFactory.getCurrentSession().flush();
           // mav.addObject("err", "false");
            return true;

      }
         catch (ConstraintViolationException sql){

           /* mav.addObject("err", "true");
            return mav;*/
           return false;

        }


    }

    public PersonModel editProfile(PersonModel newPerson) {

        /*
        To fetch a row from table without using HQL
        Google kar lena
         */
        String primaryKey = newPerson.getEmailId();
        PersonModel personModel = null;

        Person personFromDB = (Person)sessionFactory.getCurrentSession().get(Person.class, primaryKey);
        //p.setPersonDetails(person.getPersonDetails());

        PersonDetails personDetails = personFromDB.getPersonDetails();
        if (null != personDetails) {
            personDetails.setAddress(newPerson.getPersonDetailsModel().getAddress());
        }
        else {
            personFromDB.setPersonDetails(new PersonDetails(newPerson.getPersonDetailsModel()));
        }
        /**
         * https://www.baeldung.com/hibernate-save-persist-update-merge-saveorupdate
         */
        sessionFactory.getCurrentSession().update(personFromDB);


        if (personFromDB != null) {
            personModel  = new PersonModel(personFromDB);
        }

        return personModel;
    }

    public PersonModel getPerson(String emailId) {

        ModelAndView mav = new ModelAndView("editProfile");

        Query query= sessionFactory.getCurrentSession().createQuery("from Person where emailId =:emailId");
        query.setParameter("emailId",emailId);

        List<Person> personList = query.list();
        Person person = new Person();

        if (personList != null
                && personList.size() > 0) {
            person = personList.get(0);
        }

       // mav.addObject("person",person);

        return new PersonModel(person);
    }

}


