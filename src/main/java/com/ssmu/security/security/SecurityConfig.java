package com.ssmu.security.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@Configuration
public class SecurityConfig {

    @Autowired
    private JwtRequestFilter jwtRequestFilter;;

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();

    }

    @Bean
    MvcRequestMatcher.Builder mvc(HandlerMappingIntrospector introspector) {
        return new MvcRequestMatcher.Builder(introspector);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, MvcRequestMatcher.Builder mvc) throws Exception {

        http
                .csrf(AbstractHttpConfigurer::disable)
                .headers(httpSecurityHeadersConfigurer -> {
                    httpSecurityHeadersConfigurer.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable);
                })

                .authorizeHttpRequests((authorize) -> authorize
                         .requestMatchers("/**").permitAll()

                        // .requestMatchers(mvc.pattern("/**"),
                        // mvc.pattern("/resources/**"))
                        // .permitAll()
                        // .requestMatchers("/api_v1/admin/**").hasRole("ADMIN")
                        // .requestMatchers("/api_v1/auth/**").permitAll()
                        // .requestMatchers("/api_v1/test/**").permitAll()
                        // .requestMatchers("/v2/api-docs/**").permitAll()
                        // .requestMatchers("/swagger-ui/**").permitAll()
                        // .requestMatchers("/v3/api-docs/**").permitAll()
                        // .requestMatchers("/api_v1/users/**").hasRole("ADMIN")
                        // .requestMatchers("/api_v1/categories/**").hasAnyRole("ADMIN", "MODERATOR")
                        // .requestMatchers("/api_v1/products/**").hasAnyRole("ADMIN","MODERATOR", "USER")
                        // .requestMatchers("/api_v1/stores/**").hasAnyRole("ADMIN", "USER")



                        
                        )
                // .anyRequest().authenticated())
                // .cors(Customizer.withDefaults())
                .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class)
                .sessionManagement((session) -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        // .csrf(AbstractHttpConfigurer::disable);

        // http.formLogin(Customizer.withDefaults());

        // http.httpBasic(Customizer.withDefaults());

        return http.build();

    }

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        System.out.println("authenticationConfiguration: " + authenticationConfiguration.toString());
        return authenticationConfiguration.getAuthenticationManager();
    }

}
