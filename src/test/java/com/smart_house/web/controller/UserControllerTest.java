package com.smart_house.web.controller;

import com.smart_house.config.MockSpringSecurityTestConfiguration;
import com.smart_house.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
@Import(MockSpringSecurityTestConfiguration.class)
@WithMockUser
class UserControllerTest {
    MockMvc mockMvc;
    @MockBean
    UserService userService;

    @Autowired
    UserController userController;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    void getUserById() {
    }

    @Test
    void getUserByLogin() {
    }

    @Test
    void getAllUsers() throws Exception {
        mockMvc.perform(get("/users")
                        .contentType("application/json"))
                .andExpect(status().isOk());
    }

    @Test
    void createUser() {
    }

    @Test
    void updateUser() {
    }

    @Test
    void deleteUser() {
    }
}