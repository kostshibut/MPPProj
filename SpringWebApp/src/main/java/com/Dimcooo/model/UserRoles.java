package com.Dimcooo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_roles", schema = "springwebappdb", catalog = "")
public class UserRoles {
    private int userRolesId;

    @Id
    @Column(name = "user_roles_id", nullable = false)
    public int getUserRolesId() {
        return userRolesId;
    }

    public void setUserRolesId(int userRolesId) {
        this.userRolesId = userRolesId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserRoles userRoles = (UserRoles) o;

        if (userRolesId != userRoles.userRolesId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return userRolesId;
    }
}
