package com.onelogin.Oneloginapp.repo;

import com.onelogin.Oneloginapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
}
