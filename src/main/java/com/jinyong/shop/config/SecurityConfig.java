package com.jinyong.shop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.csrf(csrf -> csrf.disable()); // CSRF 보호 비활성화 (개발 편의를 위해 일단 비활성화)

        // 1. 페이지 접근 권한 설정 (인가, Authorization) - 최신 문법 적용
        http.authorizeHttpRequests(authorize -> authorize
                // 정적 리소스 및 회원 관련 경로는 인증 없이 누구나 접근 허용
                .requestMatchers("/css/**", "/js/**", "/img/**", "/members/**", "/")
                .permitAll()

                // ADMIN 권한을 가진 사용자만 접근 가능한 경로
                .requestMatchers("/admin/**")
                .hasRole("ADMIN")

                // 위에서 설정한 경로를 제외한 나머지 모든 요청은 반드시 인증(로그인)을 해야 접근 가능
                .anyRequest()
                .authenticated()
        );

        // 2. 로그인 설정 (Authentication)
        http.formLogin(formLogin -> formLogin
                .loginPage("/members/login")          // 커스텀 로그인 페이지 URL 설정
                .defaultSuccessUrl("/")               // 로그인 성공 시 이동할 URL
                .usernameParameter("email")           // 로그인 시 사용할 아이디 파라미터 이름 (기본값: username)
                .failureUrl("/members/login/error")   // 로그인 실패 시 이동할 URL
        );

        // 3. 로그아웃 설정
        http.logout(logout -> logout
                .logoutUrl("/members/logout")           // 로그아웃 URL 설정 (POST 요청)
                .logoutSuccessUrl("/")              // 로그아웃 성공 시 이동할 URL
                .invalidateHttpSession(true)        // HTTP 세션 무효화
        );

        // 4. 인증되지 않은 사용자 접근 시 예외 처리 (CustomAuthenticationEntryPoint는 별도 구현 필요)
        // http.exceptionHandling(exceptionHandling -> exceptionHandling
        //     .authenticationEntryPoint(new CustomAuthenticationEntryPoint())
        // );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
