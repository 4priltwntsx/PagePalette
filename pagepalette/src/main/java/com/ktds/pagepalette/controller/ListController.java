package com.ktds.pagepalette.controller;

import com.ktds.pagepalette.dto.list.ListModifyReq;
import com.ktds.pagepalette.dto.list.ListReq;
import com.ktds.pagepalette.service.ListService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/list")
@Tag(name = "리스트 API(ListController)")
@CrossOrigin(origins = "*", methods = RequestMethod.GET)
public class ListController {
    private final ListService listService;
    @PostMapping
    @Operation(summary = "책 리스트 생성", description = "책 리스트를 생성한다.")
    public ResponseEntity<?> createList(@RequestBody ListReq request){
        return new ResponseEntity<>(listService.createList(request), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{board_id}")
    @Operation(summary = "리스트 조회", description = "리스트의 정보를 모두 조회한다.")
    public ResponseEntity<?> readAllList(@PathVariable("board_id") Long boardId){
        return new ResponseEntity<>(listService.readAll(boardId), HttpStatus.ACCEPTED);
    }

    @PutMapping
    @Operation(summary = "리스트 수정", description = "리스트의 정보를 수정한다.")
    public ResponseEntity<?> modifyList(@RequestBody ListModifyReq request){
        return new ResponseEntity<>(listService.modifyList(request), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{list_id}")
    @Operation(summary = "리스트 삭제", description = "리스트를 삭제한다.")
    public ResponseEntity<?> deleteList(@PathVariable Long list_id){
        return new ResponseEntity<>(listService.deleteList(list_id), HttpStatus.ACCEPTED);
    }
}
