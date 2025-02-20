package com.projeto.desafio1.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data

@Entity
public class AppEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String link;
    private String description;
    @ElementCollection
    private List<String> tags;

}