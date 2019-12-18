/**
 * 
 */
package com.leanfix.data.model;

import java.io.Serializable;

public class Source implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7082424711442978286L;
	private String internalID;
	private String name;
	private String alias;
	private String dob;
	private String sex;
	private String race;
	private String address;
	private String phoneNumber;
	private String ssn;
	private String diagnosis;
	private String docName;
	private String department;
	private String emergencyNumber;

	public Source() {
	}

	public Source(String internalID, String name, String alias, String dob, String sex, String race, String address,
			String phoneNumber, String ssn, String diagnosis, String docName, String department,
			String emergencyNumber) {
		this.internalID = internalID;
		this.name = name;
		this.alias = alias;
		this.dob = dob;
		this.sex = sex;
		this.race = race;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.ssn = ssn;
		this.diagnosis = diagnosis;
		this.docName = docName;
		this.department = department;
		this.emergencyNumber = emergencyNumber;
	}

	public String getInternalID() {
		return internalID;
	}

	public void setInternalID(String internalID) {
		this.internalID = internalID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
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

	public String getEmergencyNumber() {
		return emergencyNumber;
	}

	public void setEmergencyNumber(String emergencyNumber) {
		this.emergencyNumber = emergencyNumber;
	}

	@Override
	public String toString() {
		return "{\"internalID\":\"" + internalID + "\"" + ", \"name\":\"" + name + "\"" + ", \"alias\":\"" + alias
				+ "\"" + ", \"dob\":\"" + dob + "\"" + ", \"sex\":\"" + sex + "\"" + ", \"race\":\"" + race + "\""
				+ ", \"address\":\"" + address + "\"" + ", \"phoneNumber\":\"" + phoneNumber + "\"" + ", \"ssn\":\""
				+ ssn + "\"" + ", \"diagnosis\":\"" + diagnosis + "\"" + ", \"docName\":\"" + docName + "\""
				+ ", \"department\":\"" + department + "\"" + ", \"emergencyNumber\":\"" + emergencyNumber + "\"" + "}";
	}

}