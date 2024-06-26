package alebid.stasjavademo.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;


@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employeeId")
    private int id;

    @NotBlank(message = "First Name can't be blank")
    @Size(min = 3, max = 20, message = "First name can't be more 20 and less 3 characters")
    private String employeeFirstName;

    @Size(max = 1, message = "Middle Initial can't be more 1 character")
    private String middleInitial;

    @NotBlank(message = "Last Name can't be blank")
    @Size(min = 3, max = 20, message = "Last name can't be more 20 and less 3 characters")
    private String employeeLastName;

    @NotNull(message = "Status can't be null")
    private int employeeStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "typeId", foreignKey = @ForeignKey(name = "FK_Employee_Type"))
    @NotNull(message = "Employee Type is required")
    private EmployeeType employeeType;

    @OneToMany(mappedBy = "RawScan", fetch = FetchType.LAZY)
    private List<RawScan> scanList;

    public Employee() {
    }

    public Employee(int id, String employeeFirstName, String middleInitial, String employeeLastName, int employeeStatus) {
        this.id = id;
        this.employeeFirstName = employeeFirstName;
        this.middleInitial = middleInitial;
        this.employeeLastName = employeeLastName;
        this.employeeStatus = employeeStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @NotBlank(message = "First Name can't be blank") @Size(min = 3, max = 20, message = "First name can't be more 20 and less 3 characters") String getEmployeeFirstName() {
        return employeeFirstName;
    }

    public void setEmployeeFirstName(@NotBlank(message = "First Name can't be blank") @Size(min = 3, max = 20, message = "First name can't be more 20 and less 3 characters") String employeeFirstName) {
        this.employeeFirstName = employeeFirstName;
    }

    public @Size(max = 1, message = "Middle Initial can't be more 1 character") String getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(@Size(max = 1, message = "Middle Initial can't be more 1 character") String middleInitial) {
        this.middleInitial = middleInitial;
    }

    public @NotBlank(message = "Last Name can't be blank") @Size(min = 3, max = 20, message = "Last name can't be more 20 and less 3 characters") String getEmployeeLastName() {
        return employeeLastName;
    }

    public void setEmployeeLastName(@NotBlank(message = "Last Name can't be blank") @Size(min = 3, max = 20, message = "Last name can't be more 20 and less 3 characters") String employeeLastName) {
        this.employeeLastName = employeeLastName;
    }

    @NotNull(message = "Status can't be null")
    public int getEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(@NotNull(message = "Status can't be null") int employeeStatus) {
        this.employeeStatus = employeeStatus;
    }

    public @NotNull(message = "Employee Type is required") EmployeeType getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(@NotNull(message = "Employee Type is required") EmployeeType employeeType) {
        this.employeeType = employeeType;
    }
}
