package com.steppedua.dropauto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

@SpringBootApplication
public class DropAutoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DropAutoApplication.class, args);
    }


    //создание новой фабрики соединений Redis
    @Bean
    public RedisConnectionFactory factory() {
        return new LettuceConnectionFactory("localhost", 6379);
    }
}