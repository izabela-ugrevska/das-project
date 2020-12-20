package mk.finki.das.rotax.service;

import mk.finki.das.rotax.model.User;

import java.util.Set;

public interface UserService {

    Set<User> findAll();

    User findById(Long id);

    User saveUser(User user);

    void deleteById(Long id);

}
