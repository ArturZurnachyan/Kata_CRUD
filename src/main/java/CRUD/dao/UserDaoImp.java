package CRUD.dao;


import org.springframework.stereotype.Repository;
import CRUD.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;



import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;



    @Override
    public List<User> getUsers() {
    return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public void saveUser(User user) {
    entityManager.persist(user);
    }

    @Override
    public void deleteUser(int id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

    @Override
    public void updateUser(User user) {
    entityManager.merge(user);
    }

    @Override
    public User getUser(int id) {
        return entityManager.find(User.class, id);
    }
}
