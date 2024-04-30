package com.example.demo.config;

import org.springframework.context.annotation.Configuration;

@Configuration
/***
 * JWT 토큰을 생성, 서명, 변환을 관리하는 방법을 정의 -> JWTOAuth2Config
 */
public class JWTTokenStoreConfig {
    private ServiceConfig serviceConfig;
}
