package com.korea.futsal.vo;

import java.sql.Date;

public class TeamDto {
	int TEAMCODE;
	String TEAMNAME;
	String TEAMLOGO;
	int TEAMRANKING;
	String HOMEUNIFORM;
	String AWAYUNIFORM;
	Date TEAMBIRTH;	
	String TEAMCLASS;
	int LEAGUERESULTCODE;
	String ID;
	String TEAMEMAIL;
	String TEAMTYPE;
	String BRANCHCODE;
	String WORD;
	public int getTEAMCODE() {
		return TEAMCODE;
	}
	public void setTEAMCODE(int tEAMCODE) {
		TEAMCODE = tEAMCODE;
	}
	public String getTEAMNAME() {
		return TEAMNAME;
	}
	public void setTEAMNAME(String tEAMNAME) {
		TEAMNAME = tEAMNAME;
	}
	public String getTEAMLOGO() {
		return TEAMLOGO;
	}
	public void setTEAMLOGO(String tEAMLOGO) {
		TEAMLOGO = tEAMLOGO;
	}
	public int getTEAMRANKING() {
		return TEAMRANKING;
	}
	public void setTEAMRANKING(int tEAMRANKING) {
		TEAMRANKING = tEAMRANKING;
	}
	public String getHOMEUNIFORM() {
		return HOMEUNIFORM;
	}
	public void setHOMEUNIFORM(String hOMEUNIFORM) {
		HOMEUNIFORM = hOMEUNIFORM;
	}
	public String getAWAYUNIFORM() {
		return AWAYUNIFORM;
	}
	public void setAWAYUNIFORM(String aWAYUNIFORM) {
		AWAYUNIFORM = aWAYUNIFORM;
	}
	public Date getTEAMBIRTH() {
		return TEAMBIRTH;
	}
	public void setTEAMBIRTH(Date tEAMBIRTH) {
		TEAMBIRTH = tEAMBIRTH;
	}
	public String getTEAMCLASS() {
		return TEAMCLASS;
	}
	public void setTEAMCLASS(String tEAMCLASS) {
		TEAMCLASS = tEAMCLASS;
	}
	public int getLEAGUERESULTCODE() {
		return LEAGUERESULTCODE;
	}
	public void setLEAGUERESULTCODE(int lEAGUERESULTCODE) {
		LEAGUERESULTCODE = lEAGUERESULTCODE;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	
	public String getTEAMEMAIL() {
		return TEAMEMAIL;
	}
	public void setTEAMEMAIL(String tEAMEMAIL) {
		TEAMEMAIL = tEAMEMAIL;
	}
	public String getTEAMTYPE() {
		return TEAMTYPE;
	}
	public void setTEAMTYPE(String tEAMTYPE) {
		TEAMTYPE = tEAMTYPE;
	}
	public String getBRANCHCODE() {
		return BRANCHCODE;
	}
	public void setBRANCHCODE(String bRANCHCODE) {
		BRANCHCODE = bRANCHCODE;
	}
	public String getWORD() {
		return WORD;
	}
	public void setWORD(String wORD) {
		WORD = wORD;
	}
	
}
