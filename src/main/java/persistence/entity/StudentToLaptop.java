package persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "student_laptop")
public class StudentToLaptop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "student_rollno")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "laptop_id")
    private Laptop laptop;
}
