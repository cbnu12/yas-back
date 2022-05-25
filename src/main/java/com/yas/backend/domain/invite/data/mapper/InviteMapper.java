package com.yas.backend.domain.invite.data.mapper;

import com.yas.backend.common.entity.InviteEntity;
import com.yas.backend.domain.invite.dto.InviteDto;
import com.yas.backend.domain.invite.exchange.InviteResponse;
import com.yas.backend.domain.team.mapper.TeamMapper;
import com.yas.backend.domain.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InviteMapper {
    private final UserMapper userMapper;
    private final TeamMapper teamMapper;

    public InviteEntity dtoToEntity(InviteDto dto) {
        return InviteEntity.builder()
                .user(userMapper.dtoToEntity(dto.getUser()))
                .team(teamMapper.dtoToEntity(dto.getTeam()))
                .build();
    }

    public InviteDto entityToDto(InviteEntity entity) {
        return InviteDto.builder()
                .user(userMapper.entityToDto(entity.getUser()))
                .team(teamMapper.entityToDto(entity.getTeam()))
                .build();
    }

    public InviteResponse dtoToResponse(InviteDto dto) {
        return InviteResponse.builder()
                .user(dto.getUser())
                .team(dto.getTeam())
                .build();
    }
}
