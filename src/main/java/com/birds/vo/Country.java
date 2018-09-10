package com.birds.vo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Vo que representa la información de un pais
 */
@Entity
@Table(name = "tont_paises")
public class Country implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8836974419900057565L;
	@Id
	private String cdpais;
	@Column (updatable = false)
	private String dsnombre;
	
	@JsonIgnore
	@ManyToOne
	private Zone zone;

	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE }, mappedBy = "countries")
	private List<Bird> birds;

	/**
	 * @return the cdpais
	 */
	public String getCdpais() {
		return cdpais;
	}

	/**
	 * @return the birds
	 */
	public List<Bird> getBirds() {
		return birds;
	}

	/**
	 * @param birds
	 *            the birds to set
	 */
	public void setBirds(List<Bird> birds) {
		this.birds = birds;
	}

	/**
	 * @param cdpais
	 *            the cdpais to set
	 */
	public void setCdpais(String cdpais) {
		this.cdpais = cdpais;
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
	 * @return the zone
	 */
	public Zone getZone() {
		return zone;
	}

	/**
	 * @param zone
	 *            the zone to set
	 */
	public void setZone(Zone zone) {
		this.zone = zone;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Country [cdpais=" + cdpais + ", dsnombre=" + dsnombre + ", zone=" + zone + ", birds=" + birds + "]";
	}
	
	
}
