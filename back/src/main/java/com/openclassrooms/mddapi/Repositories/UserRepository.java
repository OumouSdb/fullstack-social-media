package com.openclassrooms.mddapi.Repositories;

import com.openclassrooms.mddapi.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


  public User findByEmail( String email);

}
