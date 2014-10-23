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
@Table(name = "state")
public class State implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7296712115808063086L;
	private Long id;
	private Set<Section> sections;
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
	@JoinTable(name = "state_section", joinColumns = { @JoinColumn(name = "state_id") }, inverseJoinColumns = @JoinColumn(name = "section_id"))
	public Set<Section> getSections() {
		return sections;
	}

	public void setSections(Set<Section> sections) {
		this.sections = sections;
	}

	public void addSection(Section section) {
		if (getSections() == null) {
			sections = new HashSet<Section>();
		}
		getSections().add(section);
	}

	// @Override
	// public int hashCode() {
	// int result;
	// result = (getName()!= null ? getName().hashCode() : 0);
	// return result;
	// }
	//
	// @Override
	// public boolean equals(Object obj) {
	// // TODO Auto-generated method stub
	// return super.equals(obj);
	// }

}
