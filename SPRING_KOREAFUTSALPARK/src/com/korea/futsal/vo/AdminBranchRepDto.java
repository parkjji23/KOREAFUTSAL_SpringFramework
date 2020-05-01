package com.korea.futsal.vo;



import java.sql.Date;

public class AdminBranchRepDto {

	int BRANCH_REP_NO;
	String BRANCH_REP_CONTENTS;
	Date BRANCH_REP_DATE;
	int BRANCH_NO;
	String NAME;
	public int getBRANCH_REP_NO() {
		return BRANCH_REP_NO;
	}
	public void setBRANCH_REP_NO(int bRANCH_REP_NO) {
		BRANCH_REP_NO = bRANCH_REP_NO;
	}
	public String getBRANCH_REP_CONTENTS() {
		return BRANCH_REP_CONTENTS;
	}
	public void setBRANCH_REP_CONTENTS(String bRANCH_REP_CONTENTS) {
		BRANCH_REP_CONTENTS = bRANCH_REP_CONTENTS;
	}
	public Date getBRANCH_REP_DATE() {
		return BRANCH_REP_DATE;
	}
	public void setBRANCH_REP_DATE(Date bRANCH_REP_DATE) {
		BRANCH_REP_DATE = bRANCH_REP_DATE;
	}
	public int getBRANCH_NO() {
		return BRANCH_NO;
	}
	public void setBRANCH_NO(int bRANCH_NO) {
		BRANCH_NO = bRANCH_NO;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	
	
}
