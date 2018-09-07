package com.demo.plp.model;

import javax.persistence.*;

@Entity
@Table(name = "User_Role")
public class User_Role {

    @Id
    @Column(name = "roleId")
    private int roleId;


    @Column(name = "roleName")
    private String roleName;


    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
