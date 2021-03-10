package model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "grades")
@Data
@NoArgsConstructor
public class Grades {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "grade_id")
    private int gradeId;

    @Column(name = "grade")
    private String grade;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Person student;

    public Grades(String gradeInput, Person student) {
        this.grade = gradeInput;
        this.student = student;
        this.course = course;
    }
}
