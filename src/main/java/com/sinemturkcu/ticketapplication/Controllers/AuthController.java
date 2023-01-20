package com.sinemturkcu.ticketapplication.Controllers;

import com.sinemturkcu.ticketapplication.Services.AuthService;
import com.sinemturkcu.ticketapplication.Services.UserService;
import com.sinemturkcu.ticketapplication.dto.UserDto;
import com.sinemturkcu.ticketapplication.requests.LoginRequest;
import com.sinemturkcu.ticketapplication.requests.RegisterRequest;
import com.sinemturkcu.ticketapplication.responses.TokenResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;
    private final UserService userService;

    public AuthController(AuthService authService, UserService userService) {
        this.authService = authService;
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponseDto> login(@RequestBody LoginRequest loginRequest){
        return ResponseEntity.ok(authService.login(loginRequest));
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody RegisterRequest registerRequest){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userService.createUser(registerRequest));
    }
}