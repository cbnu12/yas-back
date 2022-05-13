package com.yas.backend.domain.team.exchange;

import com.yas.backend.common.values.OrderType;
import com.yas.backend.common.values.SearchType;
import com.yas.backend.common.values.SortType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TeamSearchRequest {
    private SearchType searchType;
    private List<String> keywords;
    private SortType sortType;
    private OrderType orderType;
    private Boolean isFull;
}
