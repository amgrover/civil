package org.appfuse.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "loads")
public class Load implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2094287265063572955L;
	private Long id;
	private Set<PressureSpeed> pressureSpeeds;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "load_ps", joinColumns = { @JoinColumn(name = "load_id") }, inverseJoinColumns = @JoinColumn(name = "ps_id"))
	public Set<PressureSpeed> getPressureSpeeds() {
		return pressureSpeeds;
	}

	public void setPressureSpeeds(Set<PressureSpeed> pressureSpeeds) {
		this.pressureSpeeds = pressureSpeeds;
	}

	public void addPressureSpeed(PressureSpeed pressureSpeed) {
		if (pressureSpeeds == null) {
			pressureSpeeds = new HashSet<PressureSpeed>();
		}
		pressureSpeeds.add(pressureSpeed);
	}
}
