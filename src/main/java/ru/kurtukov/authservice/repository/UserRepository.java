package ru.kurtukov.authservice.repository;

import org.springframework.stereotype.Repository;
import ru.kurtukov.authservice.model.Authorities;
import ru.kurtukov.authservice.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class UserRepository {
    public List<Authorities> getUserAuthorities(String user, String password) {
        List<Authorities> authoritiesList = new ArrayList<>();

        // Список пользователей и их прав
        HashMap<String, User> users = new HashMap<>();
        users.put("admin", new User("admin", "admin", List.of(Authorities.READ, Authorities.WRITE, Authorities.DELETE)));
        users.put("pavel", new User("pavel", "pavel", List.of(Authorities.READ, Authorities.WRITE, Authorities.DELETE)));
        users.put("user", new User("user", "user", List.of(Authorities.READ, Authorities.WRITE)));
        users.put("guest", new User("guest", "guest", List.of(Authorities.READ)));

        // Проверка наличия пользователя, а также логина и пароля
        if (users.containsKey(user)) {
            User checkUser = users.get(user);
            if (checkUser.getPassword().equals(password)) {
                authoritiesList = checkUser.getAuthoritiesList();
            }
        }

        return authoritiesList;
    }
}