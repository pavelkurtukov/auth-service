package ru.kurtukov.authservice.repository;

import org.springframework.stereotype.Repository;
import ru.kurtukov.authservice.model.Authorities;

import java.util.List;

@Repository
public class UserRepository {
    public List<Authorities> getUserAuthorities(String user, String password) {
        return null;
    }
}