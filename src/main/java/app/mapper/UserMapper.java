package app.mapper;

import app.dto.UserCreateDto;
import app.dto.UserDto;
import app.entities.User;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserMapper {

    @Mapping(target = "role", ignore = true)
    @Mapping(target = "status", ignore = true)
    User map(UserDto userDto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "status", ignore = true)
    User map(UserCreateDto userDto);

    @Mapping(source = "user.role.role", target = "role")
    @Mapping(source = "user.status.status", target = "status")
    @Mapping(target = "password", ignore = true)
    UserDto map(User user);

    List<UserDto> map(List<User> users);
}
