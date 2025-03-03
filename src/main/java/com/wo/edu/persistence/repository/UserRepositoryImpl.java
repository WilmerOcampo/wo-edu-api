package com.wo.edu.persistence.repository;

import com.wo.edu.domain.dto.SaveTeacher;
import com.wo.edu.domain.dto.SaveUser;
import com.wo.edu.domain.dto.UserDto;
import com.wo.edu.domain.repository.IUserDtoRepository;
import com.wo.edu.persistence.entity.UserMaster;
import com.wo.edu.persistence.entity.course.Teacher;
import com.wo.edu.persistence.entity.role.enums.ERole;
import com.wo.edu.persistence.mapper.IUserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements IUserDtoRepository {
    private final IUserMasterRepository userMasterRepository;
    private final IUserRepository userRepository;
    private final ITeacherRepository teacherRepository;
    private final IRoleRepository roleRepository;
    private final IProfessionRepository professionRepository;
    private final IUserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<UserDto> findAllUsers() {
        List<UserMaster> users = userMasterRepository.findByRoleName(ERole.USER);
        return userMapper.toUsersDto(users);
    }

    @Override
    public List<UserDto> findAllTeachers() {
        List<UserMaster> teachers = userMasterRepository.findByRoleName(ERole.TEACHER);
        return userMapper.toUsersDto(teachers);
    }

    @Override
    public Optional<UserDto> findById(Long id) {
        return userMasterRepository.findById(id).map(userMapper::toUserDto);
    }

    @Override
    @Transactional
    public UserDto saveUser(SaveUser userDto) {
        UserMaster user = userMapper.toUser(userDto);
        encodeAndSetPassword(user, userDto.getPassword());

        user.setRoles(roleRepository.findByIdIn(userDto.getRoleIds()));
        return userMapper.toUserDto(userMasterRepository.save(user));
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    @Transactional
    public UserDto saveTeacher(SaveTeacher userDto) {
        UserMaster userMaster = userMapper.toUser(userDto);
        encodeAndSetPassword(userMaster, userDto.getPassword());

        Teacher teacher = new Teacher();

        teacher.setProfessions(professionRepository.findByIdIn(userDto.getProfessionIds()));
        userMaster.setRoles(roleRepository.findByIdIn(userDto.getRoleIds()));
        teacherRepository.save(teacher);
        return userMapper.toUserDto(userMasterRepository.save(userMaster));
    }

    @Override
    public Optional<UserMaster> findByUsernameOrEmail(String username, String email) {
        return userMasterRepository.findByUsernameOrEmail(username, email);
    }

    private void encodeAndSetPassword(UserMaster user, String rawPassword) {
        user.setPassword(passwordEncoder.encode(rawPassword));
    }
}
