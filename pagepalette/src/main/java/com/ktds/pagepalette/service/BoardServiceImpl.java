package com.ktds.pagepalette.service;

import com.ktds.pagepalette.dto.board.BoardReadRes;
import com.ktds.pagepalette.dto.board.BoardReq;
import com.ktds.pagepalette.entity.Board;
import com.ktds.pagepalette.repository.BoardRepository;
import com.ktds.pagepalette.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardServiceImpl implements BoardService {
    private final UserRepository userRepository;
    private final BoardRepository boardRepository;

    @Override
    @Transactional
    public Long createBoard(BoardReq boardReq) {
        Long result = 0L;
        Board board = Board.builder().bgColor(boardReq.getBgColor()).isActive(true)
                .title(boardReq.getTitle()).user(userRepository.findById(boardReq.getUserEmail()).get())
                .build();
        result = boardRepository.save(board).getId();
        return result;
    }

    @Override
    public List<BoardReadRes> readAll(String email) {
        return boardRepository.find(email);
    }

    @Override
    public BoardReadRes readOne(String boardId) {
        return null;
    }

    @Override
    public Boolean modifyBoard(BoardReq boardReq) {
        return false;
    }

    @Override
    public Boolean deleteBoard(String boardId) {
        return false;
    }
}
