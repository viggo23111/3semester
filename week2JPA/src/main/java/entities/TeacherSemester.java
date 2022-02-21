package entities;

import javax.persistence.*;

@Entity
@Table(name = "TEACHER_SEMESTER", schema = "ExamPreparationJPQL", catalog = "")
@IdClass(TeacherSemesterPK.class)
public class TeacherSemester {
    private long teachingId;
    private long teachersId;

    @Id
    @Column(name = "teaching_ID")
    public long getTeachingId() {
        return teachingId;
    }

    public void setTeachingId(long teachingId) {
        this.teachingId = teachingId;
    }

    @Id
    @Column(name = "teachers_ID")
    public long getTeachersId() {
        return teachersId;
    }

    public void setTeachersId(long teachersId) {
        this.teachersId = teachersId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TeacherSemester that = (TeacherSemester) o;

        if (teachingId != that.teachingId) return false;
        if (teachersId != that.teachersId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (teachingId ^ (teachingId >>> 32));
        result = 31 * result + (int) (teachersId ^ (teachersId >>> 32));
        return result;
    }
}
