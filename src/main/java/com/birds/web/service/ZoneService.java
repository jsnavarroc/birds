package com.birds.web.service;

import java.util.List;

import com.birds.vo.Zone;

/**
 * Contrato para un servicio que gestiona la información de una zona
 */
public interface ZoneService {

	/**
	 * Busca todas las zonas registradas
	 * 
	 * @return zonas
	 */
	List<Zone> findAll();
}
