package com.example.mvc.repository;

import com.example.mvc.model.Gender;
import com.example.mvc.model.Role;
import com.example.mvc.model.User;
import com.example.mvc.util.IdGenerator;
import com.google.common.collect.Lists;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class UserRepository {

    private List<User> users;
    private IdGenerator idGenerator;
    private static UserRepository instance;

    private UserRepository() {
        this.idGenerator = new IdGenerator();
        this.users = initUsers();
    }

    public static UserRepository getInstance() {
        if (instance == null) {
            instance = new UserRepository();
        }
        return instance;
    }

    private List<User> initUsers() {
        List<User> result = Lists.newArrayList();
        result.add(new User(idGenerator.get(), "user", "user", Role.ROLE_USER, "Jan", "jan123@mail", LocalDate.of(1990, 5, 18), Gender.MALE, true));
        result.add(new User(idGenerator.get(), "user2", "user", Role.ROLE_USER, "Kazimierz", "kazimierski@mail", LocalDate.of(1985, 2, 20), Gender.MALE, true));
        result.add(new User(idGenerator.get(), "test", "test", Role.ROLE_USER, "Piotr", "piotr11@mail", LocalDate.of(1982, 2, 27), Gender.MALE, true));
        result.add(new User(idGenerator.get(), "admin", "admin", Role.ROLE_ADMIN, "Anna", "anna11@mail", LocalDate.of(1982, 8, 3), Gender.FEMALE, false));
        return result;
    }

    public List<User> getUsers() {
        return users;
    }

    public Optional<User> getUserById(Long id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst();
    }

    public Optional<User> getUserByLoginData(String login, String password) {
        return users.stream().filter(user -> userExists(login, password, user)).findFirst();
    }

    private boolean userExists(String login, String password, User user) {
        return user.getLogin().equals(login) && user.getPassword().equals(password);
    }
}
