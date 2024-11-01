package ru.volobuev.course.dao;

import ru.volobuev.course.models.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();
    User findById(long id);
    void save(User user);
    void update(User user);
    void delete(long id);
}
