package com.Dimcooo.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "subject_scholar_list", schema = "training_center")
public class SubjectScholarList {
    private int id;
    private Date registration;
    private Date expiration;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Registration", nullable = false)
    public Date getRegistration() {
        return registration;
    }

    public void setRegistration(Date registration) {
        this.registration = registration;
    }

    @Basic
    @Column(name = "Expiration", nullable = false)
    public Date getExpiration() {
        return expiration;
    }

    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SubjectScholarList that = (SubjectScholarList) o;

        if (id != that.id) return false;
        if (registration != null ? !registration.equals(that.registration) : that.registration != null) return false;
        if (expiration != null ? !expiration.equals(that.expiration) : that.expiration != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (registration != null ? registration.hashCode() : 0);
        result = 31 * result + (expiration != null ? expiration.hashCode() : 0);
        return result;
    }
}
