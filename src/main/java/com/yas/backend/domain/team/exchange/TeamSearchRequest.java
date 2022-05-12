package com.yas.backend.domain.team.exchange;

import lombok.Getter;

import java.util.List;

@Getter
public class TeamSearchRequest {
    private String searchType;
    private List<String> keyword;
    private Long pageSize;
    private Long pageNumber;
    private String sortType;
    private Boolean isFull;
}
