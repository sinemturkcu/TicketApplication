package com.sinemturkcu.ticketapplication.Services;

import com.sinemturkcu.ticketapplication.Entities.Role;
import com.sinemturkcu.ticketapplication.Entities.User;
import com.sinemturkcu.ticketapplication.Repositories.UserRepository;
import com.sinemturkcu.ticketapplication.dto.UserDto;
import com.sinemturkcu.ticketapplication.dto.UserDtoConverter;
import com.sinemturkcu.ticketapplication.exception.GenericException;
import com.sinemturkcu.ticketapplication.requests.RegisterRequest;
import com.sinemturkcu.ticketapplication.requests.UpdateUserRoleRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public UserDto createUser(RegisterRequest registerRequest){
        User user = User.builder()
                .username(registerRequest.getUsername())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .email(registerRequest.getEmail()).build();
        if (registerRequest.getRole().equalsIgnoreCase("USER")){
            user.setRole(Role.USER);
        }
        else if (registerRequest.getRole().equalsIgnoreCase("ADMIN")){
            user.setRole(Role.ADMIN);
        }
        else {
            throw new RuntimeException("Role not found!");
        }
        User savedUser = userRepository.save(user);

        return UserDtoConverter.convertToUserDto(savedUser);
    }

    public UserDto getUser(String username){
        var savedUser = findUserByUsername(username);
        return UserDtoConverter.convertToUserDto(savedUser);
    }

    public User findUserByUsername(String username){
        return userRepository.findByUsername(username)
                .orElseThrow(() -> GenericException.builder()
                        .httpStatus(HttpStatus.NOT_FOUND)
                        .errorMessage("User not found by given id!")
                        .build());
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public UserDto updateUserRole(UpdateUserRoleRequest request){
        User user = userRepository.findById(request.getUserId()).get();
        switch (request.getRole()) {
            case "USER" -> {
                user.setRole(Role.USER);

            }
            case "ADMIN" -> {
                user.setRole(Role.ADMIN);

            }
            default -> throw new RuntimeException("Role not found!");
        }
        return UserDtoConverter.convertToUserDto(userRepository.save(user));
    }
}

