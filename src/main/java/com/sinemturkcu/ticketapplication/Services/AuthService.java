package com.sinemturkcu.ticketapplication.Services;


import com.sinemturkcu.ticketapplication.exception.GenericException;
import com.sinemturkcu.ticketapplication.requests.LoginRequest;
import com.sinemturkcu.ticketapplication.responses.TokenResponseDto;
import com.sinemturkcu.ticketapplication.util.TokenGenerator;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserService userService;
    private final TokenGenerator tokenGenerator;
    private final AuthenticationManager authenticationManager;

    public AuthService(UserService userService, TokenGenerator tokenGenerator, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.tokenGenerator = tokenGenerator;
        this.authenticationManager = authenticationManager;
    }

    public TokenResponseDto login(LoginRequest loginRequest) {
        try {
            Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    loginRequest.getUsername(), loginRequest.getPassword()));
            return TokenResponseDto.builder()
                    .accessToken(tokenGenerator.generateToken(auth))
                    .userDto(userService.getUser(loginRequest.getUsername())).build();
        }
        catch (Exception e){
            throw GenericException.builder()
                    .httpStatus(HttpStatus.NOT_FOUND)
                    .errorMessage("User not found").build();
        }
    }
}
