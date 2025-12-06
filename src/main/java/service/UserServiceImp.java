package service;

import dao.UserDao;
import model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private final UserDao userDao;

    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    @Transactional
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    @Transactional
    public void removeUser(long id) {
        userDao.deleteUser(id);
    }

    @Override
    @Transactional
    public void updateUser(long id, String firstname, String lastName, String email) {
        userDao.updateUser(id, firstname, lastName, email);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Override
    @Transactional
    public void initUsers() {
        if (userDao.listUsers().isEmpty()) {
            userDao.addUser(new User("User1", "Lastname1", "user1@mail.ru"));
            userDao.addUser(new User("User2", "Lastname2", "user2@mail.ru"));
            userDao.addUser(new User("User3", "Lastname3", "user3@mail.ru"));
            userDao.addUser(new User("User4", "Lastname4", "user4@mail.ru"));
        }
    }


}
