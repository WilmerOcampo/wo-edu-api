package com.wo.edu.domain.service;

import com.wo.edu.domain.dto.SaveTeacher;
import com.wo.edu.domain.dto.SaveUser;
import com.wo.edu.domain.dto.UserDto;
import com.wo.edu.domain.response.RegisterResponse;
import com.wo.edu.persistence.entity.UserMaster;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    Optional<UserMaster> findByUsernameOrEmail(String username, String email);

    /*List<UserDto> findAllUsers();

    Optional<UserDto> findUserById(Long id);

    RegisterResponse saveUser(UserDto userDto);

    Boolean deleteUserById(Long id);

    List<TeacherDto> findAllTeachers();

    Optional<TeacherDto> findTeacherById(Long id);

    RegisterResponse saveTeacher(TeacherDto teacherDto);

    Boolean deleteTeacherById(Long id);*/
    List<UserDto> findAllUsers();

    List<UserDto> findAllTeachers();

    Optional<UserDto> findById(Long id);

    RegisterResponse saveUser(SaveUser userDto);

    RegisterResponse saveTeacher(SaveTeacher userDto);

    Boolean deleteById(Long id);
}
