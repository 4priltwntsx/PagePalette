package com.ktds.pagepalette.controller;

import com.ktds.pagepalette.dto.card.CardReq;
import com.ktds.pagepalette.service.CardService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/card")
@Tag(name = "문장 카드 API(CardController)")
public class CardController {
    private final CardService cardService;

    @PostMapping
    public ResponseEntity<?> createCard(@RequestBody CardReq request){
        return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
    }

    @GetMapping("/{list_id}")
    public ResponseEntity<?> readAllCards(@PathVariable Long list_id){
        return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
    }
}
