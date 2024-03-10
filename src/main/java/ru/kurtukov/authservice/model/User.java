package ru.kurtukov.authservice.model;

import java.util.List;
import java.util.Objects;

public class User {
    private String login;
    private String password;
    private List<Authorities> authoritiesList;

    public User(String login, String password, List<Authorities> authoritiesList) {
        this.login = login;
        this.password = password;
        this.authoritiesList = authoritiesList;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public List<Authorities> getAuthoritiesList() {
        return authoritiesList;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAuthoritiesList(List<Authorities> authoritiesList) {
        this.authoritiesList = authoritiesList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(login, user.login) && Objects.equals(password, user.password) && Objects.equals(authoritiesList, user.authoritiesList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password, authoritiesList);
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", authoritiesList=" + authoritiesList +
                '}';
    }
}
