package net.devtopia.demo.service;

import net.devtopia.demo.domain.Authentication;
import net.devtopia.demo.domain.User;
import net.devtopia.demo.domain.UserRepository;
import net.devtopia.demo.exception.NotExistingUserException;
import net.devtopia.demo.exception.WrongPasswordException;

// 2. 객체 생성
public class AuthService {
    private UserRepository userRepository;

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Authentication authenticate(String id, String password) {
        assertIdAndPassword(id, password);

        User user = findUserOrThrowEx(id);

        throwExIfPasswordIsWrong(password, user);

        return createAuthentication(user);
    }

    private void assertIdAndPassword(String id, String password) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException();
        }

        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private User findUserOrThrowEx(String id) {
        User user = getUserbyId(id);

        if (user == null) {
            throw new NotExistingUserException();
        }

        return user;
    }

    private void throwExIfPasswordIsWrong(String password, User user) {
        if (!user.matchPassword(password)) {
            throw new WrongPasswordException();
        }
    }

    private Authentication createAuthentication(User user) {
        return new Authentication(user.getId());
    }

    private User getUserbyId(String id) {
        return userRepository.findById(id);
    }
}
