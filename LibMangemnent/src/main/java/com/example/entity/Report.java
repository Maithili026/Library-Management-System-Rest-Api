package com.example.entity;




import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table
public class Report {

    @Id
    private String regNo; // Assuming regNo is the Primary Key

    private Long userId;
    private Long bookNo;
    private Date issueDate;
    private Date returnDate;
    
    // Constructors, getters, setters...
    
    public Report() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Report(String regNo, Long userId, Long bookNo, Date issueDate, Date returnDate) {
		super();
		this.regNo = regNo;
		this.userId = userId;
		this.bookNo = bookNo;
		this.issueDate = issueDate;
		this.returnDate = returnDate;
	}
	public String getRegNo() {
		return regNo;
	}
	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getBookNo() {
		return bookNo;
	}
	public void setBookNo(Long bookNo) {
		this.bookNo = bookNo;
	}
	public Date getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
    
    
}
