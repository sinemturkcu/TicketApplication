package com.sinemturkcu.ticketapplication.Services;

import com.sinemturkcu.ticketapplication.Entities.Enums.Role;
import com.sinemturkcu.ticketapplication.Entities.Ticket;
import com.sinemturkcu.ticketapplication.Entities.User;
import com.sinemturkcu.ticketapplication.Repositories.TicketRepository;
import com.sinemturkcu.ticketapplication.Repositories.UserRepository;
import com.sinemturkcu.ticketapplication.dto.UpdateUserDto;
import com.sinemturkcu.ticketapplication.dto.UserDto;
import com.sinemturkcu.ticketapplication.dto.UserDtoConverter;
import com.sinemturkcu.ticketapplication.dto.UserListDto;
import com.sinemturkcu.ticketapplication.exception.GenericException;
import com.sinemturkcu.ticketapplication.requests.RegisterRequest;
import com.sinemturkcu.ticketapplication.requests.UpdateUserRoleRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TicketRepository ticketRepository;


    // Admin can save user
    public void saveUser(User user){
        user.setPassword(passwordEncoder.encode((user.getPassword())));
        if(user.getRole()==null){
            user.setRole(Role.USER);
        }
        userRepository.save(user);
    }

    public String deleteUser(Long id) {
        User user = userRepository.getById(id);
        if (user == null) {
            return "User not found";
        }
        userRepository.delete(user);
        return "User deleted";
    }

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

    public List<UserListDto> getAllUsers(){
        List<User> users=userRepository.findAll();
        final Stream<UserListDto> listVMStream  = users.stream().map(UserListDto::new);
        return listVMStream.collect(java.util.stream.Collectors.toList());
    }

    public User getUser(Long id){
        return userRepository.findById(id).orElse(null);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User getUserByEmail (String email) {
        return userRepository.findByEmail(email);
    }

    public String updateUser(UpdateUserDto updateUserDto) {
        User user = userRepository.findByEmail(updateUserDto.getEmail());
        if (user == null) {
            return "User not found";
        }
        user.setFirstName(updateUserDto.getFirstName());
        user.setLastName(updateUserDto.getLastName());
        user.setPhoneNumber(updateUserDto.getPhoneNumber());
        userRepository.save(user);
        return "User updated";
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

