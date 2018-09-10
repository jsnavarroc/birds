package com.birds.web.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.birds.vo.Bird;
import com.birds.web.service.BirdService;
import com.birds.web.service.persistence.DAOBird;
import com.google.common.collect.Lists;

/**
 * Implementación por defecto de {@link BirdService}
 */
@Service
public class BirdServiceDB implements BirdService {

	@Autowired
	private DAOBird daoBird;

	@Override
	public List<Bird> fidAll() {
		return Lists.newArrayList(daoBird.findAll());
	}

	@Override
	public void deteleById(String id) {
		daoBird.deleteById(id);
	}

	@Override
	public List<Bird> findByNameAndZoneName(String name, String zoneName) {
		return daoBird.findByNameAndZoneName(name, zoneName);
	}

	@Override
	public void createBird(Bird bird) {
		daoBird.save(bird);
	}
	
	@Override
	public Optional<Bird>  findById(String id) {
		return daoBird.findById(id);
	}

}
