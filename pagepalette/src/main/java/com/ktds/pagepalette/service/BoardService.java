package com.ktds.pagepalette.service;

import com.ktds.pagepalette.dto.board.BoardReq;
import com.ktds.pagepalette.dto.board.BoardReadRes;

import java.util.ArrayList;

public interface BoardService {
    public Long createBoard(BoardReq boardReq);
    public ArrayList<BoardReadRes> readAll();
    public BoardReadRes readOne(String boardId);
    public Boolean modifyBoard(BoardReq boardReq);
    public Boolean deleteBoard(String boardId);
}
