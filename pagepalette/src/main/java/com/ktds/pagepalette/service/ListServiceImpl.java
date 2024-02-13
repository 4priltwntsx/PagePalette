package com.ktds.pagepalette.service;

import com.ktds.pagepalette.dto.list.ListModifyReq;
import com.ktds.pagepalette.dto.list.ListReq;
import com.ktds.pagepalette.dto.list.ListRes;
import com.ktds.pagepalette.entity.Board;
import com.ktds.pagepalette.entity.Book;
import com.ktds.pagepalette.entity.List;
import com.ktds.pagepalette.exception.NotFoundException;
import com.ktds.pagepalette.repository.BoardRepository;
import com.ktds.pagepalette.repository.BookRepository;
import com.ktds.pagepalette.repository.CardRepository;
import com.ktds.pagepalette.repository.ListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ListServiceImpl implements ListService{
    private final ListRepository listRepository;
    private final BoardRepository boardRepository;
    private final CardRepository cardRepository;
    private final BookRepository bookRepository;

    @Override
    @Transactional
    public Boolean createList(ListReq req) {
        Optional<Board> optBoard = boardRepository.findById(req.getBoardId());
        Optional<Book> optionalBook = bookRepository.findById(req.getBookIsbn());
        if(optBoard.isEmpty()) throw new NotFoundException("존재하지 않는 보드 아이디!");
        if(optionalBook.isEmpty()) throw new NotFoundException("존재하지 않는 책 ISBN");

        List list = List.builder()
                .board(optBoard.get())
                .book(optionalBook.get()).isActive(true)
                .build();
        Long id = listRepository.save(list).getId();
        return id > 0;
    }

    @Override
    @Transactional
    public Boolean modifyList(ListModifyReq req) {
        Optional<List> optList = listRepository.findById(req.getListId());
        if(optList.isEmpty()) throw new NotFoundException("존재하지 않는 리스트 아이디!");
        List list = optList.get();


        return true;
    }

    @Override
    public ArrayList<ListRes> readAll(Long boardId) {
        Optional<Board> optBoard = boardRepository.findById(boardId);
        if(optBoard.isEmpty()) throw new NotFoundException("존재하지 않는 보드 아이디!");

        return new ArrayList<>(listRepository.findListByBoardAndIsActiveIsTrue(optBoard.get()).stream()
                .map(m-> new ListRes(m.getId(),m.getBook().getBookIsbn(), m.getBook().getBookTitle(), cardRepository.findCardsByListId(m.getId())))
                .toList());
    }

    @Override
    @Transactional
    public Boolean deleteList(Long listId) {
        Optional<List> optList = listRepository.findById(listId);
        if(optList.isEmpty()) throw new NotFoundException("존재하지 않는 리스트 아이디!");
        List list = optList.get();
        list.deleteList();
        return true;
    }
}
