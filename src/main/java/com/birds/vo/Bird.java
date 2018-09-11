package com.birds.vo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Vo que representa la información de un ave
 */
@Entity
@Table(name = "tont_aves")
public class Bird implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3421744392721855944L;
	@Id
	private String cdave;
	private String dsnombre_comun;
	private String dsnombre_cientifico;
	private String image;
	
	@ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.MERGE
            })
    @JoinTable(name = "tont_aves_pais",
            joinColumns = { @JoinColumn(name = "cdave") },
            inverseJoinColumns = { @JoinColumn(name = "cdpais") })
	private List<Country> countries;
	
	/**
	 * @return the cdave
	 */
	public String getCdave() {
		return cdave;
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
	/**
	 * @param cdave the cdave to set
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
	 * @param dsnombre_comun the dsnombre_comun to set
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
	 * @param dsnombre_cientifico the dsnombre_cientifico to set
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
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "Bird [cdave=" + cdave + ", dsnombre_comun=" + dsnombre_comun + ", dsnombre_cientifico="
				+ dsnombre_cientifico + ", image=" + image + ", countries=" + countries + "]";
	}


}
