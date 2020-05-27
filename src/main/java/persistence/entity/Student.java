package persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int rollno;

    @Column(name = "name")
    private String name;

    @Column(name = "marks")
    private String marks;

    @OneToMany
    private List<StudentToLaptop> studentToLaptops;

    public List<StudentToLaptop> getStudentToLaptops() {
        return studentToLaptops;
    }

    public void setStudentToLaptops(List<StudentToLaptop> studentToLaptops) {
        this.studentToLaptops = studentToLaptops;
    }

    public Student() {
    }

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }
}
