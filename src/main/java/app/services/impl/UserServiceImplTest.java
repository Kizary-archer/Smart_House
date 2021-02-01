package app.services.impl;

import app.dto.UserCreateDto;
import app.entities.User;
import app.entities.UserRole;
import app.entities.UserStatus;
import app.mapper.UserMapper;
import app.mapper.UserMapperImpl;
import app.repository.RoleRepository;
import app.repository.StatusRepository;
import app.repository.UserRepository;
import app.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepositoryMock;
    @Mock
    private RoleRepository roleRepositoryMock;
    @Mock
    private StatusRepository statusRepositoryMock;
    @Mock
    private PasswordEncoder passwordEncoderMock;
    private UserService userService;
    private final UserMapper userMapper = new UserMapperImpl();

    private List<User> users = new LinkedList<>();
    private User user;
    private UserRole userRole;
    private UserStatus userStatus;

    @BeforeEach
    void beforeAllTests() throws Throwable {
        userService = new UserServiceImpl(userRepositoryMock, roleRepositoryMock, statusRepositoryMock,userMapper, passwordEncoderMock);
        userRole = new UserRole().setRole("role");
        userStatus = new UserStatus().setStatus("status");
        users = IntStream.rangeClosed(1, 10)
                .mapToObj(id -> new User()
                        .setId(id)
                        .setLogin("user" +id)
                        .setPassword("scans")
                        .setStatus(userStatus)
                        .setRole(userRole))
                .collect(Collectors.toList());
        user = users.get(0);
    }

    @Test
    void getUserByLogin() {
        when(userRepositoryMock.findByLogin(anyString())).thenReturn(Optional.of(user));
        assertTrue(userService.getUserByLogin("user1").isPresent());
        assertEquals(userService.getUserByLogin("user1").get().getLogin(),user.getLogin());
    }

    @Test
    void getUserById() {
        when(userRepositoryMock.findById(anyInt())).thenReturn(Optional.of(user));
        assertTrue(userService.getUserById(1).isPresent());
        assertEquals(userService.getUserById(1).get().getId(),user.getId());
    }

    @Test
    void getAllUsers() {
        when(userRepositoryMock.findAll()).thenReturn(users);
        assertTrue(userService.getAllUsers().isPresent());
        assertEquals(userService.getAllUsers(),Optional.of(userMapper.map(users)));
    }

    @Test
    void createUser() {
        when(userRepositoryMock.save(any())).thenReturn(user);
        when(roleRepositoryMock.findByRole(anyString())).thenReturn(Optional.of(userRole));
        when(statusRepositoryMock.findByStatus(anyString())).thenReturn(Optional.of(userStatus));
        when(passwordEncoderMock.encode(any())).thenReturn("scans");
        UserCreateDto userCreateDto = new UserCreateDto("aaa","aaa",new Timestamp(123124124L),"sss","sss");
        assertEquals(userService.createUser(userCreateDto), Optional.of(userMapper.map(user)));
    }

    @Test
    void deleteUserById() {
        doNothing().when(userRepositoryMock).deleteById(anyInt());

        userService.deleteUserById(1);
        verify(userRepositoryMock).deleteById(1);
    }

    @Test
    void updateUser() {
        when(userRepositoryMock.save(any())).thenReturn(user);
        when(roleRepositoryMock.findByRole(anyString())).thenReturn(Optional.of(userRole));
        when(statusRepositoryMock.findByStatus(anyString())).thenReturn(Optional.of(userStatus));
        when(passwordEncoderMock.encode(any())).thenReturn("scans");
        assertEquals(userService.updateUser(userMapper.map(user)), Optional.of(userMapper.map(user)));
    }
}