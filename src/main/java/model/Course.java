package model;

import lombok.*;

import javax.persistence.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private int courseId;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "teacher_name")
    private String teacherName;

    @ManyToOne
    @JoinColumn(name = "grade_id")
    private Grades grades;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Person teacher;


    public Course(String courseName, String teacherName) {
        this.courseName = courseName;
        this.teacherName = teacherName;
    }
}
