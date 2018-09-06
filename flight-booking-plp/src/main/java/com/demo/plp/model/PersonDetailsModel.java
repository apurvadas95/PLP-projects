package com.demo.plp.model;

import com.demo.plp.entity.PersonDetails;

public class PersonDetailsModel {

    private int id;
    private String address;


    public PersonDetailsModel() {
    }

    public PersonDetailsModel(PersonDetails personDetails) {
        this.id=personDetails.getId();
        this.address = personDetails.getAddress();
    }

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
}
