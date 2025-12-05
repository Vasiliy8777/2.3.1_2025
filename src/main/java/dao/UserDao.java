package dao;

import model.User;

import java.util.List;

public interface UserDao {
    void add(User user);

    void del(long id);

    void update(long id, String firstname, String lastName, String email);

    List<User> listUsers();

}
