package com.yas.backend.domain.user.data.mapper;

import com.yas.backend.common.entity.UserEntity;
import com.yas.backend.domain.user.data.User;
import com.yas.backend.domain.user.data.dto.SignUpRequest;
import com.yas.backend.domain.user.data.response.UserResponse;
import com.yas.backend.domain.user.data.dto.UserDto;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class UserMapper {
    public User entityToDomain(UserEntity entity) {
        return User.builder()
                .email(entity.getEmail())
                .password(entity.getPassword())
                .nickname(entity.getNickname())
                .birth(entity.getBirth())
                .careerStartAt(entity.getCareerStartAt())
                .build();
    }

    public UserDto entityToDto(UserEntity entity) {
        return UserDto.builder()
                .email(entity.getEmail())
                .password(entity.getPassword())
                .nickname(entity.getNickname())
                .birth(entity.getBirth())
                .careerStartAt(entity.getCareerStartAt()).build();
    }



    public UserDto domainToDto(User domain) {
        return UserDto.builder()
                .email(domain.getEmail())
                .nickname(domain.getNickname())
                .years(LocalDate.now().getYear() - domain.getBirth().getYear())
                .careerYear(LocalDate.now().getYear() - domain.getCareerStartAt().getYear())
                .build();
    }

    public UserResponse dtoToResponse(UserDto dto) {
        return UserResponse.builder()
                .email(dto.getEmail())
                .nickname(dto.getNickname())
                .birthYear(dto.getYears())
                .careerYear(dto.getCareerYear())
                .build();
    }

    public UserEntity dtoToEntity(UserDto dto) {
        return UserEntity.builder()
                .birth(dto.getBirth())
                .careerStartAt(dto.getCareerStartAt())
                .createdAt(dto.getCreatedAt())
                .createdBy(dto.getCreatedBy())
                .email(dto.getEmail())
                .nickname(dto.getNickname())
                .password(dto.getPassword())
                .isActive(dto.isActive())
                .showsBirth(dto.isShowsBirth())
                .build();

    }

}
