package com.birds.web.service.imp;

import java.util.List;

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
	private DAOZone persistence;

	@Override
	public List<Zone> findAll() {
		return Lists.newArrayList(persistence.findAll());
	}

}
