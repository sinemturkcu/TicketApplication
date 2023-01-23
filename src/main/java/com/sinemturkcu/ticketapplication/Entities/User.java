package com.sinemturkcu.ticketapplication.Entities;

import com.sinemturkcu.ticketapplication.Entities.Enums.Role;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;
    private String firstName;
    private String lastName;
    private String phoneNumber;


}
