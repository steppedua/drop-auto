package com.steppedua.dropauto.servise;

import com.steppedua.dropauto.domain.User;
import com.steppedua.dropauto.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Optional;

@Service
@Transactional
public class UserAuthService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserAuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    /*
    UserDetails предоставляет необходимую информацию для построения
    объекта Authentication из DAO объектов приложения или других
    источников данных системы безопасности
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> byUsername = userRepository.findByUsername(username);
        //если юзера не существует, тогда исключение

        if (!byUsername.isPresent()) {
            throw new UsernameNotFoundException("User not found");
        }

        //если юзер существует, тогда создаем роль обычного юзера
        return new org.springframework.security.core.userdetails.User(
                byUsername.get().getUsername(),
                byUsername.get().getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("USER"))
        );
    }
}
