package com.ktds.pagepalette.controller;

import com.ktds.pagepalette.dto.card.CardModifyReq;
import com.ktds.pagepalette.dto.card.CardPosReq;
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
    @Operation(summary = "문장카드 조회", description = "문장카드들을 모두 조회한다.")
    public ResponseEntity<?> readAllCards(@PathVariable Long list_id) {
        return new ResponseEntity<>(cardService.readAll(list_id), HttpStatus.ACCEPTED);
    }

    @GetMapping("/detail/{card_id}")
    @Operation(summary = "문장카드 상세 조회", description = "문장카드의 상세 정보를 조회한다.")
    public ResponseEntity<?> readOneCard(@PathVariable Long card_id) {
        return new ResponseEntity<>(cardService.readDetail(card_id), HttpStatus.ACCEPTED);
    }


    @PutMapping
    @Operation(summary = "문장카드 수정", description = "문장카드를 수정한다.")
    public ResponseEntity<?> modifyCard(@RequestBody CardModifyReq request) {
        return new ResponseEntity<>(cardService.modifyCard(request), HttpStatus.ACCEPTED);
    }

    @PutMapping("/position")
    @Operation(summary = "문장카드 위치 수정", description = "문장카드의 위치 정보를 수정한다.")
    public ResponseEntity<?> modifyCardPos(@RequestBody CardPosReq request) {
        return new ResponseEntity<>(cardService.modifyCardPos(request), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{card_id}")
    @Operation(summary = "문장카드 삭제", description = "문장카드를 삭제한다.")
    public ResponseEntity<?> deleteCard(@PathVariable Long card_id) {
        return new ResponseEntity<>(cardService.deleteCard(card_id), HttpStatus.ACCEPTED);
    }
}
