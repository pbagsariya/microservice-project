package com.wipro.accountservice.model;

import java.io.Serializable;



public class Account implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;	
	private String type;
	private String number;	
	private String holderName;
	private Long acBal;
	
	public Long getId() {
		return id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getHolderName() {
		return holderName;
	}
	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}
	public Long getAcBal() {
		return acBal;
	}
	public void setAcBal(Long acBal) {
		this.acBal = acBal;
	}
	

}
