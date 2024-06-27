package alebid.stasjavademo.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
public class EmployeeType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "typeId")
    private int id;

    @NotBlank(message = "Employee Name Can't be blank")
    @Size(min = 3, max = 20, message = "Employee name can't be more 20 and less 3 characters")
    private String employeeName;

    @OneToMany(mappedBy = "employeeType", fetch = FetchType.LAZY)
    private List<Employee> employeeList;

    public EmployeeType() {
    }

    public EmployeeType(String employeeName, int id) {
        this.employeeName = employeeName;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @NotBlank(message = "Employee Name Can't be blank") @Size(min = 3, max = 20, message = "Employee name can't be more 20 and less 3 characters") String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(@NotBlank(message = "Employee Name Can't be blank") @Size(min = 3, max = 20, message = "Employee name can't be more 20 and less 3 characters") String employeeName) {
        this.employeeName = employeeName;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
