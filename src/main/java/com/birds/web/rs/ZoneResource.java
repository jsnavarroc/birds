package com.birds.web.rs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.birds.vo.Zone;
import com.birds.web.service.ZoneService;

/**
 * Recurso que expone los servicios para gestionar las zonas
 */
@CrossOrigin
@RestController
@RequestMapping("/zones")
public class ZoneResource {

	@Autowired
	private ZoneService zoneService;

	/**
	 * Obtiene las zonas registradas
	 * 
	 * @return zonas
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Zone>> findAllZones() {
		return ResponseEntity.ok(zoneService.findAll());
	}

}
