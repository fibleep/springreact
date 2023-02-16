package com.book.springreact.persistance;

import org.springframework.data.repository.CrudRepository;
import com.book.springreact.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
   User findByUsername(String username);
}

