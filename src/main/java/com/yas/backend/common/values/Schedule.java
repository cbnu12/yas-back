package com.yas.backend.common.values;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Schedule {
    private String place;
    private String dayOfWeek;
    private String time;
}
