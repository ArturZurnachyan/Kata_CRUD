package CRUD.dao;


import org.springframework.stereotype.Repository;
import CRUD.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;



import java.util.List;
import java.util.Objects;

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
    public void updateUser(User user, int id) {
        User newUser = entityManager.find(User.class, id);
        newUser.setName(user.getName());
        newUser.setSurname(user.getSurname());
        newUser.setEmail(user.getEmail());
        entityManager.merge(newUser);
    }

    @Override
    public User getUser(int id) {
        return entityManager.find(User.class, id);
    }
}
