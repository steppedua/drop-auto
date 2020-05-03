package com.steppedua.dropauto.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String anons;

    private String full_text;

    private int views;


    public Courses() {
    }

    public Courses(String title, String anons, String full_text) {
        this.title = title;
        this.anons = anons;
        this.full_text = full_text;
    }
}
