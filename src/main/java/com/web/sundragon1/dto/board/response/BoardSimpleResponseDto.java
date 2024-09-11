package com.web.sundragon1.dto.board.response;

import lombok.Getter;

@Getter
public class BoardSimpleResponseDto {

    private final String title;
    private final String contents;

    public BoardSimpleResponseDto(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }
}
