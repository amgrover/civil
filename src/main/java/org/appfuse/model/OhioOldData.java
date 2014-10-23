package org.appfuse.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table
@NamedQueries({ @NamedQuery(name = "findOhioOld", query = "select r from OhioOldData r where r.filter1 = :filter1 and r.filter2 = :filter2 ") })
public class OhioOldData implements Serializable, Comparable<OhioOldData> {
	private static final long serialVersionUID = -2547367884594738007L;
	private Long id;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private String filter1;
	private String filter2;

	public String getFilter2() {
		return filter2;
	}

	public void setFilter2(String filter2) {
		this.filter2 = filter2;
	}

	public String getFilter1() {
		return filter1;
	}

	public void setFilter1(String filter1) {
		this.filter1 = filter1;
	}

	private String Time;
	private String Dyn1;
	private String Dyn2;
	private String Dyn3;
	private String Dyn4;
	private String Dyn5;
	private String Dyn6;
	private String Dyn7;
	private String Dyn8;
	private String Dyn9;
	private String Dyn10;
	private String Dyn11;
	private String Dyn12;
	private String Dyn13;
	private String Dyn14;
	private String Dyn15;

	private String S_A1_A2_A3;
	private String S_A4_A6_A5;
	private String S_A7_A8_A9;
	private String S_A10_A11_A12;
	private String S_B1_B2_B3;
	private String S_B4_B5_B6;
	private String S_B7_B8_B9;
	private String S_B10_B11_B12;

	public String getS_A1_A2_A3() {
		return S_A1_A2_A3;
	}

	public void setS_A1_A2_A3(String s_A1_A2_A3) {
		S_A1_A2_A3 = s_A1_A2_A3;
	}

	public String getS_A4_A6_A5() {
		return S_A4_A6_A5;
	}

	public void setS_A4_A6_A5(String s_A4_A6_A5) {
		S_A4_A6_A5 = s_A4_A6_A5;
	}

	public String getS_A7_A8_A9() {
		return S_A7_A8_A9;
	}

	public void setS_A7_A8_A9(String s_A7_A8_A9) {
		S_A7_A8_A9 = s_A7_A8_A9;
	}

	public String getS_A10_A11_A12() {
		return S_A10_A11_A12;
	}

	public void setS_A10_A11_A12(String s_A10_A11_A12) {
		S_A10_A11_A12 = s_A10_A11_A12;
	}

	public String getS_B1_B2_B3() {
		return S_B1_B2_B3;
	}

	public void setS_B1_B2_B3(String s_B1_B2_B3) {
		S_B1_B2_B3 = s_B1_B2_B3;
	}

	public String getS_B4_B5_B6() {
		return S_B4_B5_B6;
	}

	public void setS_B4_B5_B6(String s_B4_B5_B6) {
		S_B4_B5_B6 = s_B4_B5_B6;
	}

	public String getS_B7_B8_B9() {
		return S_B7_B8_B9;
	}

	public void setS_B7_B8_B9(String s_B7_B8_B9) {
		S_B7_B8_B9 = s_B7_B8_B9;
	}

	public String getS_B10_B11_B12() {
		return S_B10_B11_B12;
	}

	public void setS_B10_B11_B12(String s_B10_B11_B12) {
		S_B10_B11_B12 = s_B10_B11_B12;
	}

	public String getDyn15() {
		return Dyn15;
	}

	public void setDyn15(String dyn15) {
		Dyn15 = dyn15;
	}

	public String getDyn14() {
		return Dyn14;
	}

	public void setDyn14(String dyn14) {
		Dyn14 = dyn14;
	}

	public String getDyn13() {
		return Dyn13;
	}

	public void setDyn13(String dyn13) {
		Dyn13 = dyn13;
	}

	private String WF1;
	private String WF2;
	private String WF3;
	private String WF4;
	private String WF5;
	private String WF6;
	private String WF7;
	private String WF8;
	private String WF9;
	private String WF10;
	private String WF11;
	private String WF12;
	private String WF13;
	private String WF14;
	private String WF15;
	private String WF16;
	private String WF17;
	private String WF18;
	private String WF19;
	private String WF20;
	private String WF21;
	private String WF22;
	private String WF23;
	private String WF24;

	public String getTime() {
		return Time;
	}

	public void setTime(String time) {
		Time = time;
	}

	public String getDyn1() {
		return Dyn1;
	}

