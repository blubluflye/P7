package com.openclassrooms.poseidonInc.nnk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.poseidonInc.nnk.domain.CurvePoint;
import com.openclassrooms.poseidonInc.nnk.repositories.CurvePointRepository;

import jakarta.validation.Valid;

@Service
public class CurvePointService {
	
	@Autowired
	CurvePointRepository curvePointRepository;

	public  List<CurvePoint> findAll() {
		return curvePointRepository.findAll();
	}

	public CurvePoint create(@Valid CurvePoint curvePoint) {
		return curvePointRepository.save(curvePoint);
	}

	public  Optional<CurvePoint> read(Integer id) {
		return curvePointRepository.findById(id);
	}

	public CurvePoint update(@Valid CurvePoint curvePoint) {
		return curvePointRepository.save(curvePoint);
	}

	public void delete(CurvePoint curvePoint) {
		curvePointRepository.delete(curvePoint);
	}

}
