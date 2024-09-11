package com.web.sundragon1.controller;

import com.web.sundragon1.dto.board.request.BoardSaveRequestDto;
import com.web.sundragon1.dto.board.request.BoardUpdateRequestDto;
import com.web.sundragon1.dto.board.response.BoardDetailResponseDto;
import com.web.sundragon1.dto.board.response.BoardSaveResponseDto;
import com.web.sundragon1.dto.board.response.BoardSimpleResponseDto;
import com.web.sundragon1.dto.board.response.BoardUpdateResponseDto;
import com.web.sundragon1.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/boards")
    public BoardSaveResponseDto saveBoard(@RequestBody BoardSaveRequestDto requestDto) {
        return boardService.saveBoard(requestDto);
    }

    @GetMapping("/boards")
    public List<BoardSimpleResponseDto> getBoards() {
        return boardService.getBoards();
    }

    @GetMapping("/boards/{boardId}")
    public BoardDetailResponseDto detailBoard(@PathVariable Long boardId) {
        return boardService.detailBoard(boardId);
    }

    @PutMapping("/boards/{boardId}")
    public BoardUpdateResponseDto updateBoard(@PathVariable Long boardId, @RequestBody BoardUpdateRequestDto requestDto) {
        return boardService.updateBoard(boardId, requestDto);
    }

    @DeleteMapping("/boards/{boardId}")
    public void deleteBoard(@PathVariable Long boardId) {
        boardService.deleteBoard(boardId);
    }

}
