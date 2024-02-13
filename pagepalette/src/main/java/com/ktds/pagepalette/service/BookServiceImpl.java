package com.ktds.pagepalette.service;

import com.ktds.pagepalette.dto.book.BookInfoRes;
import com.ktds.pagepalette.dto.book.BookSearchRes;
import com.ktds.pagepalette.entity.Book;
import com.ktds.pagepalette.repository.BookRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BookServiceImpl implements BookService{
    private final BookRepository bookRepository;
    @Override
    public ArrayList<Book> findAll() {
        return null;
    }

    @Override
    public HashMap<String, Object> searchBooks(String title, Pageable pageable) {
        HashMap<String, Object> result = new HashMap<>();
        List<BookSearchRes> list =new ArrayList<>();
        Slice<Book> books = bookRepository.findByBookTitleContaining(title,pageable);
        System.out.println(books.getContent());
        list = books.getContent().stream().map(i->new BookSearchRes(i.getBookTitle(), i.getBookIsbn(), i.getAuthor().getAuthorName(), i.getBookImage())).collect(toList());
        result.put("bookList", list);
        result.put("hasNext", books.hasNext());
        return result;
    }

    @Override
    public BookInfoRes findBookInfo(String bookIsbn) {
        return bookRepository.findBookByBookIsbn(bookIsbn);
    }
}
