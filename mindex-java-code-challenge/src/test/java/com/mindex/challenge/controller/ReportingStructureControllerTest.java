package com.mindex.challenge.controller;

import com.mindex.challenge.data.ReportingStructure;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ReportingStructureControllerTest {

    private String reportingStructureIdUrl;

    @LocalServerPort
    private int port;
    
    @Autowired
    private ReportingStructureController rs;

    @Autowired
    private TestRestTemplate restTemplate;

    @Before
    public void setup() {
        reportingStructureIdUrl = "http://localhost:" + port + "/employeeReportingStructure/{id}";
    }

    @Test
    public void testControllerGetReports() {
        // DataBootstrap loaded at startup.
        ReportingStructure empReports=rs.getReports("16a596ae-edd3-4847-99fe-c4518e82c86f");
        assertEquals(4, empReports.getNumberOfReports());
    }

    @Test
    public void testReportsReadEndpoint() {
        // DataBootstrap loaded at startup.
        ReportingStructure empReports = restTemplate.getForEntity(reportingStructureIdUrl, ReportingStructure.class, "16a596ae-edd3-4847-99fe-c4518e82c86f").getBody();
        assertEquals(4, empReports.getNumberOfReports());
    }
    
}
