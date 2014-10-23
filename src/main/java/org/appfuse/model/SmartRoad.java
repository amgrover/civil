package org.appfuse.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table
@NamedQueries({ @NamedQuery(name = "findSmartRoad", query = "select r from SmartRoad r where r.test_seq_nbr = :seq and r.section=:section and r.resp_trig_time like :date ") })
public class SmartRoad {
	public String getTest_seq_nbr() {
		return test_seq_nbr;
	}

	public void setTest_seq_nbr(String test_seq_nbr) {
		this.test_seq_nbr = test_seq_nbr;
	}

	public String getInst_ID() {
		return inst_ID;
	}

	public void setInst_ID(String inst_ID) {
		this.inst_ID = inst_ID;
	}

	public String getRun_nbr() {
		return run_nbr;
	}

	public void setRun_nbr(String run_nbr) {
		this.run_nbr = run_nbr;
	}

	public String getResp_trig_time() {
		return resp_trig_time;
	}

	public void setResp_trig_time(String resp_trig_time) {
		this.resp_trig_time = resp_trig_time;
	}

	public String getResp_speed() {
		return resp_speed;
	}

	public void setResp_speed(String resp_speed) {
		this.resp_speed = resp_speed;
	}

	public String getResp_axle1() {
		return resp_axle1;
	}

	public void setResp_axle1(String resp_axle1) {
		this.resp_axle1 = resp_axle1;
	}

	public String getResp_axle2() {
		return resp_axle2;
	}

	public void setResp_axle2(String resp_axle2) {
		this.resp_axle2 = resp_axle2;
	}

	public String getResp_axle3() {
		return resp_axle3;
	}

	public void setResp_axle3(String resp_axle3) {
		this.resp_axle3 = resp_axle3;
	}

	public String getResp_axle4() {
		return resp_axle4;
	}

	public void setResp_axle4(String resp_axle4) {
		this.resp_axle4 = resp_axle4;
	}

	public String getResp_axle5() {
		return resp_axle5;
	}

	public void setResp_axle5(String resp_axle5) {
		this.resp_axle5 = resp_axle5;
	}

	public String getResp_axle6() {
		return resp_axle6;
	}

	public void setResp_axle6(String resp_axle6) {
		this.resp_axle6 = resp_axle6;
	}

	private Long id;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private String test_seq_nbr;
	private String inst_ID;
	private String run_nbr;
	private String resp_trig_time;
	private String resp_speed;
	private String resp_axle1;
	private String resp_axle2;
	private String resp_axle3;
	private String resp_axle4;
	private String resp_axle5;
	private String resp_axle6;
	private String section;
	private String year;

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

}
