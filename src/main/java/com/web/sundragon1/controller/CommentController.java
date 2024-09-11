package com.web.sundragon1.controller;

import com.web.sundragon1.dto.CommentResponseDto;
import com.web.sundragon1.dto.CommentSaveRequestDto;
import com.web.sundragon1.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/boards/{boardId}/comments")
    public void createBoard(@PathVariable Long boardId ,@RequestBody CommentSaveRequestDto requestDto){
        commentService.createComment(boardId, requestDto);
    }

    @GetMapping("/boards/{boardId}/comments")
    public List<CommentResponseDto> getComment(@PathVariable Long boardId) {
        return commentService.getComment(boardId);
    }

}
