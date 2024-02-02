package com.ktds.pagepalette.repository;

import com.ktds.pagepalette.entity.Board;
import com.ktds.pagepalette.entity.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ListRepository extends JpaRepository<List, Long> {
    public ArrayList<List> findListByBoardAAndIsActiveIsTrue(Board board);
}
