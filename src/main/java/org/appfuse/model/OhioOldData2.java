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
@NamedQueries({ @NamedQuery(name = "findOhioOld2", query = "select r from OhioOldData2 r where r.filter1 = :filter1 and r.filter2 = :filter2 ") })
public class OhioOldData2 implements Serializable, Comparable<OhioOldData2> {
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

	public String getTime() {
		return Time;
	}

	public void setTime(String time) {
		Time = time;
	}

	private String WFA1;
	private String WFA2;
	private String WFA3;
	private String WFA4;
	private String WFA5;
	private String WFA6;
	private String WFA7;
	private String WFA8;
	private String WFA9;
	private String WFA10;
	private String WFA11;
	private String WFA12;
	private String WFB1;
	private String WFB2;
	private String WFB3;
	private String WFB4;
	private String WFB5;
	private String WFB6;
	private String WFB7;
	private String WFB8;
	private String WFB9;
	private String WFB10;
	private String WFB11;
	private String WFB12;

	public String getWFA1() {
		return WFA1;
	}

	public void setWFA1(String wFA1) {
		WFA1 = wFA1;
	}

	public String getWFA2() {
		return WFA2;
	}

	public void setWFA2(String wFA2) {
		WFA2 = wFA2;
	}

	public String getWFA3() {
		return WFA3;
	}

	public void setWFA3(String wFA3) {
		WFA3 = wFA3;
	}

	public String getWFA4() {
		return WFA4;
	}

	public void setWFA4(String wFA4) {
		WFA4 = wFA4;
	}

	public String getWFA5() {
		return WFA5;
	}

	public void setWFA5(String wFA5) {
		WFA5 = wFA5;
	}

	public String getWFA6() {
		return WFA6;
	}

	public void setWFA6(String wFA6) {
		WFA6 = wFA6;
	}

	public String getWFA7() {
		return WFA7;
	}

	public void setWFA7(String wFA7) {
		WFA7 = wFA7;
	}

	public String getWFA8() {
		return WFA8;
	}

	public void setWFA8(String wFA8) {
		WFA8 = wFA8;
	}

	public String getWFA9() {
		return WFA9;
	}

	public void setWFA9(String wFA9) {
		WFA9 = wFA9;
	}

	public String getWFA10() {
		return WFA10;
	}

	public void setWFA10(String wFA10) {
		WFA10 = wFA10;
	}

	public String getWFA11() {
		return WFA11;
	}

	public void setWFA11(String wFA11) {
		WFA11 = wFA11;
	}

	public String getWFA12() {
		return WFA12;
	}

	public void setWFA12(String wFA12) {
		WFA12 = wFA12;
	}

	public String getWFB1() {
		return WFB1;
	}

	public void setWFB1(String wFB1) {
		WFB1 = wFB1;
	}

	public String getWFB2() {
		return WFB2;
	}

	public void setWFB2(String wFB2) {
		WFB2 = wFB2;
	}

	public String getWFB3() {
		return WFB3;
	}

	public void setWFB3(String wFB3) {
		WFB3 = wFB3;
	}

	public String getWFB4() {
		return WFB4;
	}

	public void setWFB4(String wFB4) {
		WFB4 = wFB4;
	}

	public String getWFB5() {
		return WFB5;
	}

	public void setWFB5(String wFB5) {
		WFB5 = wFB5;
	}

	public String getWFB6() {
		return WFB6;
	}

	public void setWFB6(String wFB6) {
		WFB6 = wFB6;
	}

	public String getWFB7() {
		return WFB7;
	}

	public void setWFB7(String wFB7) {
		WFB7 = wFB7;
	}

	public String getWFB8() {
		return WFB8;
	}

	public void setWFB8(String wFB8) {
		WFB8 = wFB8;
	}

	public String getWFB9() {
		return WFB9;
	}

	public void setWFB9(String wFB9) {
		WFB9 = wFB9;
	}

	public String getWFB10() {
		return WFB10;
	}

	public void setWFB10(String wFB10) {
		WFB10 = wFB10;
	}

	public String getWFB11() {
		return WFB11;
	}

	public void setWFB11(String wFB11) {
		WFB11 = wFB11;
	}

	public String getWFB12() {
		return WFB12;
	}

	public void setWFB12(String wFB12) {
		WFB12 = wFB12;
	}

	public int compareTo(OhioOldData2 o) {
		return this.getTime().compareTo(o.getTime());
	}

}
