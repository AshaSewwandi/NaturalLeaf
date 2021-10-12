package com.webapplication.rest.Repo;

import  com.webapplication.rest.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Users, Long>{

}
