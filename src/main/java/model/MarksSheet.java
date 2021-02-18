package model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "marks_sheet")
@Data
@NoArgsConstructor
public class MarksSheet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "marks_sheet_id")
    private int id;
}
