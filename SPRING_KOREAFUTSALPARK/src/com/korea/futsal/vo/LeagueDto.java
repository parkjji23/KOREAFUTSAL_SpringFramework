package com.korea.futsal.vo;

import java.sql.Date;

public class LeagueDto {
	int LEAGUE_CODE;
	String LEAGUE_NAME;
	Date LEAGUE_DATE;
	int BRANCH_NO;
	int LEAGUE_POINT;
	public int getLEAGUE_CODE() {
		return LEAGUE_CODE;
	}
	public void setLEAGUE_CODE(int lEAGUE_CODE) {
		LEAGUE_CODE = lEAGUE_CODE;
	}
	public String getLEAGUE_NAME() {
		return LEAGUE_NAME;
	}
	public void setLEAGUE_NAME(String lEAGUE_NAME) {
		LEAGUE_NAME = lEAGUE_NAME;
	}
	public Date getLEAGUE_DATE() {
		return LEAGUE_DATE;
	}
	public void setLEAGUE_DATE(Date lEAGUE_DATE) {
		LEAGUE_DATE = lEAGUE_DATE;
	}
	public int getBRANCH_NO() {
		return BRANCH_NO;
	}
	public void setBRANCH_NO(int bRANCH_NO) {
		BRANCH_NO = bRANCH_NO;
	}
	public int getLEAGUE_POINT() {
		return LEAGUE_POINT;
	}
	public void setLEAGUE_POINT(int lEAGUE_POINT) {
		LEAGUE_POINT = lEAGUE_POINT;
	}
	
	
	
}
