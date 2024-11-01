package ru.volobuev.course.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Component;
import ru.volobuev.course.models.User;
import java.util.List;


@Component
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    public List<User> findAll() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    public User findById(long id) {
        try{
            TypedQuery<User> query = entityManager.createQuery(
                    "SELECT u FROM User u WHERE u.id = :id", User.class);
            return query.setParameter("id", id)
                    .getSingleResult();
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void save(User user) {
        entityManager.persist(user);
    }
    public void update(User user) {
        User userToBeUpdate = findById(user.getId());
        if(userToBeUpdate != null) {
            userToBeUpdate.setFirstName(user.getFirstName());
            userToBeUpdate.setLastName(user.getLastName());
            userToBeUpdate.setEmail(user.getEmail());
            userToBeUpdate.setAge(user.getAge());
            entityManager.merge(userToBeUpdate);
        }
    }
    public void delete(long id) {
        User user = findById(id);
        if(user != null) {
            entityManager.remove(user);
        }
    }
}
