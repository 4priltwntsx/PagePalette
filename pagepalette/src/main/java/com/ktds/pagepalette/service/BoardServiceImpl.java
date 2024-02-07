package com.ktds.pagepalette.service;

import com.ktds.pagepalette.dto.board.BoardReadRes;
import com.ktds.pagepalette.dto.board.BoardReq;
import com.ktds.pagepalette.entity.Board;
import com.ktds.pagepalette.exception.NotFoundException;
import com.ktds.pagepalette.repository.BoardRepository;
import com.ktds.pagepalette.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public BoardReadRes readOne(Long boardId) {
        Optional<Board> board = boardRepository.findById(boardId);
        if(board.isEmpty()){
            throw new NotFoundException("존재하지 않는 보드 아이디");
        }
        return new BoardReadRes(board.get().getId(), board.get().getTitle(), board.get().getBgColor(), board.get().getUser().getEmail() );
    }

    @Override
    @Transactional
    public Long modifyBoard(BoardReq boardReq) {
        Optional<Board> optionalBoard = boardRepository.findById(boardReq.getId());
        if(optionalBoard.isEmpty()){
            throw new NotFoundException("존재하지 않는 보드 아이디");
        }
        Board board = optionalBoard.get();
        board.update(boardReq.getTitle(), boardReq.getBgColor());
        return board.getId();
    }

    @Override
    @Transactional
    public Boolean deleteBoard(Long boardId) {
        Optional<Board> optionalBoard = boardRepository.findById(boardId);
        if(optionalBoard.isEmpty()) {
            throw new NotFoundException("존재하지 않는 보드 아이디");
        }
        Board board = optionalBoard.get();
        board.delete();
        return true;
    }
}
