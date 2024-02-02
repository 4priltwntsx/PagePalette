package com.ktds.pagepalette.controller;

import com.ktds.pagepalette.service.BookService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/book")
@Tag(name = "도서 API(BookController)")
public class BookController {
    private final BookService bookService;
    @GetMapping("/search")
    public ResponseEntity<?> searchBooks(@RequestParam String bookTitle, int size, int page) throws Exception{
        PageRequest pageRequest = PageRequest.of(page, size);
        HashMap<String, Object> map = new HashMap<>();
        map = bookService.searchBooks(bookTitle, pageRequest);

        return new ResponseEntity<>(map, HttpStatus.ACCEPTED);
    }
}
