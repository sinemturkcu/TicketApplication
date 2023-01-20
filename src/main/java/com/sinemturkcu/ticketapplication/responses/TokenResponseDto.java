package com.sinemturkcu.ticketapplication.responses;

import com.sinemturkcu.ticketapplication.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TokenResponseDto {
    private String accessToken;
    private UserDto userDto;
}
