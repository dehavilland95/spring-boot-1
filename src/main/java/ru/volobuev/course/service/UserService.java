package ru.volobuev.course.service;

import ru.volobuev.course.models.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User getById(long id);
    void save(User user);
    void delete(long id);
    void update(User user);
}
