package com.yas.backend.common.entity;

import com.yas.backend.common.enums.MeetingMethod;

import javax.persistence.*;
import java.util.List;

@Entity
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
    @JoinColumn(name = "techstack_id")
    private List<TechStackEntity> techStacks;

    @OneToMany(mappedBy = "team")
    private List<ScheduleEntity> schedules;

    @OneToMany(mappedBy = "team")
    private List<JoiningConditionEntity> joiningConditions;

}
