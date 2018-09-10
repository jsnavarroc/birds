package com.birds.vo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Vo que representa una Zona
 */
@Entity
@Table( name = "TONT_ZONAS")
public class Zone implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1007129046106220073L;
	@Id
	private String cdzona;
	private String dsnombre;
	
	@OneToMany (cascade = CascadeType.REMOVE, orphanRemoval = true)
	@JoinColumn(name = "cdzona")
	private List<Country> countries;

	/**
	 * @return the cdzona
	 */
	public String getCdzona() {
		return cdzona;
	}

	/**
	 * @param cdzona
	 *            the cdzona to set
	 */
	public void setCdzona(String cdzona) {
		this.cdzona = cdzona;
	}

	/**
	 * @return the dsnombre
	 */
	public String getDsnombre() {
		return dsnombre;
	}

	/**
	 * @param dsnombre
	 *            the dsnombre to set
	 */
	public void setDsnombre(String dsnombre) {
		this.dsnombre = dsnombre;
	}

	/**
	 * @return the countries
	 */
	public List<Country> getCountries() {
		return countries;
	}

	/**
	 * @param countries the countries to set
	 */
	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Zone [cdzona=" + cdzona + ", dsnombre=" + dsnombre + ", countries=" + countries + "]";
	}
	
}
