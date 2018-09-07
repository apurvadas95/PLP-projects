package org.spring.security.sample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class Users {


       @Column(name="username")
       private String username;


        @Column(name = "password")
        private String password;

        @Column(name = "enabled")
        private int enabled;

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }



}
