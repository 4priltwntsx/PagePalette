package com.ktds.pagepalette.controller;

import com.ktds.pagepalette.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
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
@CrossOrigin(origins = "*", methods = RequestMethod.GET)
public class BookController {
    private final BookService bookService;
    @GetMapping("/search")
    @Operation(summary = "도서 검색", description = "도서 정보를 검색한다.")
    public ResponseEntity<?> searchBooks(@RequestParam String bookTitle, int size, int page) throws Exception{
        PageRequest pageRequest = PageRequest.of(page, size);
        HashMap<String, Object> map = new HashMap<>();
        map = bookService.searchBooks(bookTitle, pageRequest);

        return new ResponseEntity<>(map, HttpStatus.ACCEPTED);
    }

    @GetMapping("/{bookIsbn}")
    @Operation(summary = "도서 정보 조회", description = "도서 상세 정보를 조회한다.")
    public ResponseEntity<?> getBookInfo(@PathVariable String bookIsbn){
        return new ResponseEntity<>(bookService.findBookInfo(bookIsbn), HttpStatus.ACCEPTED);
    }
}
