package com.latihanLsp.Repo;

import com.latihanLsp.Model.Product;
import com.latihanLsp.Model.User;

import java.util.List;

public interface UserRepo {
    User findByUsername(String username);
    List<User> getAllAccount();
    void updatePassword(User user);

    void save(User user);
}
