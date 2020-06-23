package com.project.structure;

public class Department {
	
	private int id;
	private String dname;
	

	public Department(int id, String dname) {
		super();
		this.id = id;
		this.dname = dname;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getDname() {
		return dname;
	}


	public void setDname(String dname) {
		this.dname = dname;
	}

}
