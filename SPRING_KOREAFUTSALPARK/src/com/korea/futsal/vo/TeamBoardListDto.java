package com.korea.futsal.vo;

import java.sql.Date;

public class TeamBoardListDto {
	int NO;
	String CONTENTS;
	String SUBJECT;
	Date DATE;
	int READCOUNT;
	String ID;
	int TEAMCODE;
	public int getNO() {
		return NO;
	}
	public void setNO(int nO) {
		NO = nO;
	}
	public String getCONTENTS() {
		return CONTENTS;
	}
	public void setCONTENTS(String cONTENTS) {
		CONTENTS = cONTENTS;
	}
	public String getSUBJECT() {
		return SUBJECT;
	}
	public void setSUBJECT(String sUBJECT) {
		SUBJECT = sUBJECT;
	}
	public Date getDATE() {
		return DATE;
	}
	public void setDATE(Date dATE) {
		DATE = dATE;
	}
	public int getREADCOUNT() {
		return READCOUNT;
	}
	public void setREADCOUNT(int rEADCOUNT) {
		READCOUNT = rEADCOUNT;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public int getTEAMCODE() {
		return TEAMCODE;
	}
	public void setTEAMCODE(int tEAMCODE) {
		TEAMCODE = tEAMCODE;
	}
	
	
}
