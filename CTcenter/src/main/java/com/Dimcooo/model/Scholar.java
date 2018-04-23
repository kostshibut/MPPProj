package com.Dimcooo.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Scholar {
    private int scholarId;
    private int userUserId;
    private Collection<ListScholarSubject> listScholarSubjectsByScholarId;
    private User userByUserUserId;
    private Collection<TeacherFeedback> teacherFeedbacksByScholarId;

    @Id
    @Column(name = "scholar_id", nullable = false)
    public int getScholarId() {
        return scholarId;
    }

    public void setScholarId(int scholarId) {
        this.scholarId = scholarId;
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
        Scholar scholar = (Scholar) o;
        return scholarId == scholar.scholarId &&
                userUserId == scholar.userUserId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(scholarId, userUserId);
    }

    @OneToMany(mappedBy = "scholarByScholarScholarId")
    public Collection<ListScholarSubject> getListScholarSubjectsByScholarId() {
        return listScholarSubjectsByScholarId;
    }

    public void setListScholarSubjectsByScholarId(Collection<ListScholarSubject> listScholarSubjectsByScholarId) {
        this.listScholarSubjectsByScholarId = listScholarSubjectsByScholarId;
    }

    @ManyToOne
    @JoinColumn(name = "user_user_id", referencedColumnName = "user_id", nullable = false)
    public User getUserByUserUserId() {
        return userByUserUserId;
    }

    public void setUserByUserUserId(User userByUserUserId) {
        this.userByUserUserId = userByUserUserId;
    }

    @OneToMany(mappedBy = "scholarByScholarScholarId")
    public Collection<TeacherFeedback> getTeacherFeedbacksByScholarId() {
        return teacherFeedbacksByScholarId;
    }

    public void setTeacherFeedbacksByScholarId(Collection<TeacherFeedback> teacherFeedbacksByScholarId) {
        this.teacherFeedbacksByScholarId = teacherFeedbacksByScholarId;
    }
}
