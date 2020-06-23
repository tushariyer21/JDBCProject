package com.project.structure;

public class DependentStructure {
	private String essn;
	private String dname;
	private String sex;
	private String bdate;
	private String relationship;

	public DependentStructure(String essn, String sex, String dname, String bdate, String relationship) {
		// TODO Auto-generated constructor stub
		super();
		this.essn = essn;
		this.dname = dname;
		this.sex = sex;
		this.bdate = bdate;
		this.relationship = relationship;
				
	}

	public String getEssn() {
		return essn;
	}

	public void setEssn(String essn) {
		this.essn = essn;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getBdate() {
		return bdate;
	}

	public void setBdate(String bdate) {
		this.bdate = bdate;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

}
