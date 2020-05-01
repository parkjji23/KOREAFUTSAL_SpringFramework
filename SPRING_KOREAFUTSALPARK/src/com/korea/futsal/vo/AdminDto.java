package com.korea.futsal.vo;

public class AdminDto {
	
	String ADMIN_ID; //아이디
	String ADMIN_PASSWORD; //비밀번호
	String ADMIN_NAME; //사용자이름
	String ADMIN_NUMBER; //식별번호 (사번)
	String POSITION; //직급
	public String getADMIN_ID() {
		return ADMIN_ID;
	}
	public void setADMIN_ID(String aDMIN_ID) {
		ADMIN_ID = aDMIN_ID;
	}
	public String getADMIN_PASSWORD() {
		return ADMIN_PASSWORD;
	}
	public void setADMIN_PASSWORD(String aDMIN_PASSWORD) {
		ADMIN_PASSWORD = aDMIN_PASSWORD;
	}
	public String getADMIN_NAME() {
		return ADMIN_NAME;
	}
	public void setADMIN_NAME(String aDMIN_NAME) {
		ADMIN_NAME = aDMIN_NAME;
	}
	public String getADMIN_NUMBER() {
		return ADMIN_NUMBER;
	}
	public void setADMIN_NUMBER(String aDMIN_NUMBER) {
		ADMIN_NUMBER = aDMIN_NUMBER;
	}
	public String getPOSITION() {
		return POSITION;
	}
	public void setPOSITION(String pOSITION) {
		POSITION = pOSITION;
	}
	
	
}
