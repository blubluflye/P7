package com.openclassrooms.poseidonInc.ServiceTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.times;

import com.openclassrooms.poseidonInc.nnk.domain.CurvePoint;
import com.openclassrooms.poseidonInc.nnk.repositories.CurvePointRepository;
import com.openclassrooms.poseidonInc.nnk.services.CurvePointService;

@ExtendWith(MockitoExtension.class)
public class CurvePointServiceTest {
	@InjectMocks
	CurvePointService curvePointService;
	@Mock
	CurvePointRepository curvePointRepository;
	
	@Test
	public void CurvePointCreateTest() {
		CurvePoint curvePoint = new CurvePoint();
		curvePoint.setValue(3.);
		given(curvePointRepository.save(curvePoint)).willReturn(curvePoint);
		assertThat(curvePointService.create(curvePoint).getValue()).isEqualTo(3.);
	}
	
	@Test
	public void CurvePointDeleteTest() {
		CurvePoint curvePoint = new CurvePoint();
		curvePoint.setId(1);
		willDoNothing().given(curvePointRepository).delete(curvePoint);
		curvePointService.delete(curvePoint);
		verify(curvePointRepository, times(1)).delete(curvePoint);
	}
	
	@Test
	public void CurvePointFindAllTest() {
		List<CurvePoint> curvePoints = new ArrayList<CurvePoint>();
		curvePoints.add(new CurvePoint());
		given(curvePointRepository.findAll()).willReturn(curvePoints);
		assertThat(curvePointService.findAll().size()).isEqualTo(1);
	}
	
	@Test
	public void CurvePointUpdateTest() {
		CurvePoint curvePoint = new CurvePoint();
		curvePoint.setValue(1.);
		given(curvePointRepository.save(curvePoint)).willReturn(curvePoint);
		assertThat(curvePointService.update(curvePoint).getValue()).isEqualTo(curvePoint.getValue());
	}
	
	@Test
	public void CurvePointReadTest() {
		Optional<CurvePoint> curvePoint = Optional.of(new CurvePoint());
		curvePoint.get().setId(1);
		curvePoint.get().setValue(2.);
		given(curvePointRepository.findById(1)).willReturn(curvePoint);
		assertThat(curvePointService.read(1).get().getValue()).isEqualTo(curvePoint.get().getValue());
	}
}
