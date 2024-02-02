package com.ktds.pagepalette.service;

import com.ktds.pagepalette.entity.Book;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.HashMap;

public interface BookService {
    public ArrayList<Book> findAll();
    public HashMap<String, Object> searchBooks(String title, Pageable pageable);
}
