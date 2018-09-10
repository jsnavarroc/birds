package com.birds.web.service.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.birds.vo.Zone;

/**
 * Interfaz para ejecución de sentencias SQL para la tabla de tont_zonas
 */
@Repository
public interface DAOZone extends CrudRepository<Zone, String>{

}
