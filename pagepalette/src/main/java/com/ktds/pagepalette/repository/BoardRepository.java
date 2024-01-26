package com.ktds.pagepalette.repository;

import com.ktds.pagepalette.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
