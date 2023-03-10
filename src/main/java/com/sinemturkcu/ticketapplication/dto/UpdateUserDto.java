package com.sinemturkcu.ticketapplication.dto;

import com.sinemturkcu.ticketapplication.Entities.Enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserDto {
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;

}
