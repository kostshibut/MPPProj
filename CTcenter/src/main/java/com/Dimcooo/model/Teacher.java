package com.Dimcooo.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Teacher {
    private int teacherId;
    private String spetialization;
    private int userUserId;
    private Collection<Subject> subjectsByTeacherId;
    private User userByUserUserId;
    private Collection<TeacherFeedback> teacherFeedbacksByTeacherId;

    @Id
    @Column(name = "teacher_id", nullable = false)
    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    @Basic
    @Column(name = "spetialization", nullable = true, length = 45)
    public String getSpetialization() {
        return spetialization;
    }

    public void setSpetialization(String spetialization) {
        this.spetialization = spetialization;
    }

    @Basic
    @Column(name = "user_user_id", nullable = false)
    public int getUserUserId() {
        return userUserId;
    }

    public void setUserUserId(int userUserId) {
        this.userUserId = userUserId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return teacherId == teacher.teacherId &&
                userUserId == teacher.userUserId &&
                Objects.equals(spetialization, teacher.spetialization);
    }

    @Override
    public int hashCode() {

        return Objects.hash(teacherId, spetialization, userUserId);
    }

    @OneToMany(mappedBy = "teacherByTeacherTeacherId")
    public Collection<Subject> getSubjectsByTeacherId() {
        return subjectsByTeacherId;
    }

    public void setSubjectsByTeacherId(Collection<Subject> subjectsByTeacherId) {
        this.subjectsByTeacherId = subjectsByTeacherId;
    }

    @ManyToOne
    @JoinColumn(name = "user_user_id", referencedColumnName = "user_id", nullable = false)
    public User getUserByUserUserId() {
        return userByUserUserId;
    }

    public void setUserByUserUserId(User userByUserUserId) {
        this.userByUserUserId = userByUserUserId;
    }

    @OneToMany(mappedBy = "teacherByTeacherTeacherId")
    public Collection<TeacherFeedback> getTeacherFeedbacksByTeacherId() {
        return teacherFeedbacksByTeacherId;
    }

    public void setTeacherFeedbacksByTeacherId(Collection<TeacherFeedback> teacherFeedbacksByTeacherId) {
        this.teacherFeedbacksByTeacherId = teacherFeedbacksByTeacherId;
    }
}
