package ru.kurtukov.authservice.service;

import ru.kurtukov.authservice.exception.InvalidCredentials;
import ru.kurtukov.authservice.exception.UnauthorizedUser;
import ru.kurtukov.authservice.model.Authorities;
import ru.kurtukov.authservice.repository.UserRepository;

import java.util.List;

public class AuthorizationService {
    UserRepository userRepository;

    public List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}
