package com.project.structure;

public class ProjectsModel {
	private String fname;
	private String lname;
	private String pname;
	private int pnumber;
	private String plocation;
	private int dnum;
	private String dname;
	

	public ProjectsModel(int dnum, String plocation, String pname, int pnumber, String dname, String fname, String lname) {
		// TODO Auto-generated constructor stub
		super();
		this.setDnum(dnum);
		this.setPlocation(plocation);
		this.setPnumber(pnumber);
		this.setPname(pname);
		this.setDname(dname);
		this.setFname(fname);
		this.setLname(lname);
	}


	/**
	 * @return the pname
	 */
	public String getPname() {
		return pname;
	}


	/**
	 * @param pname the pname to set
	 */
	public void setPname(String pname) {
		this.pname = pname;
	}


	/**
	 * @return the pnumber
	 */
	public int getPnumber() {
		return pnumber;
	}


	/**
	 * @param pnumber the pnumber to set
	 */
	public void setPnumber(int pnumber) {
		this.pnumber = pnumber;
	}


	/**
	 * @return the plocation
	 */
	public String getPlocation() {
		return plocation;
	}


	/**
	 * @param plocation the plocation to set
	 */
	public void setPlocation(String plocation) {
		this.plocation = plocation;
	}


	/**
	 * @return the dnum
	 */
	public int getDnum() {
		return dnum;
	}


	/**
	 * @param dnum the dnum to set
	 */
	public void setDnum(int dnum) {
		this.dnum = dnum;
	}

	/**
	 * @return the dname
	 */
	public String getDname() {
		return dname;
	}


	/**
	 * @param dname the dname to set
	 */
	public void setDname(String dname) {
		this.dname = dname;
	}


	/**
	 * @return the fname
	 */
	public String getFname() {
		return fname;
	}


	/**
	 * @param fname the fname to set
	 */
	public void setFname(String fname) {
		this.fname = fname;
	}


	/**
	 * @return the lname
	 */
	public String getLname() {
		return lname;
	}


	/**
	 * @param lname the lname to set
	 */
	public void setLname(String lname) {
		this.lname = lname;
	}

}
