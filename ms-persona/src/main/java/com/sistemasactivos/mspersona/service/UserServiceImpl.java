package com.sistemasactivos.mspersona.service;

import com.sistemasactivos.mspersona.model.User;
import com.sistemasactivos.mspersona.repository.BaseRepository;
import com.sistemasactivos.mspersona.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, Long> {
    public UserServiceImpl(BaseRepository<User, Long> baseRepository) {
        super(baseRepository);
    }

    public Optional<User> findByEmail(String email) {
        return ((UserRepository) baseRepository).findOneByEmail(email);
    }
}
