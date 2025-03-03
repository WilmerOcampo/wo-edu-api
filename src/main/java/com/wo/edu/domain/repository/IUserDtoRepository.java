package com.wo.edu.domain.repository;

import com.wo.edu.domain.dto.SaveTeacher;
import com.wo.edu.domain.dto.SaveUser;
import com.wo.edu.domain.dto.UserDto;
import com.wo.edu.persistence.entity.UserMaster;

import java.util.List;
import java.util.Optional;

public interface IUserDtoRepository {
    Optional<UserMaster> findByUsernameOrEmail(String username, String email);

    /*List<UserDto> findAllUsers();

    Optional<UserDto> findUserById(Long id);

    UserDto saveUser(UserDto userDto);

    void deleteUserById(Long id);

    List<TeacherDto> findAllTeachers();

    Optional<TeacherDto> findTeacherById(Long id);

    TeacherDto saveTeacher(TeacherDto teacherDto);

    void deleteTeacherById(Long id);*/

    List<UserDto> findAllUsers();

    List<UserDto> findAllTeachers();

    Optional<UserDto> findById(Long id);

    UserDto saveUser(SaveUser userDto);

    UserDto saveTeacher(SaveTeacher userDto);

    void deleteById(Long id);

    /*Optional<UserData> findTeacherById(Long id);

    void deleteTeacherById(Long id);*/
}
