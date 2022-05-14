package Springboard.boardservice.repository;

import Springboard.boardservice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User ,Long> {
    User findUserByEmail(String email);
}
