package com.ktds.pagepalette.controller;

import com.ktds.pagepalette.dto.board.BoardReq;
import com.ktds.pagepalette.service.BoardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/board")
@Tag(name = "페이지팔레트 보드판 생성하기")
public class BoardController {
    private final BoardService boardService;
    @PostMapping
    @Operation(summary = "보드 생성", description = "보드판을 새로 생성한다.")
    public ResponseEntity<?> createBoard(@RequestBody BoardReq boardReq){
        return new ResponseEntity<>(boardService.createBoard(boardReq), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{user_email}")
    public ResponseEntity<?> readAll(@PathVariable String user_email){
        return new ResponseEntity<>(boardService.readAll(user_email), HttpStatus.ACCEPTED);
    }

    @GetMapping("/detail/{board_id}")
    public ResponseEntity<?> readOne(@PathVariable Long board_id){
        return new ResponseEntity<>(boardService.readOne(board_id), HttpStatus.ACCEPTED);
    }

    @PutMapping("/")
    public ResponseEntity<?> modifyBoard(@RequestBody BoardReq request){
        return new ResponseEntity<>(boardService.modifyBoard(request), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{board_id}")
    public ResponseEntity<?> deleteBoard(@PathVariable Long board_id){
        return new ResponseEntity<>(boardService.deleteBoard(board_id), HttpStatus.ACCEPTED);
    }

}
