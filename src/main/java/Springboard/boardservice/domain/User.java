package Springboard.boardservice.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "user")
public class User {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @NotBlank(message = "아이디를 입력해주세요")
    @Pattern(regexp = "^[a-zA-Z0-9]{3,12}$", message = "아이디를 3~12자로 입력해주세요,")
    private String username;

//    @NotBlank(message = "비밀번호를 입력해주세요.")
//    @Pattern(regexp = "^[a-zA-Z0-9]{3,12}$", message = "비밀번호를 3~12자로 입력해주세요" )
//    @Column
    private String password;
    private String email;

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<Board> board = new ArrayList<>();

    @Builder
    public User(String username,String password, String email){
        this.username = username;
        this.password = password;
        this.email = email;
    }

}
