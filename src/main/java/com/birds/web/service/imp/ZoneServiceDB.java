package com.birds.web.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.birds.vo.Zone;
import com.birds.web.service.ZoneService;
import com.birds.web.service.persistence.DAOZone;
import com.google.common.collect.Lists;

/**
 * Implementación por defecto de {@link ZoneService}
 */
@Service
public class ZoneServiceDB implements ZoneService {
	
	@Autowired
	private DAOZone daoZone;

	@Override
	public List<Zone> findAll() {
		return Lists.newArrayList(daoZone.findAll());
	}

	@Override
	public Zone findByID(String id) {
		Optional<Zone> zone = daoZone.findById(id);
		if(zone.isPresent()) {
			return zone.get();
		}
		return new Zone();
	}

}
