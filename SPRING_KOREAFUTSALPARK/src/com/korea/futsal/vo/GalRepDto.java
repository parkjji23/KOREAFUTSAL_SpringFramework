package com.korea.futsal.vo;

import java.sql.Date;

public class GalRepDto {
	int G_REP_NO;
	String G_REP_CONTENTS;
	Date G_REP_DATE;
	int G_B_NO;
	String ID;
	public int getG_REP_NO() {
		return G_REP_NO;
	}
	public void setG_REP_NO(int g_REP_NO) {
		G_REP_NO = g_REP_NO;
	}
	public String getG_REP_CONTENTS() {
		return G_REP_CONTENTS;
	}
	public void setG_REP_CONTENTS(String g_REP_CONTENTS) {
		G_REP_CONTENTS = g_REP_CONTENTS;
	}
	public Date getG_REP_DATE() {
		return G_REP_DATE;
	}
	public void setG_REP_DATE(Date g_REP_DATE) {
		G_REP_DATE = g_REP_DATE;
	}
	public int getG_B_NO() {
		return G_B_NO;
	}
	public void setG_B_NO(int g_B_NO) {
		G_B_NO = g_B_NO;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}

	
}
