package dao;

import model.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);

    void deleteUser(long id);

    void updateUser(long id, String firstname, String lastName, String email);

    List<User> listUsers();

}
