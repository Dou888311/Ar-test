package com.Dou888311.ArtPlanTest.Repository;

import com.Dou888311.ArtPlanTest.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUsername(String username);
    Boolean existsByUsername(String username);
}
