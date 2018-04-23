package com.Dimcooo.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "list_scholar_subject", schema = "ct_center", catalog = "")
public class ListScholarSubject {
    private int listScholarSubjectId;
    private int scholarScholarId;
    private int subjectSubjectId;
    private Scholar scholarByScholarScholarId;
    private Subject subjectBySubjectSubjectId;

    @Id
    @Column(name = "list_scholar_subject_id", nullable = false)
    public int getListScholarSubjectId() {
        return listScholarSubjectId;
    }

    public void setListScholarSubjectId(int listScholarSubjectId) {
        this.listScholarSubjectId = listScholarSubjectId;
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
        ListScholarSubject that = (ListScholarSubject) o;
        return listScholarSubjectId == that.listScholarSubjectId &&
                scholarScholarId == that.scholarScholarId &&
                subjectSubjectId == that.subjectSubjectId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(listScholarSubjectId, scholarScholarId, subjectSubjectId);
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
    @JoinColumn(name = "subject_subject_id", referencedColumnName = "subject_id", nullable = false)
    public Subject getSubjectBySubjectSubjectId() {
        return subjectBySubjectSubjectId;
    }

    public void setSubjectBySubjectSubjectId(Subject subjectBySubjectSubjectId) {
        this.subjectBySubjectSubjectId = subjectBySubjectSubjectId;
    }
}
