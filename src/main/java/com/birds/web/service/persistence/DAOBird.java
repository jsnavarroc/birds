package com.birds.web.service.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.birds.vo.Bird;

/**
 * Interfaz para ejecución de sentencias SQL en la tabla de tont_aves
 */
@Repository
public interface DAOBird extends CrudRepository<Bird, String> {

	public final static String SELECT_BY_NAME_AND_ZONE_NAME = "select a.cdave, a.dsnombre_comun, a.dsnombre_cientifico, a.image from tont_aves a " + 
			"left join tont_aves_pais tav on tav. cdave = a.cdave " + 
			"left join tont_paises tp on tp.cdpais = tav.cdpais " + 
			"left join tont_zonas tz on tz.cdzona = tp.cdzona " + 
			"where (a.dsnombre_comun = :name or a.dsnombre_cientifico = :name) " + 
			" and tz.dsnombre = :zoneName group by a.cdave";
	
	@Query(value = SELECT_BY_NAME_AND_ZONE_NAME, nativeQuery = true)
	List<Bird> findByNameAndZoneName(@Param("name") String name, @Param("zoneName") String zoneName);
}
