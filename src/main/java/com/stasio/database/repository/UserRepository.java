package com.stasio.database.repository;

import com.stasio.database.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {
    User getUserByName(String name);

    User getUserById(Long id);


}
