package com.ktds.pagepalette.controller;

import com.ktds.pagepalette.dto.card.CardModifyReq;
import com.ktds.pagepalette.dto.card.CardReq;
import com.ktds.pagepalette.service.CardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/card")
@Tag(name = "문장 카드 API(CardController)")
@CrossOrigin(origins = "*", methods = RequestMethod.GET)
public class CardController {
    private final CardService cardService;

    @PostMapping
    @Operation(summary = "문장카드 생성", description = "문장카드를 새로 생성한다. 카드가 속한 리스트 아이디 리턴")
    public ResponseEntity<?> createCard(@RequestBody CardReq request) {
        return new ResponseEntity<>(cardService.createCard(request), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{list_id}")
    public ResponseEntity<?> readAllCards(@PathVariable Long list_id) {
        return new ResponseEntity<>(cardService.readAll(list_id), HttpStatus.ACCEPTED);
    }

    @GetMapping("/detail/{card_id}")
    public ResponseEntity<?> readOneCard(@PathVariable Long card_id) {
        return new ResponseEntity<>(cardService.readDetail(card_id), HttpStatus.ACCEPTED);
    }


    @PutMapping
    public ResponseEntity<?> modifyCard(@RequestBody CardModifyReq request) {
        return new ResponseEntity<>(cardService.modifyCard(request), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{card_id}")
    public ResponseEntity<?> deleteCard(@PathVariable Long card_id) {
        return new ResponseEntity<>(cardService.deleteCard(card_id), HttpStatus.ACCEPTED);
    }
}
