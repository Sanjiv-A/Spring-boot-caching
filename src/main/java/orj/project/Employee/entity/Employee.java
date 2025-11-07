package orj.project.Employee.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Entity
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString
public class Employee implements  Serializable  {
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private  String role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    @Override
    public String toString() {
        return "Employee{id=" + id + ", name=" + name + "}";
    }

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;


}
