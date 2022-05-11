package com.yas.backend.domain.join.data.mapper;

import com.yas.backend.common.entity.JoinEntity;
import com.yas.backend.domain.join.dto.JoinDto;
import com.yas.backend.domain.join.exchange.JoinResponse;
import com.yas.backend.domain.team.mapper.TeamMapper;
import com.yas.backend.domain.user.data.mapper.UserMapper;
import com.yas.backend.domain.user.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.hibernate.mapping.Join;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JoinMapper {
    private final UserMapper userMapper;
    private final TeamMapper teamMapper;
    public JoinEntity dtoToEntity(JoinDto dto){
        return JoinEntity.builder()
                .user(userMapper.dtoToEntity(dto.getUser()))
                .team(teamMapper.dtoToEntity(dto.getTeam()))
                .build();
    }

    public JoinDto entityToDto(JoinEntity entity){
        return JoinDto.builder()
                .user(userMapper.entityToDto(entity.getUser()))
                .team(teamMapper.entityToDto(entity.getTeam()))
                .build();
    }

    public JoinResponse dtoToResponse(JoinDto dto){
        return JoinResponse.builder()
                .user(dto.getUser())
                .team(dto.getTeam())
                .build();
    }
}
