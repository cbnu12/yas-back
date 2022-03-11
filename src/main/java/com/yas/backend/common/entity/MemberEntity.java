package com.yas.backend.domain.member.data.entity;

import com.yas.backend.domain.team.entity.TeamEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "members")
public class MemberEntity {

    @Id
    private Long id;

    @Column(name ="email")
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String nickname;

    @Column
    private LocalDate birth;

    @Column
    private boolean showsBirth;

    @Column
    private LocalDate careerStartAt;

    @Column
    private boolean isActive;

    @Column
    private LocalDateTime lastPasswordUpdateAt;

    @ManyToMany(mappedBy = "members")
    private List<TeamEntity> teams;

    @CreatedBy
    @Column(updatable = false)
    private String createdBy;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedBy
    private String updatedBy;

    @LastModifiedDate
    private LocalDateTime updatedAt;
}
