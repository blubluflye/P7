package com.openclassrooms.poseidonInc.ServiceTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.times;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.openclassrooms.poseidonInc.nnk.domain.Trade;
import com.openclassrooms.poseidonInc.nnk.repositories.TradeRepository;
import com.openclassrooms.poseidonInc.nnk.services.TradeService;

@ExtendWith(MockitoExtension.class)
public class TradeServiceTest {
	@InjectMocks
	TradeService tradeService;
	@Mock
	TradeRepository tradeRepository;
	
	@Test
	public void tradeCreateTest() {
		Trade trade = new Trade();
		trade.setAccount("Test");
		given(tradeRepository.save(trade)).willReturn(trade);
		assertThat(tradeService.create(trade).getAccount()).isEqualTo("Test");
	}
	
	@Test
	public void tradeDeleteTest() {
		Trade trade = new Trade();
		trade.setAccount("Test");
		willDoNothing().given(tradeRepository).delete(trade);
		tradeService.delete(trade);
		verify(tradeRepository, times(1)).delete(trade);
	}
	
	@Test
	public void tradeFindAllTest() {
		List<Trade> trades = new ArrayList<Trade>();
		trades.add(new Trade());
		given(tradeRepository.findAll()).willReturn(trades);
		assertThat(tradeService.findAll().size()).isEqualTo(1);
	}
	
	@Test
	public void tradeUpdateTest() {
		Trade trade = new Trade();
		trade.setAccount("Test");
		given(tradeRepository.save(trade)).willReturn(trade);
		assertThat(tradeService.update(trade).getAccount()).isEqualTo("Test");
	}
	
	@Test
	public void tradeReadTest() {
		Optional<Trade> trade = Optional.of(new Trade());
		trade.get().setAccount("Test");
		trade.get().setTradeId(1);
		given(tradeRepository.findById(1)).willReturn(trade);
		assertThat(tradeService.read(1).get().getAccount()).isEqualTo("Test");
	}
}
