package com.Dimcooo.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "subject_feedback", schema = "ct_center", catalog = "")
public class SubjectFeedback {
    private int subjectFeedbackId;
    private Integer mark;
    private String description;
    private int subjectSubjectId;
    private int scholarScholarId;
    private Subject subjectBySubjectSubjectId;
    private Scholar scholarByScholarScholarId;

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
    @Column(name = "subject_subject_id", nullable = false)
    public int getSubjectSubjectId() {
        return subjectSubjectId;
    }

    public void setSubjectSubjectId(int subjectSubjectId) {
        this.subjectSubjectId = subjectSubjectId;
    }

    @Basic
    @Column(name = "scholar_scholar_id", nullable = false)
    public int getScholarScholarId() {
        return scholarScholarId;
    }

    public void setScholarScholarId(int scholarScholarId) {
        this.scholarScholarId = scholarScholarId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubjectFeedback that = (SubjectFeedback) o;
        return subjectFeedbackId == that.subjectFeedbackId &&
                subjectSubjectId == that.subjectSubjectId &&
                scholarScholarId == that.scholarScholarId &&
                Objects.equals(mark, that.mark) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(subjectFeedbackId, mark, description, subjectSubjectId, scholarScholarId);
    }

    @ManyToOne
    @JoinColumn(name = "subject_subject_id", referencedColumnName = "subject_id", nullable = false)
    public Subject getSubjectBySubjectSubjectId() {
        return subjectBySubjectSubjectId;
    }

    public void setSubjectBySubjectSubjectId(Subject subjectBySubjectSubjectId) {
        this.subjectBySubjectSubjectId = subjectBySubjectSubjectId;
    }

    @ManyToOne
    @JoinColumn(name = "scholar_scholar_id", referencedColumnName = "scholar_id", nullable = false)
    public Scholar getScholarByScholarScholarId() {
        return scholarByScholarScholarId;
    }

    public void setScholarByScholarScholarId(Scholar scholarByScholarScholarId) {
        this.scholarByScholarScholarId = scholarByScholarScholarId;
    }
}
