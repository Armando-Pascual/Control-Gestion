package com.controlGestion.controlgestion.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/solicitud/**").hasRole("RECEPCION")
                .requestMatchers("/api/asignacion/**").hasRole("ASIGNADOR")
                .requestMatchers("/api/recepcion/**").hasRole("RECEPCION")
                .requestMatchers("/api/revision/**").hasRole("REVISION")
                .requestMatchers(HttpMethod.GET, "/api/solicitud/**").hasAnyRole("RECEPCION", "ASIGNADOR", "REVISION")

                .anyRequest().authenticated()
            )
            .httpBasic(Customizer.withDefaults()); 

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails recepcion = User.withUsername("recepcion")
            .password(passwordEncoder().encode("1234"))
            .roles("RECEPCION")
            .build();
        UserDetails asignador = User.withUsername("asignador")
            .password(passwordEncoder().encode("5678"))
            .roles("ASIGNADOR")
            .build();
       UserDetails revision = User.withUsername("revision")
            .password(passwordEncoder().encode("9999"))
            .roles("REVISION")
            .build();
     
        return new InMemoryUserDetailsManager(recepcion, asignador, revision);
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    
}
