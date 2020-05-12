package com.wipro.schoolservice.model;

public class School {
	private Long id;
	private String name;
	private String mediume;
	private String location;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMediume() {
		return mediume;
	}
	public void setMediume(String mediume) {
		this.mediume = mediume;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

}
