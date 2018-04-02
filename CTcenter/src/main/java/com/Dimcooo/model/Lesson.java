package com.Dimcooo.model;

import javax.persistence.*;
import java.sql.Time;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Lesson {
    private int lessonId;
    private String theme;
    private Time duration;
    private int subjectSubjectId;
    private Subject subjectBySubjectSubjectId;
    private Collection<Task> tasksByLessonId;

    @Id
    @Column(name = "lesson_id", nullable = false)
    public int getLessonId() {
        return lessonId;
    }

    public void setLessonId(int lessonId) {
        this.lessonId = lessonId;
    }

    @Basic
    @Column(name = "theme", nullable = false, length = 45)
    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    @Basic
    @Column(name = "duration", nullable = false)
    public Time getDuration() {
        return duration;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
    }

    @Basic
    @Column(name = "subject_subject_id", nullable = false)
    public int getSubjectSubjectId() {
        return subjectSubjectId;
    }

    public void setSubjectSubjectId(int subjectSubjectId) {
        this.subjectSubjectId = subjectSubjectId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lesson lesson = (Lesson) o;
        return lessonId == lesson.lessonId &&
                subjectSubjectId == lesson.subjectSubjectId &&
                Objects.equals(theme, lesson.theme) &&
                Objects.equals(duration, lesson.duration);
    }

    @Override
    public int hashCode() {

        return Objects.hash(lessonId, theme, duration, subjectSubjectId);
    }

    @ManyToOne
    @JoinColumn(name = "subject_subject_id", referencedColumnName = "subject_id", nullable = false)
    public Subject getSubjectBySubjectSubjectId() {
        return subjectBySubjectSubjectId;
    }

    public void setSubjectBySubjectSubjectId(Subject subjectBySubjectSubjectId) {
        this.subjectBySubjectSubjectId = subjectBySubjectSubjectId;
    }

    @OneToMany(mappedBy = "lessonByLessonLessonId")
    public Collection<Task> getTasksByLessonId() {
        return tasksByLessonId;
    }

    public void setTasksByLessonId(Collection<Task> tasksByLessonId) {
        this.tasksByLessonId = tasksByLessonId;
    }
}
