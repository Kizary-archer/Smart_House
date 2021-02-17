import app.dto.UserDto;
import app.entities.User;
import app.entities.UserRole;
import app.entities.UserStatus;
import app.mapper.UserMapper;
import app.mapper.UserMapperImpl;
import app.repository.RoleRepository;
import app.repository.StatusRepository;
import app.repository.UserRepository;
import app.services.UserService;
import app.services.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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
    void beforeAllTests() {
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
        assertNotNull(userService.getUserByLogin("user1"));
        assertEquals(user.getLogin(), userService.getUserByLogin("user1").getLogin());
    }

    @Test
    void getUserById() {
        when(userRepositoryMock.findById(anyInt())).thenReturn(Optional.of(user));
        assertNotNull(userService.getUserById(1));
        assertEquals(userService.getUserById(1).getId(),user.getId());
    }

    @Test
    void getAllUsers() {
        when(userRepositoryMock.findAll()).thenReturn(users);
        assertNotNull(userService.getAllUsers());
        assertEquals(userService.getAllUsers(),userMapper.map(users));
    }

    @Test
    void createUser() {
        when(userRepositoryMock.save(any())).thenReturn(user);
        when(roleRepositoryMock.findByRole(anyString())).thenReturn(Optional.of(userRole));
        when(statusRepositoryMock.findByStatus(anyString())).thenReturn(Optional.of(userStatus));
        when(passwordEncoderMock.encode(any())).thenReturn("scans");
        UserDto userDto = new UserDto(1,"aaa","aaa","sss","sss");
        assertEquals(userService.createUser(userDto), Optional.of(userMapper.map(user)));
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