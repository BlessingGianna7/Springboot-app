package com.Repo;
import com.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

    public interface  UserRepo extends JpaRepository<User, Long>{

    }

