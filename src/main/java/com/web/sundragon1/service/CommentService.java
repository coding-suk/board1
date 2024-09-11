package com.web.sundragon1.service;

import com.web.sundragon1.dto.CommentResponseDto;
import com.web.sundragon1.dto.CommentSaveRequestDto;
import com.web.sundragon1.entity.Board;
import com.web.sundragon1.entity.Comment;
import com.web.sundragon1.repository.BoardRepository;
import com.web.sundragon1.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;

    @Transactional
    public void createComment(Long boardId, CommentSaveRequestDto requestDto) {

        Board board = boardRepository.findById(boardId).orElseThrow(()-> new NullPointerException("보드가 없습니다"));

        Comment newComment = new Comment(requestDto.getContents(), board);
        commentRepository.save(newComment);
    }

    public List<CommentResponseDto> getComment(Long boardId) {
        List<Comment> commentList = commentRepository.findAllByBoardId(boardId);

        List<CommentResponseDto> dtoList = new ArrayList<>();
        for (Comment comment : commentList) {
            CommentResponseDto dto = new CommentResponseDto(comment.getId(), comment.getContents());
            dtoList.add(dto);
        }
        return dtoList;
    }

}
