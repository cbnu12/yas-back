package com.yas.backend.domain.team.entity;

import javax.persistence.*;

@Entity
@Table(name = "joiningcondition")
public class JoiningConditionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
}