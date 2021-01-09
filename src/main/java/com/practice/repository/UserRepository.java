package com.practice.repository;

import com.practice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import javax.transaction.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {


    User findUserByUsername(String username);

    @Transactional
    void deleteByUsername(String username);


    @Query("SELECT u FROM User u WHERE u.role.description='Manager'")
    List<User>  findAllManagers();

    List<User> findAllByRoleDescriptionIgnoreCase(String description);

}
