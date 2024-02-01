package com.ktds.pagepalette.repository;

import com.ktds.pagepalette.dto.board.BoardReadRes;
import com.ktds.pagepalette.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
    @Query("select new com.ktds.pagepalette.dto.board.BoardReadRes(b.id, b.title, b.bgColor, b.user.email) from Board b where b.user.email =:email")
    public ArrayList<BoardReadRes> find(String email);
}
