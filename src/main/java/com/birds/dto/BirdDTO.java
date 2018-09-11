package com.birds.dto;

import java.io.Serializable;
import java.util.List;

import com.birds.vo.Country;

/**
 * Clase que representa la información básica de un ave
 */
public class BirdDTO implements Serializable{

	private static final long serialVersionUID = -7406266460452203300L;
	
	private String cdave;
	private String dsnombre_comun;
	private String dsnombre_cientifico;
	private String image;
	private String cdzona;
	private String dsnombre_zona;
	private List<Country> countries;

	/**
	 * @return the cdave
	 */
	public String getCdave() {
		return cdave;
	}

	/**
	 * @param cdave
	 *            the cdave to set
	 */
	public void setCdave(String cdave) {
		this.cdave = cdave;
	}

	/**
	 * @return the dsnombre_comun
	 */
	public String getDsnombre_comun() {
		return dsnombre_comun;
	}

	/**
	 * @param dsnombre_comun
	 *            the dsnombre_comun to set
	 */
	public void setDsnombre_comun(String dsnombre_comun) {
		this.dsnombre_comun = dsnombre_comun;
	}

	/**
	 * @return the dsnombre_cientifico
	 */
	public String getDsnombre_cientifico() {
		return dsnombre_cientifico;
	}

	/**
	 * @param dsnombre_cientifico
	 *            the dsnombre_cientifico to set
	 */
	public void setDsnombre_cientifico(String dsnombre_cientifico) {
		this.dsnombre_cientifico = dsnombre_cientifico;
	}

	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * @param image
	 *            the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}

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
	public String getDsnombre_zona() {
		return dsnombre_zona;
	}

	/**
	 * @param dsnombre
	 *            the dsnombre to set
	 */
	public void setDsnombre_zona(String dsnombre_zona) {
		this.dsnombre_zona = dsnombre_zona;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BirdDTO [cdave=" + cdave + ", dsnombre_comun=" + dsnombre_comun + ", dsnombre_cientifico="
				+ dsnombre_cientifico + ", image=" + image + ", cdzona=" + cdzona + ", dsnombre_zona=" + dsnombre_zona + "]";
	}

}
