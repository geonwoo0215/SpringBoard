package Springboard.boardservice.dto;

import Springboard.boardservice.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {

    private Long id;
    private String username;
    private String password;
    private String email;

    @Builder
    public UserDto(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public User toEntity(){
        return User.builder()
                .username(username)
                .password(password)
                .email(email)
                .build();
    }
}
