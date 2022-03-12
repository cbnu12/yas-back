package com.yas.backend.common.entity;

import com.yas.backend.common.enums.MeetingMethod;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "teams")
public class TeamEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "meeting_method", nullable = false)
    private MeetingMethod meetingMethod;

    @Column(name = "total_member_count", nullable = false)
    private Integer totalMemberCount;

    @Column(name = "description", nullable = false)
    private String description;

    @OneToOne
    private MemberEntity owner;

    @OneToMany(mappedBy = "team")
    private List<JoinEntity> joins;

    @OneToMany
    @JoinColumn(name = "hashtag_id")
    private List<HashtagEntity> hashtags;

    @OneToMany
    @JoinColumn(name = "tech_stack_id")
    private List<TechStackEntity> techStacks;

    @OneToOne
    private SchedulePolicyEntity schedulePolicy;

    @OneToMany(mappedBy = "team")
    private List<ScheduleEntity> schedules;

    @OneToMany(mappedBy = "team")
    private List<JoiningConditionEntity> joiningConditions;

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
