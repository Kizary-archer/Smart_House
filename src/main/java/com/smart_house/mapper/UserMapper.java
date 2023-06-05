package com.smart_house.mapper;

import com.smart_house.dto.UserDto;
import com.smart_house.entities.User;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface UserMapper {

    @Mapping(target = "registrationDate", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "status", ignore = true)
    User map(UserDto userDto);

    @Mapping(source = "user.role.role", target = "role")
    @Mapping(source = "user.status.status", target = "status")
    @Mapping(target = "password", ignore = true)
    UserDto map(User user);

    List<UserDto> map(List<User> users);

}
