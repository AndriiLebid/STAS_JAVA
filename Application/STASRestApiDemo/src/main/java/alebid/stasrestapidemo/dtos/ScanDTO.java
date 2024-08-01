package alebid.stasrestapidemo.dtos;


import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class ScanDTO {

    @NotNull(message = "Code can't be empty")
    private String employeeCode;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
    @NotNull(message = "Scan Date can't be empty")
    private LocalDateTime scanDate;

    @NotNull(message = "Scan Type can't be empty")
    private String scanType;

    public ScanDTO() {
    }

    public ScanDTO(String employeeCode, LocalDateTime scanDate, String scanType) {
        this.employeeCode = employeeCode;
        this.scanDate = scanDate;
        this.scanType = scanType;
    }

    public @NotNull(message = "Code can't be empty") String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(@NotNull(message = "Code can't be empty") String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public @NotNull(message = "Scan Date can't be empty") LocalDateTime getScanDate() {
        return scanDate;
    }

    public void setScanDate(@NotNull(message = "Scan Date can't be empty") LocalDateTime scanDate) {
        this.scanDate = scanDate;
    }

    public @NotNull(message = "Scan Type can't be empty") String getScanType() {
        return scanType;
    }

    public void setScanType(@NotNull(message = "Scan Type can't be empty") String scanType) {
        this.scanType = scanType;
    }
}
