package CRUD.dao;

import CRUD.model.User;

import java.util.List;

public interface UserDao {
    List<User> getUsers();
    User getUser(int id);
    void saveUser(User user);
    void deleteUser(int id);
    void updateUser(User user);
}
