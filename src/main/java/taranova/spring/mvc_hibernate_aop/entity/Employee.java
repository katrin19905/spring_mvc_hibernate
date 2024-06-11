package taranova.spring.mvc_hibernate_aop.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "employees")
public class Employee {

    @NotNull
    @Size(min = 3, max = 10, message = "name must be min 3 and max 10 symbols")
    @Column(name = "name")
    private String name;

    @NotNull
    @NotBlank(message = "field must be not blanc, pls enter")
    @Column(name = "surname")
    private String surname;

    @Column(name = "department")
    private String department;

    @NotNull
    @Min(value = 500, message = "min is 500")
    @Max(value = 2000, message = "max is 2000")
    @Column(name = "salary")
    private int salary;

    @Transient
    private Map<String, String> departments;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    public Employee() {
        departments = new HashMap<>();
        departments.put("Information Technology","IT" );
        departments.put("Human Resources", "HR");
        departments.put("Sales", "SALES");
    }


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}