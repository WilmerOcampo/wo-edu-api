package com.wo.edu.domain.service;

import com.wo.edu.domain.dto.SaveTeacher;
import com.wo.edu.domain.dto.SaveUser;
import com.wo.edu.domain.dto.UserDto;
import com.wo.edu.domain.repository.IUserDtoRepository;
import com.wo.edu.domain.response.RegisterResponse;
import com.wo.edu.persistence.entity.UserMaster;
import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {
    private final IUserDtoRepository userDtoRepository;

    @Override
    public List<UserDto> findAllUsers() {
        return userDtoRepository.findAllUsers();
    }

    @Override
    public Optional<UserDto> findById(Long id) {
        return userDtoRepository.findById(id);
    }

    @Override
    public RegisterResponse saveUser(SaveUser userDto) {
        String password = userDto.getPassword();
        try {
            String validationError = validatePassword(password);
            if (validationError != null) {
                return new RegisterResponse(validationError);
            }
            userDtoRepository.saveUser(userDto);
            return new RegisterResponse("Registro exitoso");
        } catch (ConstraintViolationException ex) {
            return new RegisterResponse(handleConstraintViolationException(ex));
        } catch (Exception e) {
            return new RegisterResponse(e.getLocalizedMessage());
        }
    }

    @Override
    public Boolean deleteById(Long id) {
        return findById(id).map(product -> {
            userDtoRepository.deleteById(id);
            return true;
        }).orElse(false);
    }

    @Override
    public List<UserDto> findAllTeachers() {
        return userDtoRepository.findAllTeachers();
    }

    @Override
    public RegisterResponse saveTeacher(SaveTeacher userDto) {
        String password = userDto.getPassword();
        try {
            String validationError = validatePassword(password);
            if (validationError != null) {
                return new RegisterResponse(validationError);
            }
            userDtoRepository.saveTeacher(userDto);
            return new RegisterResponse("Registro exitoso");
        } catch (ConstraintViolationException ex) {
            return new RegisterResponse(handleConstraintViolationException(ex));
        } catch (Exception e) {
            return new RegisterResponse(e.getLocalizedMessage());
        }
    }

    @Override
    public Optional<UserMaster> findByUsernameOrEmail(String username, String email) {
        return userDtoRepository.findByUsernameOrEmail(username, email);
    }

    private String validatePassword(String password) {
        if (password.isEmpty()) {
            return "Password no puede estar vacía";
        } else if (password.length() < 6) {
            return "Password debe tener al menos 6 caracteres";
        }
        return null;
    }

    private String handleConstraintViolationException(ConstraintViolationException ex) {
        List<String> errors = ex.getConstraintViolations().stream()
                .map(cv -> cv.getPropertyPath() + ": " + cv.getMessage())
                .toList();
        return "Error de validación: " + errors;
    }
}
