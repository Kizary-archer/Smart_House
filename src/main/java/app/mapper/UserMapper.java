package app.mapper;

import app.dto.UserCreateDto;
import app.dto.UserDto;
import app.dto.UserUpdateDto;
import app.entities.User;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserMapper {

    @Mapping(target = "idUser", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "status", ignore = true)
    User map(UserCreateDto userCreateDto);

    @Mapping(target = "id", source = "idUser")
    @Mapping(source = "user.role.role", target = "role")
    @Mapping(source = "user.status.status", target = "status")
    UserDto map(User user);

    @Mapping(target = "idUser", source = "id")
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "status", ignore = true)
    User map(UserUpdateDto userUpdateDto);

    List<UserDto> map(List<User> users);
}
