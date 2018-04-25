package com.Dimcooo.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "teacher_feedback", schema = "ct_center", catalog = "")
public class TeacherFeedback {
    private int teacherFeedbackId;
    private Integer mark;
    private String description;
    private int scholarScholarId;
    private int teacherTeacherId;
    private Scholar scholarByScholarScholarId;
    private Teacher teacherByTeacherTeacherId;

    @Id
    @Column(name = "teacher_feedback_id", nullable = false)
    public int getTeacherFeedbackId() {
        return teacherFeedbackId;
    }

    public void setTeacherFeedbackId(int teacherFeedbackId) {
        this.teacherFeedbackId = teacherFeedbackId;
    }

    @Basic
    @Column(name = "mark", nullable = true)
    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 255)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "scholar_scholar_id", nullable = false)
    public int getScholarScholarId() {
        return scholarScholarId;
    }

    public void setScholarScholarId(int scholarScholarId) {
        this.scholarScholarId = scholarScholarId;
    }

    @Basic
    @Column(name = "teacher_teacher_id", nullable = false)
    public int getTeacherTeacherId() {
        return teacherTeacherId;
    }

    public void setTeacherTeacherId(int teacherTeacherId) {
        this.teacherTeacherId = teacherTeacherId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeacherFeedback that = (TeacherFeedback) o;
        return teacherFeedbackId == that.teacherFeedbackId &&
                scholarScholarId == that.scholarScholarId &&
                teacherTeacherId == that.teacherTeacherId &&
                Objects.equals(mark, that.mark) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(teacherFeedbackId, mark, description, scholarScholarId, teacherTeacherId);
    }

    @ManyToOne
    @JoinColumn(name = "scholar_scholar_id", referencedColumnName = "scholar_id", nullable = false)
    public Scholar getScholarByScholarScholarId() {
        return scholarByScholarScholarId;
    }

    public void setScholarByScholarScholarId(Scholar scholarByScholarScholarId) {
        this.scholarByScholarScholarId = scholarByScholarScholarId;
    }

    @ManyToOne
    @JoinColumn(name = "teacher_teacher_id", referencedColumnName = "teacher_id", nullable = false)
    public Teacher getTeacherByTeacherTeacherId() {
        return teacherByTeacherTeacherId;
    }

    public void setTeacherByTeacherTeacherId(Teacher teacherByTeacherTeacherId) {
        this.teacherByTeacherTeacherId = teacherByTeacherTeacherId;
    }
}
