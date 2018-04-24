package com.Dimcooo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Entity
public class User {
    private int userId;
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private int age;
    private String education;
    private Collection<Admin> adminsByUserId;
    private Collection<Scholar> scholarsByUserId;
    private Collection<Teacher> teachersByUserId;

    @Id
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "login", nullable = false, length = 45)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 100)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "firstName", nullable = false, length = 45)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "lastName", nullable = false, length = 45)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 45)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "age", nullable = false)
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Basic
    @Column(name = "education", nullable = true, length = 45)
    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId &&
                age == user.age &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(email, user.email) &&
                Objects.equals(education, user.education);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userId, login, password, firstName, lastName, email, age, education);
    }

    @OneToMany(mappedBy = "userByUserUserId")
    public Collection<Admin> getAdminsByUserId() {
        return adminsByUserId;
    }

    public void setAdminsByUserId(Collection<Admin> adminsByUserId) {
        this.adminsByUserId = adminsByUserId;
    }

    @OneToMany(mappedBy = "userByUserUserId")
    public Collection<Scholar> getScholarsByUserId() {
        return scholarsByUserId;
    }

    public void setScholarsByUserId(Collection<Scholar> scholarsByUserId) {
        this.scholarsByUserId = scholarsByUserId;
    }

    @OneToMany(mappedBy = "userByUserUserId")
    public Collection<Teacher> getTeachersByUserId() {
        return teachersByUserId;
    }

    public void setTeachersByUserId(Collection<Teacher> teachersByUserId) {
        this.teachersByUserId = teachersByUserId;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", education='" + education + '\'' +
                '}';
    }
}
