package com.birds.web.service.imp;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.birds.dto.BirdDTO;
import com.birds.vo.Bird;
import com.birds.vo.Zone;
import com.birds.web.service.BirdService;
import com.birds.web.service.ZoneService;
import com.birds.web.service.persistence.DAOBird;
import com.google.common.collect.Lists;

/**
 * Implementación por defecto de {@link BirdService}
 */
@Service
public class BirdServiceDB implements BirdService {

	@Autowired
	private DAOBird daoBird;

	@Autowired
	private ZoneService zoneService;

	@Override
	public List<BirdDTO> fidAll() {
		return toBirdDTOList(Lists.newArrayList(daoBird.findAll()));
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
	public void createBird(BirdDTO birdDTO) {
		Bird bird = toBird(birdDTO);
		daoBird.save(bird);
	}

	@Override
	public BirdDTO findById(String id) {
		Optional<Bird> bird = daoBird.findById(id);
		if (bird.isPresent()) {
			return toBirdDTO(bird.get());
		}
		return new BirdDTO();
	}

	private List<BirdDTO> toBirdDTOList(List<Bird> birds) {
		return birds.stream().map(this::toBirdDTO).collect(Collectors.toList());
	}

	private BirdDTO toBirdDTO(Bird bird) {
		BirdDTO birdDTO = new BirdDTO();
		birdDTO.setCdave(bird.getCdave());
		birdDTO.setDsnombre_comun(bird.getDsnombre_comun());
		birdDTO.setDsnombre_cientifico(bird.getDsnombre_cientifico());
		birdDTO.setImage(bird.getImage());
		if (!bird.getCountries().isEmpty() && bird.getCountries().get(0).getZone() != null) {
			Zone zona = bird.getCountries().get(0).getZone();
			birdDTO.setCdzona(zona.getCdzona());
			birdDTO.setDsnombre_zona(zona.getDsnombre());
			birdDTO.setCountries(bird.getCountries());
		}
		return birdDTO;
	}

	private Bird toBird(BirdDTO birdDTO) {
		Bird bird = new Bird();
		bird.setCdave(birdDTO.getCdave());
		bird.setDsnombre_comun(birdDTO.getDsnombre_comun());
		bird.setDsnombre_cientifico(birdDTO.getDsnombre_cientifico());
		bird.setImage(birdDTO.getImage());
		Zone zone = zoneService.findByID(birdDTO.getCdzona());
		bird.setCountries(zone.getCountries());
		return bird;
	}

}
