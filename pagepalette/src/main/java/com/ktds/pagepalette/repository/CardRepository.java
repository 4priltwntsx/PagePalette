package com.ktds.pagepalette.repository;

import com.ktds.pagepalette.dto.card.CardListRes;
import com.ktds.pagepalette.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
    @Query("select new com.ktds.pagepalette.dto.card.CardListRes(c.description, c.pos, c.bgColor) from Card c where c.list.id=:listId")
    public ArrayList<CardListRes> findCardsByListId(Long listId);
}
