package com.test.apigateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 跨域配置
 *
 * @Auther: zjc
 * @Date: 2020/1/16 15:15
 * @Description: C -Cross O -Origin R -Resource S -Sharing 跨域资源共享
 */
@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();

        config.setAllowCredentials(true);//是否支持cookie跨域
        config.setAllowedOrigins(Arrays.asList("*"));//放哪些原始域  http:www.a.com
        config.setAllowedHeaders(Arrays.asList("*"));
        config.setAllowedMethods(Arrays.asList("*"));//GET或 POST或 *
        config.setMaxAge(300l);//缓存时间 300秒

        source.registerCorsConfiguration("/**", config);

        return new CorsFilter(source);
    }

}
