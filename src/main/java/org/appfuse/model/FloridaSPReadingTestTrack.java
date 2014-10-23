package org.appfuse.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class FloridaSPReadingTestTrack implements Serializable,
		Comparable<FloridaSPReadingTestTrack> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -493959674053313919L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long uid;

	private String ID;
	private String SecondsElapsed;
	private String SLG_1_3;
	private String SLG_1_6;
	private String SLG_1_9;
	private String SLG_1_12;
	private String STG_1_3;
	private String STG_1_6;
	private String STG_1_9;
	private String STG_1_12;
	private String SLG_2_3;
	private String SLG_2_6;
	private String SLG_2_9;
	private String SLG_2_12;
	private String STG_2_3;
	private String STG_2_6;
	private String STG_2_9;
	private String STG_2_12;
	private String SLG_3_3;
	private String SLG_3_6;
	private String SLG_3_9;
	private String SLG_3_12;
	private String STG_3_3;
	private String STG_3_6;
	private String STG_3_9;
	private String STG_3_12;
	private String PG_Asph_1;
	private String PG2_Asph_2;
	private String PG_Base_1;
	private String PG_Base_2;
	private String EGT1;
	private String EGL1;
	private String EGL2;
	private String EGT2;
	private String EGT3;
	private String EGL3;

	public String getEGT2() {
		return EGT2;
	}

	public void setEGT2(String eGT2) {
		EGT2 = eGT2;
	}

	public String getEGT3() {
		return EGT3;
	}

	public void setEGT3(String eGT3) {
		EGT3 = eGT3;
	}

	public String getEGL3() {
		return EGL3;
	}

	public void setEGL3(String eGL3) {
		EGL3 = eGL3;
	}

	public String getEGL2() {
		return EGL2;
	}

	public void setEGL2(String eGL2) {
		EGL2 = eGL2;
	}

	public String getEGL1() {
		return EGL1;
	}

	public void setEGL1(String eGL1) {
		EGL1 = eGL1;
	}

	public String getEGT1() {
		return EGT1;
	}

	public void setEGT1(String eGT1) {
		EGT1 = eGT1;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getSecondsElapsed() {
		return SecondsElapsed;
	}

	public void setSecondsElapsed(String secondsElapsed) {
		SecondsElapsed = secondsElapsed;
	}

	public String getSLG_1_3() {
		return SLG_1_3;
	}

	public void setSLG_1_3(String sLG_1_3) {
		SLG_1_3 = sLG_1_3;
	}

	public String getSLG_1_6() {
		return SLG_1_6;
	}

	public void setSLG_1_6(String sLG_1_6) {
		SLG_1_6 = sLG_1_6;
	}

	public String getSLG_1_9() {
		return SLG_1_9;
	}

	public void setSLG_1_9(String sLG_1_9) {
		SLG_1_9 = sLG_1_9;
	}

	public String getSLG_1_12() {
		return SLG_1_12;
	}

	public void setSLG_1_12(String sLG_1_12) {
		SLG_1_12 = sLG_1_12;
	}

	public String getSTG_1_3() {
		return STG_1_3;
	}

	public void setSTG_1_3(String sTG_1_3) {
		STG_1_3 = sTG_1_3;
	}

	public String getSTG_1_6() {
		return STG_1_6;
	}

	public void setSTG_1_6(String sTG_1_6) {
		STG_1_6 = sTG_1_6;
	}

	public String getSTG_1_9() {
		return STG_1_9;
	}

	public void setSTG_1_9(String sTG_1_9) {
		STG_1_9 = sTG_1_9;
	}

	public String getSTG_1_12() {
		return STG_1_12;
	}

	public void setSTG_1_12(String sTG_1_12) {
		STG_1_12 = sTG_1_12;
	}

	public String getSLG_2_3() {
		return SLG_2_3;
	}

	public void setSLG_2_3(String sLG_2_3) {
		SLG_2_3 = sLG_2_3;
	}

	public String getSLG_2_6() {
		return SLG_2_6;
	}

	public void setSLG_2_6(String sLG_2_6) {
		SLG_2_6 = sLG_2_6;
	}

	public String getSLG_2_9() {
		return SLG_2_9;
	}

	public void setSLG_2_9(String sLG_2_9) {
		SLG_2_9 = sLG_2_9;
	}

	public String getSLG_2_12() {
		return SLG_2_12;
	}

	public void setSLG_2_12(String sLG_2_12) {
		SLG_2_12 = sLG_2_12;
	}

	public String getSTG_2_3() {
		return STG_2_3;
	}

	public void setSTG_2_3(String sTG_2_3) {
		STG_2_3 = sTG_2_3;
	}

	public String getSTG_2_6() {
		return STG_2_6;
	}

	public void setSTG_2_6(String sTG_2_6) {
		STG_2_6 = sTG_2_6;
	}

	public String getSTG_2_9() {
		return STG_2_9;
	}

	public void setSTG_2_9(String sTG_2_9) {
		STG_2_9 = sTG_2_9;
	}

	public String getSTG_2_12() {
		return STG_2_12;
	}

	public void setSTG_2_12(String sTG_2_12) {
		STG_2_12 = sTG_2_12;
	}

	public String getSLG_3_3() {
		return SLG_3_3;
	}

	public void setSLG_3_3(String sLG_3_3) {
		SLG_3_3 = sLG_3_3;
	}

	public String getSLG_3_6() {
		return SLG_3_6;
	}

	public void setSLG_3_6(String sLG_3_6) {
		SLG_3_6 = sLG_3_6;
	}

	public String getSLG_3_9() {
		return SLG_3_9;
	}

	public void setSLG_3_9(String sLG_3_9) {
		SLG_3_9 = sLG_3_9;
	}

	public String getSLG_3_12() {
		return SLG_3_12;
	}

	public void setSLG_3_12(String sLG_3_12) {
		SLG_3_12 = sLG_3_12;
	}

	public String getSTG_3_3() {
		return STG_3_3;
	}

	public void setSTG_3_3(String sTG_3_3) {
		STG_3_3 = sTG_3_3;
	}

	public String getSTG_3_6() {
		return STG_3_6;
	}

	public void setSTG_3_6(String sTG_3_6) {
		STG_3_6 = sTG_3_6;
	}

	public String getSTG_3_9() {
		return STG_3_9;
	}

	public void setSTG_3_9(String sTG_3_9) {
		STG_3_9 = sTG_3_9;
	}

	public String getSTG_3_12() {
		return STG_3_12;
	}

	public void setSTG_3_12(String sTG_3_12) {
		STG_3_12 = sTG_3_12;
	}

	public String getPG_Asph_1() {
		return PG_Asph_1;
	}

	public void setPG_Asph_1(String pG_Asph_1) {
		PG_Asph_1 = pG_Asph_1;
	}

	public String getPG2_Asph_2() {
		return PG2_Asph_2;
	}

	public void setPG2_Asph_2(String pG2_Asph_2) {
		PG2_Asph_2 = pG2_Asph_2;
	}

	public String getPG_Base_1() {
		return PG_Base_1;
	}

	public void setPG_Base_1(String pG_Base_1) {
		PG_Base_1 = pG_Base_1;
	}

	public String getPG_Base_2() {
		return PG_Base_2;
	}

	public void setPG_Base_2(String pG_Base_2) {
		PG_Base_2 = pG_Base_2;
	}

	public int compareTo(FloridaSPReadingTestTrack o) {
		// TODO Auto-generated method stub
		return this.SecondsElapsed.compareTo(o.SecondsElapsed);
	}

}
