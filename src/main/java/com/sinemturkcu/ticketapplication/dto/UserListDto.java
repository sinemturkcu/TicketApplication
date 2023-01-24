package com.sinemturkcu.ticketapplication.dto;

import com.sinemturkcu.ticketapplication.Entities.Enums.Role;
import com.sinemturkcu.ticketapplication.Entities.User;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class UserListDto {
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    @Enumerated(EnumType.STRING)
    private Role role;

    public UserListDto(User user) {
        this.userName = user.getUsername();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.phoneNumber = user.getPhoneNumber();
        this.role = user.getRole();
    }
}
