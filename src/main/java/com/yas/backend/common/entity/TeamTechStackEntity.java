package com.yas.backend.common.entity;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "team_techstack")
public class TeamTechStackEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private TeamEntity team;

    @ManyToOne
    @JoinColumn(name = "techstack_id")
    private TechStackEntity techStack;
}
