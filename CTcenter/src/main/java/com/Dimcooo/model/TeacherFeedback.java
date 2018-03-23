package com.Dimcooo.model;

import javax.persistence.*;

@Entity
@Table(name = "teacher_feedback", schema = "training_center")
public class TeacherFeedback {
    private int id;
    private int mark;
    private String description;

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

        TeacherFeedback that = (TeacherFeedback) o;

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
}
