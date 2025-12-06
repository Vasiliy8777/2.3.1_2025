package service;


import model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);

    void removeUser(long id);

    void updateUser(long id, String firstname, String lastName, String email);

    void initUsers();

    List<User> listUsers();
}
