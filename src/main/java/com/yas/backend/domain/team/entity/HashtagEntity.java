package com.yas.backend.domain.team.entity;

import javax.persistence.*;

@Entity
@Table(name = "hashtags")
public class HashtagEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
}
