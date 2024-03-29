package com.sinemturkcu.ticketapplication.config;

import com.sinemturkcu.ticketapplication.security.JwtAccessDeniedHandler;
import com.sinemturkcu.ticketapplication.security.JwtAuthenticationEntryPoint;
import com.sinemturkcu.ticketapplication.security.JwtFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    private final JwtFilter jwtFilter;
    private final JwtAccessDeniedHandler accessDeniedHandler;
    private final JwtAuthenticationEntryPoint authenticationEntryPoint;

    public SecurityConfig(JwtFilter jwtFilter, JwtAccessDeniedHandler accessDeniedHandler, JwtAuthenticationEntryPoint authenticationEntryPoint) {
        this.jwtFilter = jwtFilter;
        this.accessDeniedHandler = accessDeniedHandler;
        this.authenticationEntryPoint = authenticationEntryPoint;
    }

    @Bean
    public AuthenticationManager authenticationManager(final AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf().disable()
                .cors().and()
                .authorizeHttpRequests((auth) -> {
                    /*

                     */
                    auth.antMatchers("/api/user/getAll").hasAnyAuthority("ADMIN");
                    auth.antMatchers("/api/vehicle/getVehicle/**").permitAll();
                    auth.antMatchers("/api/user/saveUser").hasAnyAuthority("ADMIN");
                    auth.antMatchers("/api/vehicle/saveVehicle").hasAnyAuthority("ADMIN");
                    auth.antMatchers("/api/vehicle/getAll").hasAnyAuthority("ADMIN");
                    auth.antMatchers("/api/ticket/getNotNullTickets").permitAll();
                    auth.antMatchers("/api/user/deleteUser/**").permitAll();
                    auth.antMatchers("/api/user/getUser/{id}").hasAnyAuthority("ADMIN");
                    auth.antMatchers("/api/user/getUserByEmail/").hasAnyAuthority("ADMIN");
                    auth.antMatchers("/api/user/updateUser").hasAnyAuthority("ADMIN","USER");
                    auth.antMatchers("/api/route/delete").hasAnyAuthority("ADMIN");
                    auth.antMatchers("/api/route/update").hasAnyAuthority("ADMIN");
                    auth.antMatchers("/api/route/save").hasAnyAuthority("ADMIN");
                    auth.antMatchers("/api/route/getAll").permitAll();
                    auth.antMatchers("/api/vehicle/delete/**").permitAll();
                    auth.antMatchers("/api/vehicle/update").hasAnyAuthority("ADMIN");
                    auth.antMatchers("/api/vehicle/getVehicle").hasAnyAuthority("ADMIN");
                    auth.antMatchers("/api/ticket/getByEmail").hasAnyAuthority("ADMIN");
                    auth.antMatchers("/api/ticket/getAll").permitAll();
                    auth.antMatchers("/api/ticket/buy").hasAnyAuthority("ADMIN","USER");
                    auth.antMatchers("/api/ticket/cancel/{id}").hasAnyAuthority("ADMIN","USER");
                    auth.antMatchers("/api/ticket/delay").hasAnyAuthority("ADMIN","USER");
                    auth.antMatchers("/api/ticket/filterByStatus").hasAnyAuthority("ADMIN");
                    auth.antMatchers("/api/ticket/save/{id}").hasAnyAuthority("ADMIN");
                    auth.antMatchers("/api/auth/user").hasAnyAuthority("ADMIN", "USER");
                    auth.antMatchers("/v2/api-docs").hasAnyAuthority("ADMIN","USER");
                    auth.anyRequest().authenticated();
                })
                .formLogin().disable()
                .httpBasic().disable()
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler)
                .authenticationEntryPoint(authenticationEntryPoint).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer(){
        return (web -> web.ignoring().antMatchers("/api/auth/login", "/api/auth/register","/v2/api-docs"));
    }

    @Bean
    public WebMvcConfigurer configurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedMethods("*");
            }
        };
    }
}
