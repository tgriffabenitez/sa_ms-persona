package com.sistemasactivos.mspersona.repository;

import com.sistemasactivos.mspersona.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends BaseRepository<User, Long>{
    Optional<User> findOneByEmail(String email);
}
