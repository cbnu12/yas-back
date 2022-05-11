package com.yas.backend.domain.user.mapper;

import com.yas.backend.common.entity.UserEntity;

import com.yas.backend.domain.user.User;
import com.yas.backend.domain.user.exchange.response.UserResponse;
import com.yas.backend.domain.user.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserDto entityToDto(UserEntity entity) {
        return UserDto.builder()
                .id(entity.getId())
                .email(entity.getEmail())
                .password(entity.getPassword())
                .nickname(entity.getNickname())
                .birth(entity.getBirth())
                .showsBirth(entity.isShowsBirth())
                .careerStartAt(entity.getCareerStartAt())
                .isActive(entity.isActive())
                .lastPasswordUpdateAt(entity.getLastPasswordUpdateAt())
                .signInFailCount(entity.getSignInFailCount())
                .build();
    }

    public UserEntity dtoToEntity(UserDto dto) {
        return UserEntity.builder()
                .id(dto.getId())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .nickname(dto.getNickname())
                .birth(dto.getBirth())
                .showsBirth(dto.isShowsBirth())
                .careerStartAt(dto.getCareerStartAt())
                .isActive(dto.isActive())
                .lastPasswordUpdateAt(dto.getLastPasswordUpdateAt())
                .signInFailCount(dto.getSignInFailCount())
                .build();

    }

    public User dtoToDomain(UserDto dto) {
        return User.builder()
                .id(dto.getId())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .nickname(dto.getNickname())
                .birth(dto.getBirth())
                .showsBirth(dto.isShowsBirth())
                .careerStartAt(dto.getCareerStartAt())
                .isActive(dto.isActive())
                .lastPasswordUpdateAt(dto.getLastPasswordUpdateAt())
                .signInFailCount(dto.getSignInFailCount())
                .build();
    }

    public UserDto domainToDto(User domain) {
        return UserDto.builder()
                .id(domain.getId())
                .email(domain.getEmail())
                .password(domain.getPassword())
                .nickname(domain.getNickname())
                .birth(domain.getBirth())
                .showsBirth(domain.isShowsBirth())
                .careerStartAt(domain.getCareerStartAt())
                .isActive(domain.isActive())
                .lastPasswordUpdateAt(domain.getLastPasswordUpdateAt())
                .signInFailCount(domain.getSignInFailCount())

                .birthYears(domain.getBirthYear())
                .careerYears(domain.getCareerYear())
                .build();
    }

    public UserResponse dtoToResponse(UserDto dto) {
        return UserResponse.builder()
                .email(dto.getEmail())
                .nickname(dto.getNickname())
                .birthYear(dto.getBirthYears())
                .careerYear(dto.getCareerYears())
                .build();
    }

}
