package com.Dimcooo.model;

import javax.persistence.*;
import java.sql.Time;

@Entity
public class Subject {
    private int id;
    private String name;
    private Time duration;
    private Teacher teacherByTeacherId;
    private SubjectScholarList subjectScholarListByScholarListId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "duration", nullable = false)
    public Time getDuration() {
        return duration;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Subject subject = (Subject) o;

        if (id != subject.id) return false;
        if (name != null ? !name.equals(subject.name) : subject.name != null) return false;
        if (duration != null ? !duration.equals(subject.duration) : subject.duration != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (duration != null ? duration.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "Teacher_id", referencedColumnName = "id", nullable = false)
    public Teacher getTeacherByTeacherId() {
        return teacherByTeacherId;
    }

    public void setTeacherByTeacherId(Teacher teacherByTeacherId) {
        this.teacherByTeacherId = teacherByTeacherId;
    }

    @ManyToOne
    @JoinColumn(name = "Scholar_list_ID", referencedColumnName = "ID", nullable = false)
    public SubjectScholarList getSubjectScholarListByScholarListId() {
        return subjectScholarListByScholarListId;
    }

    public void setSubjectScholarListByScholarListId(SubjectScholarList subjectScholarListByScholarListId) {
        this.subjectScholarListByScholarListId = subjectScholarListByScholarListId;
    }
}
