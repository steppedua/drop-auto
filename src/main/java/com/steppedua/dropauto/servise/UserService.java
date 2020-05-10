package com.steppedua.dropauto.servise;

import com.steppedua.dropauto.domain.User;
import com.steppedua.dropauto.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional //т.к класс работает с БД
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public void create(User user) {
        User user1 = new User();
        user1.setUsername(user.getUsername());
        user1.setPassword(user.getPassword());
        userRepository.save(user);
    }
}
