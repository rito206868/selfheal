package com.leanfix.data.model;

public class LabRecord {

	private String internalID;
	private String diagnosis;
	private String docName;
	private String department;

	public LabRecord() {

	}

	public LabRecord(String internalID, String diagnosis, String docName, String department) {
		this.internalID = internalID;
		this.diagnosis = diagnosis;
		this.docName = docName;
		this.department = department;
	}

	public String getInternalID() {
		return internalID;
	}

	public void setInternalID(String internalID) {
		this.internalID = internalID;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

}
