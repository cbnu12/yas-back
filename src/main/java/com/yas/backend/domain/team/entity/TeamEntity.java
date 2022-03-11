package com.yas.backend.domain.team.entity;

import com.yas.backend.common.enums.MeetingMethod;
import com.yas.backend.domain.member.data.entity.MemberEntity;

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

    @OneToMany
    @JoinTable(name = "team_member", joinColumns = @JoinColumn(name="team_id"), inverseJoinColumns = @JoinColumn(name="member_id"))
    private List<MemberEntity> members;

    @OneToMany
    @JoinTable(name = "team_hashtag", joinColumns = @JoinColumn(name="team_id"), inverseJoinColumns = @JoinColumn(name="hashtag_id"))
    private List<HashtagEntity> hashtags;

    @OneToMany
    @JoinTable(name = "team_techstack", joinColumns = @JoinColumn(name="team_id"), inverseJoinColumns = @JoinColumn(name="techstack_id"))
    private List<TechStackEntity> techStacks;

    @OneToMany
    @JoinTable(name = "team_meetingschedule", joinColumns = @JoinColumn(name="team_id"), inverseJoinColumns = @JoinColumn(name="meetingschedule_id"))
    private List<ScheduleEntity> schedules;

    @OneToMany
    @JoinTable(name = "team_joiningcondition", joinColumns = @JoinColumn(name="team_id"), inverseJoinColumns = @JoinColumn(name="joiningcondition_id"))
    private List<JoiningConditionEntity> joiningConditions;

}
