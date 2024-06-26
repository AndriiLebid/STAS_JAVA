package alebid.stasjavademo.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
public class RawScan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "scanId")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employeeId", foreignKey = @ForeignKey(name = "FK_Employee_Scan"))
    @NotNull(message = "Employee is required")
    private Employee employee;

    @Column(nullable = false)
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
    @NotNull(message = "Scan Date can't be empty")
    private LocalDate scanDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "typeId", foreignKey = @ForeignKey(name = "FK_Scan_Type"))
    @NotNull(message = "Scan Type is required")
    private ScanType scanType;

    public RawScan() {
    }

    public RawScan(int id, Employee employee, LocalDate scanDate, ScanType scanType) {
        this.id = id;
        this.employee = employee;
        this.scanDate = scanDate;
        this.scanType = scanType;
    }

    public @NotNull(message = "Scan Type is required") ScanType getScanType() {
        return scanType;
    }

    public void setScanType(@NotNull(message = "Scan Type is required") ScanType scanType) {
        this.scanType = scanType;
    }

    public @NotNull(message = "Scan Date can't be empty") LocalDate getScanDate() {
        return scanDate;
    }

    public void setScanDate(@NotNull(message = "Scan Date can't be empty") LocalDate scanDate) {
        this.scanDate = scanDate;
    }

    public @NotNull(message = "Employee is required") Employee getEmployee() {
        return employee;
    }

    public void setEmployee(@NotNull(message = "Employee is required") Employee employee) {
        this.employee = employee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
