package alebid.stasjavademo.entities;

import java.time.LocalDateTime;

public class Shift {

    private String id;
    private LocalDateTime LOG_IN;
    private LocalDateTime LOG_OUT;
    private LocalDateTime BREAK_IN_1;
    private LocalDateTime BREAK_OUT_1;
    private LocalDateTime BREAK_IN_2;
    private LocalDateTime BREAK_OUT_2;
    private LocalDateTime LUNCH_IN;
    private LocalDateTime LUNCH_OUT;
    private Employee employee;

    public Shift() {
    }

    public Shift(String id, LocalDateTime LOG_IN, LocalDateTime LOG_OUT, LocalDateTime BREAK_IN_1, LocalDateTime BREAK_OUT_1, LocalDateTime BREAK_IN_2, LocalDateTime BREAK_OUT_2, LocalDateTime LUNCH_IN, LocalDateTime LUNCH_OUT, Employee employee) {
        this.id = id;
        this.LOG_IN = LOG_IN;
        this.LOG_OUT = LOG_OUT;
        this.BREAK_IN_1 = BREAK_IN_1;
        this.BREAK_OUT_1 = BREAK_OUT_1;
        this.BREAK_IN_2 = BREAK_IN_2;
        this.BREAK_OUT_2 = BREAK_OUT_2;
        this.LUNCH_IN = LUNCH_IN;
        this.LUNCH_OUT = LUNCH_OUT;
        this.employee = employee;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public LocalDateTime getLOG_IN() {
        return LOG_IN;
    }

    public void setLOG_IN(LocalDateTime LOG_IN) {
        this.LOG_IN = LOG_IN;
    }

    public LocalDateTime getLOG_OUT() {
        return LOG_OUT;
    }

    public void setLOG_OUT(LocalDateTime LOG_OUT) {
        this.LOG_OUT = LOG_OUT;
    }

    public LocalDateTime getBREAK_IN_1() {
        return BREAK_IN_1;
    }

    public void setBREAK_IN_1(LocalDateTime BREAK_IN_1) {
        this.BREAK_IN_1 = BREAK_IN_1;
    }

    public LocalDateTime getBREAK_OUT_1() {
        return BREAK_OUT_1;
    }

    public void setBREAK_OUT_1(LocalDateTime BREAK_OUT_1) {
        this.BREAK_OUT_1 = BREAK_OUT_1;
    }

    public LocalDateTime getBREAK_IN_2() {
        return BREAK_IN_2;
    }

    public void setBREAK_IN_2(LocalDateTime BREAK_IN_2) {
        this.BREAK_IN_2 = BREAK_IN_2;
    }

    public LocalDateTime getBREAK_OUT_2() {
        return BREAK_OUT_2;
    }

    public void setBREAK_OUT_2(LocalDateTime BREAK_OUT_2) {
        this.BREAK_OUT_2 = BREAK_OUT_2;
    }

    public LocalDateTime getLUNCH_IN() {
        return LUNCH_IN;
    }

    public void setLUNCH_IN(LocalDateTime LUNCH_IN) {
        this.LUNCH_IN = LUNCH_IN;
    }

    public LocalDateTime getLUNCH_OUT() {
        return LUNCH_OUT;
    }

    public void setLUNCH_OUT(LocalDateTime LUNCH_OUT) {
        this.LUNCH_OUT = LUNCH_OUT;
    }

    public void reset() {
        LOG_IN = null;
        LOG_OUT = null;
        BREAK_IN_1 = null;
        BREAK_OUT_1 = null;
        BREAK_IN_2 = null;
        BREAK_OUT_2 = null;
        LUNCH_IN = null;
        LUNCH_OUT = null;
        employee = null;
    }




}
