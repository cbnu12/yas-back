package com.yas.backend.domain.team.exchange;

import com.google.common.collect.Sets;
import com.yas.backend.common.values.Schedule;
import com.yas.backend.domain.team.dto.TeamDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeamCreateRequest {

        private Long ownerId;
        private String name;
        private String description;
        private Long maxUserCount;
        private String topic;
        private List<String> techStacks;
        private Schedule schedule;

        public TeamDto toDto() {
                return TeamDto.builder()
                        .ownerId(ownerId)
                        .name(name)
                        .description(description)
                        .maxUserCount(maxUserCount)
                        .topic(topic)
                        .techStacks(Sets.newHashSet(techStacks))
                        .build();
        }
}
