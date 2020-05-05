package com.steppedua.dropauto.config;

import com.steppedua.dropauto.servise.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)//для разделения на админ и юзер
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailsService userDetailsService;

    // шифрование в 10 символов
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder(10);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                        .antMatchers("/", "/login", "/registration").permitAll() //эти странички доступны для неавторизованных пользователей
                        .anyRequest().authenticated() //остальные запросы требуют аутентификации
                .and()
                        .formLogin()
                        .loginPage("/login") // страница для входа
                        .defaultSuccessUrl("/") //сюда закинет после входа
                        .permitAll() //доступно для всех
                .and()
                        .rememberMe() //для запомонания сессии user (вроде бы на 14 дней)
                .and()
                        .logout()
                        .logoutUrl("/logout") // ссылка для выхода
                        .logoutSuccessUrl("/") // сюда закинет после выхода
                        .permitAll(); //доступно для всех
    }


    /*
    ----------------------Пометка для себя-----------------
    Интерфейс UserDetailsService используется для получения пользовательских данных.
    Он имеет один метод с именем loadUserByUsername (), который может быть
    переопределен для настройки процесса поиска пользователя.
     */

    //расхеширование паролей
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(encoder());
    }
}
