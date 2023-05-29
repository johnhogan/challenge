package com.mindex.challenge.data;

import java.math.BigDecimal;
import java.time.LocalDate;
import org.springframework.data.annotation.Id;

public class Compensation {
    @Id
    String compensationId;
    Employee employee;
    BigDecimal salary;
    LocalDate effectiveDate;

    public String getCompensationId() {
        return compensationId;
    }

    public void setCompensationId(String compensationId) {
        this.compensationId = compensationId;
    }

    
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
        this.compensationId=employee.getEmployeeId();
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public LocalDate getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(LocalDate effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    @Override
    public String toString() {
        return "Compensation{" + "compensationId=" + compensationId + ", employee=" + employee + ", salary=" + salary + ", effectiveDate=" + effectiveDate + '}';
    }

}
