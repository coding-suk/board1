package com.web.sundragon1.service;

import com.web.sundragon1.dto.board.request.BoardSaveRequestDto;
import com.web.sundragon1.dto.board.request.BoardUpdateRequestDto;
import com.web.sundragon1.dto.board.response.BoardDetailResponseDto;
import com.web.sundragon1.dto.board.response.BoardSaveResponseDto;
import com.web.sundragon1.dto.board.response.BoardSimpleResponseDto;
import com.web.sundragon1.dto.board.response.BoardUpdateResponseDto;
import com.web.sundragon1.entity.Board;
import com.web.sundragon1.repository.BoardRepository;
import com.web.sundragon1.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;

    @Transactional
    public BoardSaveResponseDto saveBoard(BoardSaveRequestDto requestDto) {
        Board newBoard = new Board(requestDto.getTitle(), requestDto.getContents());
        Board savedBoard = boardRepository.save(newBoard);

        return new BoardSaveResponseDto(savedBoard.getId(), savedBoard.getTitle(), savedBoard.getContents());
    }

    public List<BoardSimpleResponseDto> getBoards() {
        List<Board> boardList = boardRepository.findAll();

        List<BoardSimpleResponseDto> dtoList = new ArrayList<>();
        for (Board board : boardList) {
            BoardSimpleResponseDto dto = new BoardSimpleResponseDto(board.getTitle(), board.getContents());
            dtoList.add(dto);
        }
        return dtoList;
    }

    public BoardDetailResponseDto detailBoard(Long boardId) {
        Board board = boardRepository.findById(boardId).orElseThrow(()-> new NullPointerException("보드가 없습니다"));

        return new BoardDetailResponseDto(board.getId(), board.getTitle(), board.getContents());
    }

    @Transactional
    public BoardUpdateResponseDto updateBoard(Long boardId, BoardUpdateRequestDto requestDto) {
        Board board = boardRepository.findById(boardId).orElseThrow(()-> new NullPointerException("보드가 없습니다"));

        board.update(requestDto.getTitle(), requestDto.getContents());

        return new BoardUpdateResponseDto(board.getId(), board.getTitle(), board.getContents());
    }

    @Transactional
    public void deleteBoard(Long boardId) {
        Board board = boardRepository.findById(boardId).orElseThrow(()-> new NullPointerException("보드가 없습니다"));

        boardRepository.delete(board);
    }
}
