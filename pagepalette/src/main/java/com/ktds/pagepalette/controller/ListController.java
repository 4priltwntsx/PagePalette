package com.ktds.pagepalette.controller;

import com.ktds.pagepalette.dto.list.ListModifyReq;
import com.ktds.pagepalette.dto.list.ListReq;
import com.ktds.pagepalette.service.ListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/list")
public class ListController {
    private final ListService listService;
    @PostMapping
    public ResponseEntity<?> createList(@RequestBody ListReq request){
        return new ResponseEntity<>(listService.createList(request), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{board_id}")
    public ResponseEntity<?> readAllList(@PathVariable("board_id") Long boardId){
        return new ResponseEntity<>(listService.readAll(boardId), HttpStatus.ACCEPTED);
    }

    @PutMapping
    public ResponseEntity<?> modifyList(@RequestBody ListModifyReq request){
        return new ResponseEntity<>(listService.modifyList(request), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{list_id}")
    public ResponseEntity<?> deleteList(@PathVariable Long list_id){
        return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
    }
}
