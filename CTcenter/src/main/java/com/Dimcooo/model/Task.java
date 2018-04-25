package com.Dimcooo.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Task {
    private int taskId;
    private String theme;
    private int lessonLessonId;
    private Lesson lessonByLessonLessonId;
    private String content;

    @Id
    @Column(name = "task_id", nullable = false)
    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    @Basic
    @Column(name = "theme", nullable = true, length = 500)
    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    @Basic
    @Column(name = "lesson_lesson_id", nullable = false)
    public int getLessonLessonId() {
        return lessonLessonId;
    }

    public void setLessonLessonId(int lessonLessonId) {
        this.lessonLessonId = lessonLessonId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return taskId == task.taskId &&
                lessonLessonId == task.lessonLessonId &&
                Objects.equals(theme, task.theme);
    }

    @Override
    public int hashCode() {

        return Objects.hash(taskId, theme, lessonLessonId);
    }

    @ManyToOne
    @JoinColumn(name = "lesson_lesson_id", referencedColumnName = "lesson_id", nullable = false)
    public Lesson getLessonByLessonLessonId() {
        return lessonByLessonLessonId;
    }

    public void setLessonByLessonLessonId(Lesson lessonByLessonLessonId) {
        this.lessonByLessonLessonId = lessonByLessonLessonId;
    }

    @Basic
    @Column(name = "content", nullable = true, length = 200)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", theme='" + theme + '\'' +
                ", lessonLessonId=" + lessonLessonId +
                ", lessonByLessonLessonId=" + lessonByLessonLessonId +
                ", content='" + content + '\'' +
                '}';
    }
}
