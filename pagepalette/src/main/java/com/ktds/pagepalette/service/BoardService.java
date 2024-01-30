package com.ktds.pagepalette.service;

import com.ktds.pagepalette.dto.board.BoardReq;
import com.ktds.pagepalette.dto.board.BoardReadRes;

import java.util.ArrayList;
import java.util.List;

public interface BoardService {
    public Long createBoard(BoardReq boardReq);
    public List<BoardReadRes> readAll(String email);
    public BoardReadRes readOne(Long boardId);
    public Boolean modifyBoard(BoardReq boardReq);
    public Boolean deleteBoard(String boardId);
}
