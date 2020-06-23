package com.project.structure;

public class ProjectStructure {
	private String pname;
	private int pnumber;
	private String plocation;
	private int dnum;
	private int hours;
	private String dname;
	

	public ProjectStructure(int dnum, String plocation, String pname, int pnumber, int hours, String dname) {
		// TODO Auto-generated constructor stub
		super();
		this.setDnum(dnum);
		this.setHours(hours);
		this.setPlocation(plocation);
		this.setPnumber(pnumber);
		this.setPname(pname);
		this.setDname(dname);
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
	 * @return the hours
	 */
	public int getHours() {
		return hours;
	}


	/**
	 * @param hours the hours to set
	 */
	public void setHours(int hours) {
		this.hours = hours;
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

}
