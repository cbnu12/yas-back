package com.yas.backend.common.interceptor;

import com.yas.backend.common.exception.UserNotFoundException;
import com.yas.backend.config.session.UserSession;
import com.yas.backend.domain.user.dto.UserDto;
import com.yas.backend.domain.user.service.domainservice.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class UserSessionInterceptor implements HandlerInterceptor {

    private static final String X_USER_ID = "X-USER-ID";
    private final UserSession userSession;
    private final UserService userService;

    public UserSessionInterceptor(UserSession userSession, UserService userService) {
        this.userSession = userSession;
        this.userService = userService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String rawUserId = request.getHeader(X_USER_ID);

        if(StringUtils.isBlank(rawUserId)) {
            return false;
        }

        try {
            Long userId = Long.valueOf(rawUserId);
            UserDto userDto = userService.findById(userId);
            userSession.setUserInfo(userId, userDto);
        } catch (NumberFormatException e) {
            return false;
        } catch (UserNotFoundException e) {
            return true;
        }

        return true;
    }
}
