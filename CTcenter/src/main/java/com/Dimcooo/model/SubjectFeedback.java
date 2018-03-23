package com.Dimcooo.model;

import javax.persistence.*;

@Entity
@Table(name = "subject_feedback", schema = "training_center")
public class SubjectFeedback {
    private int id;
    private int mark;
    private String description;
    private Scholar scholarByScholarId;
    private Subject subjectBySubjectId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "mark", nullable = false)
    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    @Basic
    @Column(name = "description", nullable = false, length = 255)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SubjectFeedback that = (SubjectFeedback) o;

        if (id != that.id) return false;
        if (mark != that.mark) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + mark;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "Scholar_id", referencedColumnName = "id", nullable = false)
    public Scholar getScholarByScholarId() {
        return scholarByScholarId;
    }

    public void setScholarByScholarId(Scholar scholarByScholarId) {
        this.scholarByScholarId = scholarByScholarId;
    }

    @ManyToOne
    @JoinColumn(name = "Subject_id", referencedColumnName = "id", nullable = false)
    public Subject getSubjectBySubjectId() {
        return subjectBySubjectId;
    }

    public void setSubjectBySubjectId(Subject subjectBySubjectId) {
        this.subjectBySubjectId = subjectBySubjectId;
    }
}
