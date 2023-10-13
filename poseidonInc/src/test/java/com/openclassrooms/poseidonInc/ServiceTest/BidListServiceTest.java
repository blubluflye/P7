package com.openclassrooms.poseidonInc.ServiceTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

import com.openclassrooms.poseidonInc.nnk.domain.BidList;
import com.openclassrooms.poseidonInc.nnk.repositories.BidListRepository;
import com.openclassrooms.poseidonInc.nnk.services.BidListService;

@ExtendWith(MockitoExtension.class)
public class BidListServiceTest {
	@InjectMocks
	BidListService bidListService;
	@Mock
	BidListRepository bidListRepository;
	
	@Test
	public void bidListCreateTest() {
		BidList bidList = new BidList();
		bidList.setAccount("Test");
		given(bidListRepository.save(bidList)).willReturn(bidList);
		assertThat(bidListService.create(bidList).getAccount()).isEqualTo(bidList.getAccount());
	}
	
	@Test
	public void bidListDeleteTest() {
		BidList bidList = new BidList();
		bidList.setAccount("Test");
		willDoNothing().given(bidListRepository).delete(bidList);
		bidListService.delete(bidList);
		verify(bidListRepository, times(1)).delete(bidList);
	}
	
	@Test
	public void bidListFindAllTest() {
		List<BidList> bidLists = new ArrayList<BidList>();
		bidLists.add(new BidList());
		given(bidListRepository.findAll()).willReturn(bidLists);
		assertThat(bidListService.findAll().size()).isEqualTo(1);
	}
	
	@Test
	public void bidListUpdateTest() {
		BidList bidList = new BidList();
		bidList.setAccount("Test");
		given(bidListRepository.save(bidList)).willReturn(bidList);
		assertThat(bidListService.update(bidList).getAccount()).isEqualTo(bidList.getAccount());
	}
	
	@Test
	public void bidListReadTest() {
		Optional<BidList> bidList = Optional.of(new BidList());
		bidList.get().setBidListId(1);
		bidList.get().setAccount("Test");
		given(bidListRepository.findById(1)).willReturn(bidList);
		assertThat(bidListService.read(1).get().getAccount()).isEqualTo(bidList.get().getAccount());
	}
}
