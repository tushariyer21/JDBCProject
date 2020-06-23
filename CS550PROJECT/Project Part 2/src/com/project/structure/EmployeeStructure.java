package com.project.structure;

import java.util.ArrayList;

public class EmployeeStructure {
	private String ssn;
	private String fname;
	private String lname;
	private String bdate;
	private String dname;
	private ArrayList<DependentStructure> dependent;

	public EmployeeStructure(String ssn2, String fname, String lname, String bdate, String dname, ArrayList<DependentStructure> dependent) {
		this.ssn = ssn2;
		this.fname = fname;
		this.lname = lname;
		this.bdate = bdate;
		this.dname = dname;
		this.setDependent(dependent);
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getBdate() {
		return bdate;
	}

	public void setBdate(String bdate) {
		this.bdate = bdate;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public ArrayList<DependentStructure> getDependent() {
		return dependent;
	}

	public void setDependent(ArrayList<DependentStructure> dependent) {
		this.dependent = dependent;
	}

}
