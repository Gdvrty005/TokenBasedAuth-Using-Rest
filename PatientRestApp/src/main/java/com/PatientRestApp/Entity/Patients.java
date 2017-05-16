package com.PatientRestApp.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="patient_details")
public class Patients {

	@Id
	@Column(name="PatientID")
	private int patientId;
	@Column(name="PatientFName")
	private String FName;
	@Column(name="PateintLName")
	private String LName;
	@Column(name="DoctorAssigned")
	private String DName;
	@Column(name="PatientUN")
	private String UName;
	@Column(name="PatientPwd")
	private String Pwd;
	
	
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getFName() {
		return FName;
	}
	public void setFName(String fName) {
		FName = fName;
	}
	public String getLName() {
		return LName;
	}
	public void setLName(String lName) {
		LName = lName;
	}
	public String getDName() {
		return DName;
	}
	public void setDName(String dName) {
		DName = dName;
	}
	public String getUName() {
		return UName;
	}
	public void setUName(String uName) {
		UName = uName;
	}
	public String getPwd() {
		return Pwd;
	}
	public void setPwd(String pwd) {
		Pwd = pwd;
	}

	
	
}
