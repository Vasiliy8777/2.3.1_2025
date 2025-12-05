package service;


import model.User;

import java.util.List;

public interface UserService {
    void add(User user);

    void del(long id);

    void update(long id, String firstname, String lastName, String email);

    void init();

    List<User> listUsers();
}
