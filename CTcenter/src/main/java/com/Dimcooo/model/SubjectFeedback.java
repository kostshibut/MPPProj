package com.Dimcooo.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "subject_feedback", schema = "ct_center", catalog = "")
public class SubjectFeedback {
    private int subjectFeedbackId;
    private Integer mark;
    private String description;
    private Integer subjectSubjectId;
    private Integer scholarScholarId;

    @Id
    @Column(name = "subject_feedback_id", nullable = false)
    public int getSubjectFeedbackId() {
        return subjectFeedbackId;
    }

    public void setSubjectFeedbackId(int subjectFeedbackId) {
        this.subjectFeedbackId = subjectFeedbackId;
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
    @Column(name = "subject_subject_id", nullable = true)
    public Integer getSubjectSubjectId() {
        return subjectSubjectId;
    }

    public void setSubjectSubjectId(Integer subjectSubjectId) {
        this.subjectSubjectId = subjectSubjectId;
    }

    @Basic
    @Column(name = "scholar_scholar_id", nullable = true)
    public Integer getScholarScholarId() {
        return scholarScholarId;
    }

    public void setScholarScholarId(Integer scholarScholarId) {
        this.scholarScholarId = scholarScholarId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubjectFeedback that = (SubjectFeedback) o;
        return subjectFeedbackId == that.subjectFeedbackId &&
                Objects.equals(mark, that.mark) &&
                Objects.equals(description, that.description) &&
                Objects.equals(subjectSubjectId, that.subjectSubjectId) &&
                Objects.equals(scholarScholarId, that.scholarScholarId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(subjectFeedbackId, mark, description, subjectSubjectId, scholarScholarId);
    }
}
