package com.openclassrooms.poseidonInc.nnk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.openclassrooms.poseidonInc.nnk.domain.Trade;

public interface TradeRepository extends JpaRepository<Trade, Integer> {
}
