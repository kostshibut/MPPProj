package com.Dimcooo.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Subject {
    private int subjectId;
    private String name;
    private int duration;
    private int teacherTeacherId;
    private Collection<Lesson> lessonsBySubjectId;
    private Collection<ListScholarSubject> listScholarSubjectsBySubjectId;
    private Teacher teacherByTeacherTeacherId;

    @Id
    @Column(name = "subject_id", nullable = false)
    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
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
    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
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
        Subject subject = (Subject) o;
        return subjectId == subject.subjectId &&
                duration == subject.duration &&
                teacherTeacherId == subject.teacherTeacherId &&
                Objects.equals(name, subject.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(subjectId, name, duration, teacherTeacherId);
    }

    @OneToMany(mappedBy = "subjectBySubjectSubjectId")
    public Collection<Lesson> getLessonsBySubjectId() {
        return lessonsBySubjectId;
    }

    public void setLessonsBySubjectId(Collection<Lesson> lessonsBySubjectId) {
        this.lessonsBySubjectId = lessonsBySubjectId;
    }

    @OneToMany(mappedBy = "subjectBySubjectSubjectId")
    public Collection<ListScholarSubject> getListScholarSubjectsBySubjectId() {
        return listScholarSubjectsBySubjectId;
    }

    public void setListScholarSubjectsBySubjectId(Collection<ListScholarSubject> listScholarSubjectsBySubjectId) {
        this.listScholarSubjectsBySubjectId = listScholarSubjectsBySubjectId;
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
