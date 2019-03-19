package com.lenovo.operation.login.DAO;

import com.lenovo.operation.login.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserDao extends CrudRepository<User,Integer>{

    public User findByUsernameAndPassword(String username,String password);

}
