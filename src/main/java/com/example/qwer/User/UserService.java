package com.example.qwer;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    } // 의존성 주입


    public User createUser(User user) {
        User curUser = new User();
        curUser.setUsername(user.getUsername());
        curUser.setEmail(user.getEmail());
        return userRepository.save(curUser);
    }

    public String deleteUser(Long id) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("유저를 찾을 수 없습니다."));
        userRepository.delete(existingUser);

        return "삭제 완료";
    }
    public User getUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("유저를 찾을 수 없습니다."));
    }


}
