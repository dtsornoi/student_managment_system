package model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "attendance")
@Data
@NoArgsConstructor
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attendance_id")
    private int id;

    @Column(name = "lectures_delivered")
    private int lecturesDelivered;

    @Column(name = "attended")
    private boolean Attended;
}
