package com.smart_house.mapper;

import com.smart_house.dto.UserDto;
import com.smart_house.entities.User;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    @Mapping(target = "registrationDate", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "status", ignore = true)
    User map(UserDto userDto);

    @Mapping(source = "user.role.role", target = "role")
    @Mapping(source = "user.status.status", target = "status")
    @Mapping(target = "password", qualifiedByName = "passwordToDto")
    UserDto map(User user);

    List<UserDto> map(List<User> users);

    @Named("passwordToDto")
    static String passwordToDto(String password) {
        return "";
    }
}
