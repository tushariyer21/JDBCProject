package com.project.structure;

public class ManagerStructure {
	private int ssn;
	private String fname;
	private String lname;
	
	public ManagerStructure(int ssn, String fname, String lname) {
		super();
		this.ssn = ssn;
		this.fname = fname;
		this.setLname(lname);
	}

	public int getSsn() {
		return ssn;
	}

	public void setSsn(int ssn) {
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

}
