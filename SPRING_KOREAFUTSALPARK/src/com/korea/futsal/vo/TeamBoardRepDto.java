package com.korea.futsal.vo;

import java.sql.Date;

public class TeamBoardRepDto {
	int TB_REP_NO;
	String TB_REP_CONTENTS;
	Date TB_REP_DATE;
	int T_B_NO;
	String ID;
	public int getTB_REP_NO() {
		return TB_REP_NO;
	}
	public void setTB_REP_NO(int tB_REP_NO) {
		TB_REP_NO = tB_REP_NO;
	}
	public String getTB_REP_CONTENTS() {
		return TB_REP_CONTENTS;
	}
	public void setTB_REP_CONTENTS(String tB_REP_CONTENTS) {
		TB_REP_CONTENTS = tB_REP_CONTENTS;
	}
	public Date getTB_REP_DATE() {
		return TB_REP_DATE;
	}
	public void setTB_REP_DATE(Date tB_REP_DATE) {
		TB_REP_DATE = tB_REP_DATE;
	}
	public int getT_B_NO() {
		return T_B_NO;
	}
	public void setT_B_NO(int t_B_NO) {
		T_B_NO = t_B_NO;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	
}
