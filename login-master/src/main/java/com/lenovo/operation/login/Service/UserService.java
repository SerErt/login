package com.lenovo.operation.login.DAO;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public User FindNameAndPwd(String username, String password) {
        return userDao.findByUsernameAndPassword(username, password);
    }
}


