package CRUD.service;

import CRUD.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserService {
    public void addUser(User user);
    public void updateUser(User user,int id);
    public void deleteUser(int id);
    public User getUser(int id);
    public List<User> getAllUsers();
}
