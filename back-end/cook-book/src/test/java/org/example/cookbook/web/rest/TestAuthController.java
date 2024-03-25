package org.example.cookbook.web.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.cookbook.model.dto.user.LoginForm;
import org.example.cookbook.model.dto.user.LoginResponse;
import org.example.cookbook.model.dto.user.UserDto;
import org.example.cookbook.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TestAuthController {
    @MockBean
    private UserService userService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void loginTest() throws Exception {
        final String email = "ivan@abv.bg";

        final UserDto user = new UserDto(1L, "Ivan", "Ivanov", email);

        final LoginForm loginForm = new LoginForm(email, "123");

        final String requestJson = new ObjectMapper().writeValueAsString(loginForm);

        when(userService.login(any())).thenReturn(new LoginResponse(user, HttpStatus.OK));

        mockMvc.perform(MockMvcRequestBuilders.post("/api/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.email", is(email)));
    }
}
