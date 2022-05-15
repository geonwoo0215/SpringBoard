package Springboard.boardservice.service;

import Springboard.boardservice.domain.User;
import Springboard.boardservice.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    BoardService boardService;
    @Autowired
    UserRepository userRepository;

    @Test
    void 회원_가입(){

        User user = User.builder()
                .username("mins")
                .password("1234")
                .email("email")
                .build();

        Long joinId = boardService.join(user);

        Assertions.assertEquals(user, userRepository.findOne(joinId));
    }
}
