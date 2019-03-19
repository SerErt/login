package com.lenovo.operation.login.Service;

import com.lenovo.operation.login.entity.User;
import com.lenovo.operation.login.DAO.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public User FindNameAndPswd(String username, String password) {
        return userDao.findByUsernameAndPassword(username, password);
    }

}
