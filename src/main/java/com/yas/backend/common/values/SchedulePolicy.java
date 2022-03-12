package com.yas.backend.common.values;

import com.yas.backend.common.enums.MeetingCycle;

import java.time.DayOfWeek;

public class SchedulePolicy {

    private MeetingCycle meetingCycle;
    private Integer times;
    private Integer dayOfWeek;

    @Override
    public String toString() {
        return this.meetingCycle + " "
                + this.times + "회, "
                + DayOfWeek.of(this.dayOfWeek).name();
    }
}
