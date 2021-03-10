package com.smart_house.config;

import com.smart_house.entities.UserRole;
import com.smart_house.security.AuthorizedUser;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@TestConfiguration
public class MockSpringSecurityTestConfiguration {

    @MockBean
    UserDetailsService userDetailsService;

    @Bean
    public UserDetailsService userDetailsService() {
        when(userDetailsService.loadUserByUsername(anyString()))
                .thenReturn(new AuthorizedUser(1, "username", "password", Collections.singleton(new UserRole())));

        return userDetailsService;
    }
}
