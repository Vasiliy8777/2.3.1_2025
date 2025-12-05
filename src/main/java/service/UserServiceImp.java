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
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    @Transactional
    public void del(long id) {
        userDao.del(id);
    }

    @Override
    @Transactional
    public void update(long id, String firstname, String lastName, String email) {
        userDao.update(id, firstname, lastName, email);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Override
    @Transactional
    public void init() {
        if (userDao.listUsers().isEmpty()) {
            userDao.add(new User("User1", "Lastname1", "user1@mail.ru"));
            userDao.add(new User("User2", "Lastname2", "user2@mail.ru"));
            userDao.add(new User("User3", "Lastname3", "user3@mail.ru"));
            userDao.add(new User("User4", "Lastname4", "user4@mail.ru"));
        }
    }


}
