package com.web.sundragon1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Entity
@NoArgsConstructor
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private List<Comment> contents;

    public Board(String title, List<Comment> contents) {
        this.title = title;
        this.contents = contents;
    }

    public void update(String title, List<Comment> contents) {
        this.title = title;
        this.contents = contents;
    }
}
