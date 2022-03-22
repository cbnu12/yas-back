package com.yas.backend.common.entity;

import com.yas.backend.common.entity.TeamEntity;
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

    @Column
    private String role;

    @Column
    private LocalDate joinAt;




}
