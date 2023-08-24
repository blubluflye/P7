package com.openclassrooms.poseidonInc.nnk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.openclassrooms.poseidonInc.nnk.domain.CurvePoint;

public interface CurvePointRepository extends JpaRepository<CurvePoint, Integer> {

}
