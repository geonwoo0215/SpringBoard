package Springboard.boardservice.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String role;



}
