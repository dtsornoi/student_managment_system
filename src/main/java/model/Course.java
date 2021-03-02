package model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "course")
@Data
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private int courseId;

    @Column(name = "course_name")
    private String courseName;

    @ManyToOne
    @JoinColumn(name = "grade_id")
    private Grades grades;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
}
