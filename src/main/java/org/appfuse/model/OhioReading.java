package org.appfuse.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class OhioReading implements Serializable, Comparable<OhioReading> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8373600109711773798L;
	private Long id;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private Double Time;
	private Double KM_001;
	private Double KM_002;
	private Double KM_003;
	private Double KM_005;
	private Double KM_007;
	private Double KM_008;
	private Double KM_010;
	private Double KM_011;
	private Double KM_012;
	private Double KM_013;
	private Double PM_001;
	private Double PM_002;
	private Double PM_003;
	private Double PM_004;
	private Double PM_005;
	private Double PM_006;
	private Double LV_001;
	private Double LV_002;
	private Double LV_003;
	private Double LV_004;
	private Double PC_001;
	private Double PC_002;
	private Double LC_001;
	private Double LC_002;
	private Double WFLM_001;
	private Double WFLM_002;
	private Double WFLM_003;
	private Double WFLM_004;
	private Double WFLM_005;
	private Double WFLM_006;
	private Double WFLM_007;
	private Double WFLM_008;
	private Double WFLM_009;
	private Double WFLM_010;
	private Double WFLM_011;
	private Double WFLM_012;
	private Double WFLM_013;
	private Double WFLM_014;
	private Double WFLM_015;
	private Double WFLM_016;
	private Double WFLM_017;
	private Double WFLM_018;
	private Double WFLM_019;
	private Double WFLM_020;
	private Double WFLM_021;
	private Double WFLM_022;
	private Double WFLM_023;
	private Double WFLM_024;
	private Double WFLM_025;
	private Double WFLM_026;
	private Double WFLM_027;
	private Double WFLM_028;
	private Double WFLM_029;
	private Double WFLM_030;
	private Double WFLM_031;
	private Double WFLM_032;
	private Double WFLM_033;
	private Double WFLM_034;
	private Double WFLM_035;
	private Double WFLM_036;
	private Double WFLM_037;
	private Double WFLM_038;
	private Double WFLM_039;
	private Double WFLM_040;
	private Double WFLM_041;
	private Double WFLM_042;

	public Double getTime() {
		return Time;
	}

	public void setTime(Double time) {
		this.Time = time;
	}

	public Double getKM_001() {
		return KM_001;
	}

	public void setKM_001(Double kM_001) {
		KM_001 = kM_001;
	}

	public Double getKM_002() {
		return KM_002;
	}

	public void setKM_002(Double kM_002) {
		KM_002 = kM_002;
	}

	public Double getKM_003() {
		return KM_003;
	}

	public void setKM_003(Double kM_003) {
		KM_003 = kM_003;
	}

	public Double getKM_005() {
		return KM_005;
	}

	public void setKM_005(Double kM_005) {
		KM_005 = kM_005;
	}

	public Double getKM_007() {
		return KM_007;
	}

	public void setKM_007(Double kM_007) {
		KM_007 = kM_007;
	}

	public Double getKM_008() {
		return KM_008;
	}

	public void setKM_008(Double kM_008) {
		KM_008 = kM_008;
	}

	public Double getKM_010() {
		return KM_010;
	}

	public void setKM_010(Double kM_010) {
		KM_010 = kM_010;
	}

	public Double getKM_011() {
		return KM_011;
	}

	public void setKM_011(Double kM_011) {
		KM_011 = kM_011;
	}

	public Double getKM_012() {
		return KM_012;
	}

	public void setKM_012(Double kM_012) {
		KM_012 = kM_012;
	}

	public Double getKM_013() {
		return KM_013;
	}

	public void setKM_013(Double kM_013) {
		KM_013 = kM_013;
	}

	public Double getPM_002() {
		return PM_002;
	}

	public Double getPM_001() {
		return PM_001;
	}

	public void setPM_001(Double pM_001) {
		PM_001 = pM_001;
	}

	public void setPM_002(Double pM_002) {
		PM_002 = pM_002;
	}

	public Double getPM_003() {
		return PM_003;
	}

	public void setPM_003(Double pM_003) {
		PM_003 = pM_003;
	}

	public Double getPM_004() {
		return PM_004;
	}

	public void setPM_004(Double pM_004) {
		PM_004 = pM_004;
	}

	public Double getPM_005() {
		return PM_005;
	}

	public void setPM_005(Double pM_005) {
		PM_005 = pM_005;
	}

	public Double getPM_006() {
		return PM_006;
	}

	public void setPM_006(Double pM_006) {
		PM_006 = pM_006;
	}

	public Double getLV_001() {
		return LV_001;
	}

	public void setLV_001(Double lV_001) {
		LV_001 = lV_001;
	}

	public Double getLV_002() {
		return LV_002;
	}

	public void setLV_002(Double lV_002) {
		LV_002 = lV_002;
	}

	public Double getLV_003() {
		return LV_003;
	}

	public void setLV_003(Double lV_003) {
		LV_003 = lV_003;
	}

	public Double getLV_004() {
		return LV_004;
	}

	public void setLV_004(Double lV_004) {
		LV_004 = lV_004;
	}

	public Double getPC_001() {
		return PC_001;
	}

	public void setPC_001(Double pC_001) {
		PC_001 = pC_001;
	}

	public Double getPC_002() {
		return PC_002;
	}

	public void setPC_002(Double pC_002) {
		PC_002 = pC_002;
	}

	public Double getLC_001() {
		return LC_001;
	}

	public void setLC_001(Double lC_001) {
		LC_001 = lC_001;
	}

	public Double getLC_002() {
		return LC_002;
	}

	public void setLC_002(Double lC_002) {
		LC_002 = lC_002;
	}

	public Double getWFLM_001() {
		return WFLM_001;
	}

	public void setWFLM_001(Double wFLM_001) {
		WFLM_001 = wFLM_001;
	}

	public Double getWFLM_002() {
		return WFLM_002;
	}

	public void setWFLM_002(Double wFLM_002) {
		WFLM_002 = wFLM_002;
	}

	public Double getWFLM_003() {
		return WFLM_003;
	}

	public void setWFLM_003(Double wFLM_003) {
		WFLM_003 = wFLM_003;
	}

	public Double getWFLM_004() {
		return WFLM_004;
	}

	public void setWFLM_004(Double wFLM_004) {
		WFLM_004 = wFLM_004;
	}

	public Double getWFLM_005() {
		return WFLM_005;
	}

	public void setWFLM_005(Double wFLM_005) {
		WFLM_005 = wFLM_005;
	}

	public Double getWFLM_006() {
		return WFLM_006;
	}

	public void setWFLM_006(Double wFLM_006) {
		WFLM_006 = wFLM_006;
	}

	public Double getWFLM_007() {
		return WFLM_007;
	}

	public void setWFLM_007(Double wFLM_007) {
		WFLM_007 = wFLM_007;
	}

	public Double getWFLM_008() {
		return WFLM_008;
	}

	public void setWFLM_008(Double wFLM_008) {
		WFLM_008 = wFLM_008;
	}

	public Double getWFLM_009() {
		return WFLM_009;
	}

	public void setWFLM_009(Double wFLM_009) {
		WFLM_009 = wFLM_009;
	}

	public Double getWFLM_010() {
		return WFLM_010;
	}

	public void setWFLM_010(Double wFLM_010) {
		WFLM_010 = wFLM_010;
	}

	public Double getWFLM_011() {
		return WFLM_011;
	}

	public void setWFLM_011(Double wFLM_011) {
		WFLM_011 = wFLM_011;
	}

	public Double getWFLM_012() {
		return WFLM_012;
	}

	public void setWFLM_012(Double wFLM_012) {
		WFLM_012 = wFLM_012;
	}

	public Double getWFLM_013() {
		return WFLM_013;
	}

	public void setWFLM_013(Double wFLM_013) {
		WFLM_013 = wFLM_013;
	}

	public Double getWFLM_014() {
		return WFLM_014;
	}

	public void setWFLM_014(Double wFLM_014) {
		WFLM_014 = wFLM_014;
	}

	public Double getWFLM_015() {
		return WFLM_015;
	}

	public void setWFLM_015(Double wFLM_015) {
		WFLM_015 = wFLM_015;
	}

	public Double getWFLM_016() {
		return WFLM_016;
	}

	public void setWFLM_016(Double wFLM_016) {
		WFLM_016 = wFLM_016;
	}

	public Double getWFLM_017() {
		return WFLM_017;
	}

	public void setWFLM_017(Double wFLM_017) {
		WFLM_017 = wFLM_017;
	}

	public Double getWFLM_018() {
		return WFLM_018;
	}

	public void setWFLM_018(Double wFLM_018) {
		WFLM_018 = wFLM_018;
	}

	public Double getWFLM_019() {
		return WFLM_019;
	}

	public void setWFLM_019(Double wFLM_019) {
		WFLM_019 = wFLM_019;
	}

	public Double getWFLM_020() {
		return WFLM_020;
	}

	public void setWFLM_020(Double wFLM_020) {
		WFLM_020 = wFLM_020;
	}

	public Double getWFLM_021() {
		return WFLM_021;
	}

	public void setWFLM_021(Double wFLM_021) {
		WFLM_021 = wFLM_021;
	}

	public Double getWFLM_022() {
		return WFLM_022;
	}

	public void setWFLM_022(Double wFLM_022) {
		WFLM_022 = wFLM_022;
	}

	public Double getWFLM_023() {
		return WFLM_023;
	}

	public void setWFLM_023(Double wFLM_023) {
		WFLM_023 = wFLM_023;
	}

	public Double getWFLM_024() {
		return WFLM_024;
	}

	public void setWFLM_024(Double wFLM_024) {
		WFLM_024 = wFLM_024;
	}

	public Double getWFLM_025() {
		return WFLM_025;
	}

	public void setWFLM_025(Double wFLM_025) {
		WFLM_025 = wFLM_025;
	}

	public Double getWFLM_026() {
		return WFLM_026;
	}

	public void setWFLM_026(Double wFLM_026) {
		WFLM_026 = wFLM_026;
	}

	public Double getWFLM_027() {
		return WFLM_027;
	}

	public void setWFLM_027(Double wFLM_027) {
		WFLM_027 = wFLM_027;
	}

	public Double getWFLM_028() {
		return WFLM_028;
	}

	public void setWFLM_028(Double wFLM_028) {
		WFLM_028 = wFLM_028;
	}

	public Double getWFLM_029() {
		return WFLM_029;
	}

	public void setWFLM_029(Double wFLM_029) {
		WFLM_029 = wFLM_029;
	}

	public Double getWFLM_030() {
		return WFLM_030;
	}

	public void setWFLM_030(Double wFLM_030) {
		WFLM_030 = wFLM_030;
	}

	public Double getWFLM_031() {
		return WFLM_031;
	}

	public void setWFLM_031(Double wFLM_031) {
		WFLM_031 = wFLM_031;
	}

	public Double getWFLM_032() {
		return WFLM_032;
	}

	public void setWFLM_032(Double wFLM_032) {
		WFLM_032 = wFLM_032;
	}

	public Double getWFLM_033() {
		return WFLM_033;
	}

	public void setWFLM_033(Double wFLM_033) {
		WFLM_033 = wFLM_033;
	}

	public Double getWFLM_034() {
		return WFLM_034;
	}

	public void setWFLM_034(Double wFLM_034) {
		WFLM_034 = wFLM_034;
	}

	public Double getWFLM_035() {
		return WFLM_035;
	}

	public void setWFLM_035(Double wFLM_035) {
		WFLM_035 = wFLM_035;
	}

	public Double getWFLM_036() {
		return WFLM_036;
	}

	public void setWFLM_036(Double wFLM_036) {
		WFLM_036 = wFLM_036;
	}

	public Double getWFLM_037() {
		return WFLM_037;
	}

	public void setWFLM_037(Double wFLM_037) {
		WFLM_037 = wFLM_037;
	}

	public Double getWFLM_038() {
		return WFLM_038;
	}

	public void setWFLM_038(Double wFLM_038) {
		WFLM_038 = wFLM_038;
	}

	public Double getWFLM_039() {
		return WFLM_039;
	}

	public void setWFLM_039(Double wFLM_039) {
		WFLM_039 = wFLM_039;
	}

	public Double getWFLM_040() {
		return WFLM_040;
	}

	public void setWFLM_040(Double wFLM_040) {
		WFLM_040 = wFLM_040;
	}

	public Double getWFLM_041() {
		return WFLM_041;
	}

	public void setWFLM_041(Double wFLM_041) {
		WFLM_041 = wFLM_041;
	}

	public Double getWFLM_042() {
		return WFLM_042;
	}

	public void setWFLM_042(Double wFLM_042) {
		WFLM_042 = wFLM_042;
	}

	public int compareTo(OhioReading o) {
		return this.getTime().compareTo(o.getTime());
	}

}