package br.gov.cmb.cfad.model;

public class Person {
	
	private String uid;
    private String fullName;
    private String lastName;
    private String description;
	public String getUid() {
		return uid;
	}
	public String getFullName() {
		return fullName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getDescription() {
		return description;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setDescription(String description) {
		this.description = description;
	}   

}
