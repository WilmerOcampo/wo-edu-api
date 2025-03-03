package com.wo.edu.persistence.mapper;

import com.wo.edu.domain.dto.SaveTeacher;
import com.wo.edu.domain.dto.SaveUser;
import com.wo.edu.domain.dto.UserDto;
import com.wo.edu.persistence.entity.UserMaster;
import com.wo.edu.persistence.entity.role.Role;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface IUserMapper {
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "professions", ignore = true)
    UserDto toUserDto(UserMaster user);

    default Set<String> mapRoles(Set<Role> roles) {
        if (roles == null) {
            return null;
        }
        return roles.stream()
                .map(role -> role.getERole().name())
                .collect(Collectors.toSet());
    }

    List<UserDto> toUsersDto(List<UserMaster> users);

    @InheritInverseConfiguration
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "roles", ignore = true)
    UserMaster toUser(SaveUser userDto);

    UserMaster toUser(SaveTeacher userDto);
}
