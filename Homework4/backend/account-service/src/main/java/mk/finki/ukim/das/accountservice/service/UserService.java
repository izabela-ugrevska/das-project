package mk.finki.ukim.das.accountservice.service;

import mk.finki.ukim.das.accountservice.model.User;

import java.util.Set;

public interface UserService {

    Set<User> findAll();

    User findById(Long id);

    User saveUser(User user);

    void deleteById(Long id);

}
