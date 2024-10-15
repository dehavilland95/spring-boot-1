package ru.volobuev.course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.volobuev.course.dao.UserDaoImpl;
import ru.volobuev.course.models.User;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDaoImpl dao;

    @Override
    public List<User> getAll() {

        return dao.findAll();
    }

    @Override
    public User getById(long id) {
        System.out.println();
        return dao.findById(id);
    }

    @Override
    public void save(User user) {
        dao.save(user);
    }

    @Override
    public void delete(long id) {
        dao.delete(id);
    }

    @Override
    public void update(long id, User user) {
        dao.update(id, user);
    }
}
