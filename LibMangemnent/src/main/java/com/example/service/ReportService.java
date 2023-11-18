package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Report;
import com.example.exception.ResourceNotFoundException;
import com.example.repository.ReportRepository;

import java.util.List;

@Service
public class ReportService {

    @Autowired
    private ReportRepository reportRepository;

    public List<Report> getAllReports() {
        return reportRepository.findAll();
    }

    public Report getReportByRegNo(String regNo) {
        return reportRepository.findById(regNo)
                .orElseThrow(() -> new ResourceNotFoundException("Report not found with regNo: " + regNo));
    }

    public Report createReport(Report report) {
        return reportRepository.save(report);
    }

    public Report updateReport(String regNo, Report updatedReport) {
        if (reportRepository.existsById(regNo)) {
            updatedReport.setRegNo(regNo);
            return reportRepository.save(updatedReport);
        } else {
            throw new ResourceNotFoundException("Report not found with regNo: " + regNo);
        }
    }

    public void deleteReport(String regNo) {
        if (reportRepository.existsById(regNo)) {
            reportRepository.deleteById(regNo);
        } else {
            throw new ResourceNotFoundException("Report not found with regNo: " + regNo);
        }
    }
}
