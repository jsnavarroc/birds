package com.birds.web.service;

import java.util.List;
import java.util.Optional;

import com.birds.vo.Bird;

/**
 * Contrato para un servicio que gestiona la información de un ave
 */
public interface BirdService {

	/**
	 * Busca todas las aves registradas
	 * 
	 * @return aves
	 */
	List<Bird> fidAll();

	/**
	 * Elimina un ave de los registros
	 */
	void deteleById(String id);

	/**
	 * Busca registros de aves según un nombre y una zona
	 * 
	 * @param name
	 * @param zoneName
	 * @return
	 */
	List<Bird> findByNameAndZoneName(String name, String zoneName);
	
	/**
	 * Busca ave por ID
	 * @param id >> identificador del ave 
	 * @return >> ave
	 */
	Optional<Bird> findById(String id);
	/**
	 * Crea un registro de un ave en la base de datos
	 * 
	 * @param bird
	 *            datos
	 */
	void createBird(Bird bird);
}
