package com.yas.backend.domain.team.entity;

import javax.persistence.*;

@Entity
@Table(name = "techstacks")
public class TechStackEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
}