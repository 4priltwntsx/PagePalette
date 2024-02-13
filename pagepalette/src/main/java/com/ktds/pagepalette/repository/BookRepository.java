package com.ktds.pagepalette.repository;

import com.ktds.pagepalette.dto.book.BookInfoRes;
import com.ktds.pagepalette.entity.Book;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {
    Slice<Book> findByBookTitleContaining(String title, Pageable pageable);

    @Query("select new com.ktds.pagepalette.dto.book.BookInfoRes(b.bookTitle, b.bookIsbn, b.author.authorName, b.bookImage, b.bookDescription) from Book b where b.bookIsbn=:bookIsbn")
    public BookInfoRes findBookByBookIsbn(String bookIsbn);
}
