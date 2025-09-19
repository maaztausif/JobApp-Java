package com.maaz.JobApp_Java.repo;

import com.maaz.JobApp_Java.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {

   User findByusername(String username);
}
