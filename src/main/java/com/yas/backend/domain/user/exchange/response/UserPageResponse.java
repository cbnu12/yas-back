package com.yas.backend.domain.user.exchange.response;

import com.yas.backend.domain.user.dto.UserDto;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@Builder
public class UserPageResponse {
    private long totalCount;
    private int pageSize;
    private int currentPage;
    private List<UserResponse> list;

    public static UserPageResponse from(Page<UserDto> user) {
        return UserPageResponse.builder()
                .totalCount(user.getTotalElements())
                .pageSize(user.getSize())
                .currentPage(user.getNumber())
                .list(user.getContent().stream().map(UserResponse::from).toList())
                .build();
    }
}
