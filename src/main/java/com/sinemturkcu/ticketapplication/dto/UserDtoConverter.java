package com.sinemturkcu.ticketapplication.dto;

import com.sinemturkcu.ticketapplication.Entities.Enums.Role;
import com.sinemturkcu.ticketapplication.Entities.User;

public class UserDtoConverter {
    public static UserDto convertToUserDto(User user){
        if (user.getRole() == Role.ADMIN){
            return UserDto.builder()
                    .id(user.getId())
                    .username(user.getUsername())
                    .email(user.getEmail())
                    .role(user.getRole()).build();
        }
        else{
            return UserDto.builder()
                    .id(user.getId())
                    .username(user.getUsername())
                    .email(user.getEmail())
                    .role(user.getRole()).build();
        }
    }
}
