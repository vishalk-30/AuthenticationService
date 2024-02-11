package org.scaler.userloginservice.repository;

import org.scaler.userloginservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
     User findUserByEmail(String email);
}
