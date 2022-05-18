package com.yas.backend.domain.user.service.application;

import com.querydsl.core.BooleanBuilder;
import com.yas.backend.common.exception.UserNotFoundException;
import com.yas.backend.domain.user.User;
import com.yas.backend.domain.user.dto.UserDto;
import com.yas.backend.domain.user.dto.UserPredicate;
import com.yas.backend.domain.user.exchange.request.UserSearchRequest;
import com.yas.backend.domain.user.mapper.UserMapper;
import com.yas.backend.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserQueryService {
    private final UserService userService;
    private final UserMapper mapper;

    public List<UserDto> findByPredicate(UserSearchRequest request) {
        BooleanBuilder predicate = UserPredicate.search(request.getEmail(), request.getNickname());
        List<User> users = this.userService.findByPredicate(predicate).stream()
                .map(this.mapper::dtoToDomain)
                .toList();

        return users.stream().map(this.mapper::domainToDto).toList();
    }

    public UserDto findById(Long id) {
        User user = userService.findById(id)
                .map(this.mapper::dtoToDomain)
                .orElseThrow(UserNotFoundException::new);

        return this.mapper.domainToDto(user);
    }
}
