package com.yas.backend.common.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@DynamicInsert
@DynamicUpdate
@Builder
@Getter
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String nickname;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private FileEntity profileImage;

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

    @Column
    @ColumnDefault("0")
    private Integer signInFailCount;

    @OneToMany(mappedBy = "user")
    private List<JoinEntity> joins;

    @OneToMany(mappedBy = "user")
    private List<InviteEntity> invite;

    @CreatedBy
    private String createdBy;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedBy
    private String updatedBy;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @Column
    private boolean isDeleted;


    public Optional<FileEntity> getProfileImage() {
        return Optional.ofNullable(profileImage);
    }
}