	public void setDyn1(String dyn1) {
		Dyn1 = dyn1;
	}

	public String getDyn2() {
		return Dyn2;
	}

	public void setDyn2(String dyn2) {
		Dyn2 = dyn2;
	}

	public String getDyn3() {
		return Dyn3;
	}

	public void setDyn3(String dyn3) {
		Dyn3 = dyn3;
	}

	public String getDyn4() {
		return Dyn4;
	}

	public void setDyn4(String dyn4) {
		Dyn4 = dyn4;
	}

	public String getDyn5() {
		return Dyn5;
	}

	public void setDyn5(String dyn5) {
		Dyn5 = dyn5;
	}

	public String getDyn6() {
		return Dyn6;
	}

	public void setDyn6(String dyn6) {
		Dyn6 = dyn6;
	}

	public String getDyn7() {
		return Dyn7;
	}

	public void setDyn7(String dyn7) {
		Dyn7 = dyn7;
	}

	public String getDyn8() {
		return Dyn8;
	}

	public void setDyn8(String dyn8) {
		Dyn8 = dyn8;
	}

	public String getDyn9() {
		return Dyn9;
	}

	public void setDyn9(String dyn9) {
		Dyn9 = dyn9;
	}

	public String getDyn10() {
		return Dyn10;
	}

	public void setDyn10(String dyn10) {
		Dyn10 = dyn10;
	}

	public String getDyn11() {
		return Dyn11;
	}

	public void setDyn11(String dyn11) {
		Dyn11 = dyn11;
	}

	public String getDyn12() {
		return Dyn12;
	}

	public void setDyn12(String dyn12) {
		Dyn12 = dyn12;
	}

	public String getWF1() {
		return WF1;
	}

	public void setWF1(String wF1) {
		WF1 = wF1;
	}

	public String getWF2() {
		return WF2;
	}

	public void setWF2(String wF2) {
		WF2 = wF2;
	}

	public String getWF3() {
		return WF3;
	}

	public void setWF3(String wF3) {
		WF3 = wF3;
	}

	public String getWF4() {
		return WF4;
	}

	public void setWF4(String wF4) {
		WF4 = wF4;
	}

	public String getWF5() {
		return WF5;
	}

	public void setWF5(String wF5) {
		WF5 = wF5;
	}

	public String getWF6() {
		return WF6;
	}

	public void setWF6(String wF6) {
		WF6 = wF6;
	}

	public String getWF7() {
		return WF7;
	}

	public void setWF7(String wF7) {
		WF7 = wF7;
	}

	public String getWF8() {
		return WF8;
	}

	public void setWF8(String wF8) {
		WF8 = wF8;
	}

	public String getWF9() {
		return WF9;
	}

	public void setWF9(String wF9) {
		WF9 = wF9;
	}

	public String getWF10() {
		return WF10;
	}

	public void setWF10(String wF10) {
		WF10 = wF10;
	}

	public String getWF11() {
		return WF11;
	}

	public void setWF11(String wF11) {
		WF11 = wF11;
	}

	public String getWF12() {
		return WF12;
	}

	public void setWF12(String wF12) {
		WF12 = wF12;
	}

	public String getWF13() {
		return WF13;
	}

	public void setWF13(String wF13) {
		WF13 = wF13;
	}

	public String getWF14() {
		return WF14;
	}

	public void setWF14(String wF14) {
		WF14 = wF14;
	}

	public String getWF15() {
		return WF15;
	}

	public void setWF15(String wF15) {
		WF15 = wF15;
	}

	public String getWF16() {
		return WF16;
	}

	public void setWF16(String wF16) {
		WF16 = wF16;
	}

	public String getWF17() {
		return WF17;
	}

	public void setWF17(String wF17) {
		WF17 = wF17;
	}

	public String getWF18() {
		return WF18;
	}

	public void setWF18(String wF18) {
		WF18 = wF18;
	}

	public String getWF19() {
		return WF19;
	}

	public void setWF19(String wF19) {
		WF19 = wF19;
	}

	public String getWF20() {
		return WF20;
	}

	public void setWF20(String wF20) {
		WF20 = wF20;
	}

	public String getWF21() {
		return WF21;
	}

	public void setWF21(String wF21) {
		WF21 = wF21;
	}

	public String getWF22() {
		return WF22;
	}

	public void setWF22(String wF22) {
		WF22 = wF22;
	}

