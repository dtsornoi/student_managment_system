package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "people")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "address")
    private String address;

    @Column(name = "is_teacher")
    private boolean isTeacher;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    public Person(String firstName, String lastName, String address, boolean isTeacher) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.isTeacher = isTeacher;
    }
}
