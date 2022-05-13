package com.yas.backend.domain.user.exchange.request;

public record UserSearchRequest(
        String email,
        String nickname
) {}
