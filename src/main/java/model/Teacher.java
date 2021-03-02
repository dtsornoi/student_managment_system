package model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "teachers")
@Data
@NoArgsConstructor
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id")
    private int teacherId;

    @Column(name = "teacher_first_name")
    private String teacherFirstName;

    @Column(name = "teacher_last_name")
    private String teacherLastName;

    @Column(name = "teacher_address")
    private String teacherAddress;

}
