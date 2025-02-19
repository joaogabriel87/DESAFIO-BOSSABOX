package com.projeto.desafio1.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data

@Entity
public class AppEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Title;
    private String Link;
    private String Description;
    @ElementCollection
    private List<String> Tags;

}