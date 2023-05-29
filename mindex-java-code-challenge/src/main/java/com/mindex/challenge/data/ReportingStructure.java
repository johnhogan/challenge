package com.mindex.challenge.data;

public class ReportingStructure {

    private Employee employee;
    private int numberOfReports;

    public ReportingStructure() {
    }

    public ReportingStructure(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getNumberOfReports() {
        return numberOfReports;
    }

    public void setNumberOfReports(int numberOfReports) {
        this.numberOfReports = numberOfReports;
    }

    public void incrementNumberOfReports() {
        numberOfReports++;
    }

    @Override
    public String toString() {
        return "ReportingStructure{" + "employee=" + employee + ", numberOfReports=" + numberOfReports + '}';
    }

    public void addToReports(int nReports) {
        numberOfReports = numberOfReports + nReports;
    }

}
