package com.demo.plp.entity;

import com.demo.plp.model.PersonDetailsModel;

import javax.persistence.*;

@Entity
@Table(name = "PersonDetails")
public class PersonDetails {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @Column(name="address")
    private String address;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public PersonDetails(PersonDetails personDetailsModel) {

    }
    public PersonDetails (PersonDetailsModel personDetailsModel) {

        if(personDetailsModel!=null) {
            this.address = personDetailsModel.getAddress();
            this.id = personDetailsModel.getId();
        }

    }
    public PersonDetails(){

    }
}
