package CRUD.dao;

import CRUD.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class UserDao {
    private final SessionFactory sessionFactory;

    @Autowired
    public UserDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public List<User> getUsers() {
    Session session = sessionFactory.getCurrentSession();
    return session.createQuery("select u from User u ", User.class).list();
    }

    @Transactional
    public void saveUser(User user) {
    sessionFactory.getCurrentSession().save(user);
    }

    @Transactional
    public void deleteUser(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.get(User.class, id));
    }

    @Transactional
    public void updateUser(int id,User UpdatedUser) {
    User user = sessionFactory.getCurrentSession().get(User.class, id);
    user.setName(UpdatedUser.getName());
    user.setSurname(UpdatedUser.getSurname());
    }

    @Transactional(readOnly = true)
    public User getUser(int id) {
        return sessionFactory.getCurrentSession().get(User.class, id);
    }
}
