package com.yas.backend.integration.domain.team;

import com.yas.backend.common.values.Schedule;
import com.yas.backend.config.InterceptorConfig;
import com.yas.backend.domain.team.exchange.TeamCreateRequest;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import javax.transaction.Transactional;

import static com.yas.backend.util.JsonUtils.toJson;
import static org.hamcrest.Matchers.instanceOf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@Transactional
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("local")
@DisplayName("Team command API 테스트")
@TestMethodOrder(MethodOrderer.MethodName.class)
class TeamCommandControllerTest {
    private MockMvc mockMvc;

    @Autowired
    public void setMockMvc(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Test
    @DisplayName("01. 팀 정상 생성")
    void _01_team_create_test() throws Exception {
        ResultActions result = mockMvc.perform(
                post("/api/team")
                        .header(InterceptorConfig.X_USER_ID, "1")
                        .content(toJson(
                                getMockTeamCreateRequest(1L)
                        ))
                        .contentType(MediaType.APPLICATION_JSON)
        );

        result.andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.teamId", instanceOf(Integer.class)));
    }

    @Test
    @DisplayName("02.1. ownerId가 없는 id일 경우")
    void _02_1_owner_id_is_not_exist() throws Exception {
        ResultActions result = mockMvc.perform(
                post("/api/team")
                        .header(InterceptorConfig.X_USER_ID, "1")
                        .content(toJson(
                                getMockTeamCreateRequest(Long.MAX_VALUE)
                        ))
                        .contentType(MediaType.APPLICATION_JSON)
        );

        result.andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    @DisplayName("03. 팀 삭제 정상 처리")
    void _03_team_remove_test() throws Exception {
        ResultActions result = mockMvc.perform(
                delete("/api/team/" + 1)
                        .header(InterceptorConfig.X_USER_ID, "1")
        );

        result.andDo(print())
                .andExpect(status().isOk());
    }

    TeamCreateRequest getMockTeamCreateRequest(Long ownerId) {
        return TeamCreateRequest.builder()
                .ownerId(ownerId)
                .name("테스트용 팀")
                .description("테스트")
                .maxUserCount(10L)
                .topic("테스트 토픽")
                .techStacks(Lists.newArrayList("스프링", "자바"))
                .schedule(Schedule.builder()
                        .place("테스트 장소")
                        .dayOfWeek("테스트 요일")
                        .time("테스트 시간")
                        .build())
                .build();
    }

}