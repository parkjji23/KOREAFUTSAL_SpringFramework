package com.korea.futsal.vo;

import java.sql.Date;

public class ComResInfoDto {
	String BRANCH_NAME;
	String GROUND_NAME;
	int BRANCH_NO;
	int GROUND_NO;
	String RES_TIME;
	Date RES_DATE;
	int RADIOCOUNT;
	int FULLDATE; //ground_size
	public String getBRANCH_NAME() {
		return BRANCH_NAME;
	}
	public void setBRANCH_NAME(String bRANCH_NAME) {
		BRANCH_NAME = bRANCH_NAME;
	}
	public String getGROUND_NAME() {
		return GROUND_NAME;
	}
	public void setGROUND_NAME(String gROUND_NAME) {
		GROUND_NAME = gROUND_NAME;
	}
	public int getBRANCH_NO() {
		return BRANCH_NO;
	}
	public void setBRANCH_NO(int bRANCH_NO) {
		BRANCH_NO = bRANCH_NO;
	}
	public int getGROUND_NO() {
		return GROUND_NO;
	}
	public void setGROUND_NO(int gROUND_NO) {
		GROUND_NO = gROUND_NO;
	}
	public String getRES_TIME() {
		return RES_TIME;
	}
	public void setRES_TIME(String rES_TIME) {
		RES_TIME = rES_TIME;
	}
	public Date getRES_DATE() {
		return RES_DATE;
	}
	public void setRES_DATE(Date rES_DATE) {
		RES_DATE = rES_DATE;
	}
	public int getRADIOCOUNT() {
		return RADIOCOUNT;
	}
	public void setRADIOCOUNT(int rADIOCOUNT) {
		RADIOCOUNT = rADIOCOUNT;
	}
	public int getFULLDATE() {
		return FULLDATE;
	}
	public void setFULLDATE(int fULLDATE) {
		FULLDATE = fULLDATE;
	}
	
	
}
