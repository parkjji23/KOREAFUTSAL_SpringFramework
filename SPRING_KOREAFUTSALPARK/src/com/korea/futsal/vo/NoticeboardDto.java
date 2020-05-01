package com.korea.futsal.vo;

import java.sql.Date;

public class NoticeboardDto {
	int NO;
	String TITLE;
	Date DATE;
	String CONTENTS;
	int READCOUNT;
	String FILE;
	String ADMINNAME;
	String STATE;
	public int getNO() {
		return NO;
	}
	public void setNO(int nO) {
		NO = nO;
	}
	public String getTITLE() {
		return TITLE;
	}
	public void setTITLE(String tITLE) {
		TITLE = tITLE;
	}
	public Date getDATE() {
		return DATE;
	}
	public void setDATE(Date dATE) {
		DATE = dATE;
	}
	public String getCONTENTS() {
		return CONTENTS;
	}
	public void setCONTENTS(String cONTENTS) {
		CONTENTS = cONTENTS;
	}
	public int getREADCOUNT() {
		return READCOUNT;
	}
	public void setREADCOUNT(int rEADCOUNT) {
		READCOUNT = rEADCOUNT;
	}
	public String getFILE() {
		return FILE;
	}
	public void setFILE(String fILE) {
		FILE = fILE;
	}
	public String getADMINNAME() {
		return ADMINNAME;
	}
	public void setADMINNAME(String aDMINNAME) {
		ADMINNAME = aDMINNAME;
	}
	public String getSTATE() {
		return STATE;
	}
	public void setSTATE(String sTATE) {
		STATE = sTATE;
	}
	
	
}
