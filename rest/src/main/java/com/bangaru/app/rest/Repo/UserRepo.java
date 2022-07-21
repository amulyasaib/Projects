package com.bangaru.app.rest.Repo;

import com.bangaru.app.rest.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepo extends JpaRepository<User, Long> {

}
