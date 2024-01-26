package com.ktds.pagepalette.repository;

import com.ktds.pagepalette.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {
}
