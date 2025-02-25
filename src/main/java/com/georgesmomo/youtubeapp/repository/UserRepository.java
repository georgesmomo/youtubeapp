package com.georgesmomo.youtubeapp.repository;

import com.georgesmomo.youtubeapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
