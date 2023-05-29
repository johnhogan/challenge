package com.mindex.challenge.controller;

import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.EmployeeService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReportingStructureController {

    private static final Logger LOG = LoggerFactory.getLogger(ReportingStructureController.class);

    @Autowired
    private EmployeeService employeeService;
    
    @GetMapping("/employeeReportingStructure/{id}")
    public ReportingStructure getReports(@PathVariable String id) {
        LOG.debug("Received employeeReportingStructure request for id [{}]", id);
        Employee employee = employeeService.read(id);
        LOG.debug("Processing reports for {}", employee.getFirstName() + " " + employee.getLastName());
        ReportingStructure reportingStructure = new ReportingStructure(employee);

        boolean hasReports = (employee.getDirectReports() != null && !employee.getDirectReports().isEmpty());
        int numberOfReports=0;
        if (hasReports) {

            numberOfReports = processReports(employee.getDirectReports());

        }
        reportingStructure.setEmployee(employee);
        reportingStructure.setNumberOfReports(numberOfReports);
        LOG.debug("Reporting Structure = {}", reportingStructure);

        return reportingStructure;
    }

    int processReports(List<Employee> reports) {
        LOG.debug("processReports, count = {}", reports.size());
        int reportCount=0;

        for (Employee emp : reports) {
            emp = employeeService.read(emp.getEmployeeId());
            LOG.debug("Processing emp {}", emp.getFirstName() + " " + emp.getLastName());

            // Does current employee have reports?
            boolean hasReports = (emp.getDirectReports() != null && !emp.getDirectReports().isEmpty());
            if (hasReports) {
                reportCount=reportCount+reports.size();
                reportCount=reportCount+emp.getDirectReports().size();
                LOG.debug("Emp {}", emp.getFirstName() + " has () reports.", reportCount);
                processReports(emp.getDirectReports());
            } else {
                LOG.debug("No reports, done processing for {}", emp.getFirstName());
            }
        }

        return reportCount;

    }
}