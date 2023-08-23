package org.dreamjob.service;

import org.dreamjob.model.User;
import org.dreamjob.repository.Sql2oUserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SimpleUserService implements UserService {

    private final Sql2oUserRepository sql2oUserRepository;

    public SimpleUserService(Sql2oUserRepository sql2oUserRepository) {
        this.sql2oUserRepository = sql2oUserRepository;
    }

    @Override
    public Optional<User> save(User user) {
        return sql2oUserRepository.save(user);
    }

    @Override
    public Optional<User> findByEmailAndPassword(String email, String password) {
        return sql2oUserRepository.findByEmailAndPassword(email, password);
    }
}
