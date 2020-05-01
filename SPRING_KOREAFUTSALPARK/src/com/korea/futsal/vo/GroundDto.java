package com.korea.futsal.vo;

import java.sql.Date;

public class GroundDto {
	int GROUNDNO;
	String GROUNDNAME;
	String ALLPIC;
	String FIELD;
	String SIZE;
	String RULE;
	int WEEKDAYDAYTIMECHARGE;
	int WEEKDAYNIGHTCHARGE;
	int WEEKENDDAYTIMECHARGE;
	int WEEKENDNIGHTCHARGE;
	// FK//
	int BRANCHNO;
	public int getGROUNDNO() {
		return GROUNDNO;
	}
	public void setGROUNDNO(int gROUNDNO) {
		GROUNDNO = gROUNDNO;
	}
	public String getGROUNDNAME() {
		return GROUNDNAME;
	}
	public void setGROUNDNAME(String gROUNDNAME) {
		GROUNDNAME = gROUNDNAME;
	}
	public String getALLPIC() {
		return ALLPIC;
	}
	public void setALLPIC(String aLLPIC) {
		ALLPIC = aLLPIC;
	}
	public String getFIELD() {
		return FIELD;
	}
	public void setFIELD(String fIELD) {
		FIELD = fIELD;
	}
	public String getSIZE() {
		return SIZE;
	}
	public void setSIZE(String sIZE) {
		SIZE = sIZE;
	}
	public String getRULE() {
		return RULE;
	}
	public void setRULE(String rULE) {
		RULE = rULE;
	}
	public int getWEEKDAYDAYTIMECHARGE() {
		return WEEKDAYDAYTIMECHARGE;
	}
	public void setWEEKDAYDAYTIMECHARGE(int wEEKDAYDAYTIMECHARGE) {
		WEEKDAYDAYTIMECHARGE = wEEKDAYDAYTIMECHARGE;
	}
	public int getWEEKDAYNIGHTCHARGE() {
		return WEEKDAYNIGHTCHARGE;
	}
	public void setWEEKDAYNIGHTCHARGE(int wEEKDAYNIGHTCHARGE) {
		WEEKDAYNIGHTCHARGE = wEEKDAYNIGHTCHARGE;
	}
	public int getWEEKENDDAYTIMECHARGE() {
		return WEEKENDDAYTIMECHARGE;
	}
	public void setWEEKENDDAYTIMECHARGE(int wEEKENDDAYTIMECHARGE) {
		WEEKENDDAYTIMECHARGE = wEEKENDDAYTIMECHARGE;
	}
	public int getWEEKENDNIGHTCHARGE() {
		return WEEKENDNIGHTCHARGE;
	}
	public void setWEEKENDNIGHTCHARGE(int wEEKENDNIGHTCHARGE) {
		WEEKENDNIGHTCHARGE = wEEKENDNIGHTCHARGE;
	}
	public int getBRANCHNO() {
		return BRANCHNO;
	}
	public void setBRANCHNO(int bRANCHNO) {
		BRANCHNO = bRANCHNO;
	}
	
	
}
