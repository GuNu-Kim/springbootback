package com.gunu.todolist.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "image")
@Table(name = "image")
public class ImageEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sequance;
    private int boardNumber;
    private String image;

    public ImageEntity(int boardNumber, String image){
        this.boardNumber = boardNumber;
        this.image = image;

    }
}
