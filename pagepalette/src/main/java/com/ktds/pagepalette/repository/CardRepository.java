package com.ktds.pagepalette.repository;

import com.ktds.pagepalette.dto.card.CardRes;
import com.ktds.pagepalette.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
    @Query("select new com.ktds.pagepalette.dto.card.CardRes(c.description, c.pos, c.bgColor, c.id, c.title) from Card c where c.list.id=:listId and c.isActive = true order by c.pos")
    public ArrayList<CardRes> findCardsByListId(Long listId);

    @Modifying(clearAutomatically = true)
    @Query("update Card c SET c.pos=:pos where c.id = :cardId")
    int updatePos(Double pos, Long cardId);
}