	public String getWF23() {
		return WF23;
	}

	public void setWF23(String wF23) {
		WF23 = wF23;
	}

	public String getWF24() {
		return WF24;
	}

	public void setWF24(String wF24) {
		WF24 = wF24;
	}

	public String getS_1_2_3() {
		return S_1_2_3;
	}

	public void setS_1_2_3(String s_1_2_3) {
		S_1_2_3 = s_1_2_3;
	}

	public String getS_4_5_6() {
		return S_4_5_6;
	}

	public void setS_4_5_6(String s_4_5_6) {
		S_4_5_6 = s_4_5_6;
	}

	public String getS_7_8_9() {
		return S_7_8_9;
	}

	public void setS_7_8_9(String s_7_8_9) {
		S_7_8_9 = s_7_8_9;
	}

	public String getS_10_11_12() {
		return S_10_11_12;
	}

	public void setS_10_11_12(String s_10_11_12) {
		S_10_11_12 = s_10_11_12;
	}

	public String getS_13_14_15() {
		return S_13_14_15;
	}

	public void setS_13_14_15(String s_13_14_15) {
		S_13_14_15 = s_13_14_15;
	}

	public String getS_16_17_18() {
		return S_16_17_18;
	}

	public void setS_16_17_18(String s_16_17_18) {
		S_16_17_18 = s_16_17_18;
	}

	public String getS_19_20_21() {
		return S_19_20_21;
	}

	public void setS_19_20_21(String s_19_20_21) {
		S_19_20_21 = s_19_20_21;
	}

	public String getS_22_23_24() {
		return S_22_23_24;
	}

	public void setS_22_23_24(String s_22_23_24) {
		S_22_23_24 = s_22_23_24;
	}

	private String S_1_2_3;
	private String S_4_5_6;
	private String S_7_8_9;
	private String S_10_11_12;
	private String S_13_14_15;
	private String S_16_17_18;
	private String S_19_20_21;
	private String S_22_23_24;
	private String CD1;
	private String CD2;
	private String CD3;
	private String CD4;
	private String CD5;
	private String CD6;
	private String CD7;
	private String CD8;
	private String CD9;
	private String CD10;
	private String CD11;
	private String CD12;
	private String CD13;
	private String CD14;
	private String CD15;
	private String CD16;

	public String getCD1() {
		return CD1;
	}

	public void setCD1(String cD1) {
		CD1 = cD1;
	}

	public String getCD2() {
		return CD2;
	}

	public void setCD2(String cD2) {
		CD2 = cD2;
	}

	public String getCD3() {
		return CD3;
	}

	public void setCD3(String cD3) {
		CD3 = cD3;
	}

	public String getCD4() {
		return CD4;
	}

	public void setCD4(String cD4) {
		CD4 = cD4;
	}

	public String getCD5() {
		return CD5;
	}

	public void setCD5(String cD5) {
		CD5 = cD5;
	}

	public String getCD6() {
		return CD6;
	}

	public void setCD6(String cD6) {
		CD6 = cD6;
	}

	public String getCD7() {
		return CD7;
	}

	public void setCD7(String cD7) {
		CD7 = cD7;
	}

	public String getCD8() {
		return CD8;
	}

	public void setCD8(String cD8) {
		CD8 = cD8;
	}

	public String getCD9() {
		return CD9;
	}

	public void setCD9(String cD9) {
		CD9 = cD9;
	}

	public String getCD10() {
		return CD10;
	}

	public void setCD10(String cD10) {
		CD10 = cD10;
	}

	public String getCD11() {
		return CD11;
	}

	public void setCD11(String cD11) {
		CD11 = cD11;
	}

	public String getCD12() {
		return CD12;
	}

	public void setCD12(String cD12) {
		CD12 = cD12;
	}

	public String getCD13() {
		return CD13;
	}

	public void setCD13(String cD13) {
		CD13 = cD13;
	}

	public String getCD14() {
		return CD14;
	}

	public void setCD14(String cD14) {
		CD14 = cD14;
	}

	public String getCD15() {
		return CD15;
	}

	public void setCD15(String cD15) {
		CD15 = cD15;
	}

	public String getCD16() {
		return CD16;
	}

	public void setCD16(String cD16) {
		CD16 = cD16;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int compareTo(OhioOldData o) {
		return this.getTime().compareTo(o.getTime());
	}

}
