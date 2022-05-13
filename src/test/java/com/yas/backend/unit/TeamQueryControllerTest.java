package com.yas.backend.unit;

import com.yas.backend.domain.team.controller.TeamQueryController;
import com.yas.backend.domain.team.service.TeamSearchService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("TeamQueryController unit test")
public class TeamQueryControllerTest {

    private MockMvc mockMvc;

    @Mock
    private TeamSearchService teamSearchService;

    @BeforeAll
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new TeamQueryController(teamSearchService)).build();
    }

    @Test
    @DisplayName("01. 팀 검색 API request binding test")
    void _01_team_search_api_request_binding_test() throws Exception {
        ResultActions result = mockMvc.perform(
                get("/api/teams?searchType=NAME&keywords=1,2,3&sortType=CREATED_AT&orderType=ASCEND&isFull=false&pageSize=10&pageNumber=1")
        );
    }
}
