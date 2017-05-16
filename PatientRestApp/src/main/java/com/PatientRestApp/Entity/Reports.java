package com.PatientRestApp.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Reports {

@Id
@Column(name="ReportsID")
private int ReportsID;
@Column(name="InsuranceNum")
private String InsuranceNum;
@Column(name="Status")
private String Status;
@Column(name="RevistDate")
private Date RevistDate;
public int getReportsID() {
	return ReportsID;
}
public void setReportsID(int reportsID) {
	ReportsID = reportsID;
}
public String getInsuranceNum() {
	return InsuranceNum;
}
public void setInsuranceNum(String insuranceNum) {
	InsuranceNum = insuranceNum;
}
public String getStatus() {
	return Status;
}
public void setStatus(String status) {
	Status = status;
}
public Date getRevistDate() {
	return RevistDate;
}
public void setRevistDate(Date revistDate) {
	RevistDate = revistDate;
}
}
