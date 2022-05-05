package com.yas.backend.config.session;

import com.yas.backend.domain.user.dto.UserDto;
import lombok.*;

@Getter
@ToString
@Builder(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class UserSession {
    private Long userId;
    private UserDto userDto;

    public void setUserInfo(Long userId, UserDto userDto) {
        this.userId = userId;
        this.userDto = userDto;
    }
}
