package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.entity.Report;
import com.example.service.ReportService;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    //CRUD Operation
  
    //@GetMapping("/") retrieves all reports.
    @GetMapping
    public List<Report> getAllReports() {
        return reportService.getAllReports();
    }

    //@GetMapping("/{regNo}") retrieves a specific report by registration number (regNo).
    @GetMapping("/{regNo}")
    public ResponseEntity<Report> getReportByRegNo(@PathVariable String regNo) {
        Report report = reportService.getReportByRegNo(regNo);
        return ResponseEntity.ok().body(report);
    }

    //@PostMapping creates a new report.
    @PostMapping
    public ResponseEntity<Report> createReport(@RequestBody Report report) {
        Report createdReport = reportService.createReport(report);
        return new ResponseEntity<>(createdReport, HttpStatus.CREATED);
    }

    //@PutMapping("/{regNo}") updates an existing report by registration number (regNo).
    @PutMapping("/{regNo}")
    public ResponseEntity<Report> updateReport(@PathVariable String regNo, @RequestBody Report report) {
        Report updatedReport = reportService.updateReport(regNo, report);
        return ResponseEntity.ok().body(updatedReport);
    }

    //@DeleteMapping("/{regNo}") deletes a report by registration number (regNo).
    @DeleteMapping("/{regNo}")
    public ResponseEntity<Void> deleteReport(@PathVariable String regNo) {
        reportService.deleteReport(regNo);
        return ResponseEntity.noContent().build();
    }
}
