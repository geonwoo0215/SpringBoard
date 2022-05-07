package Springboard.boardservice.domain;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Writing {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 50, nullable = false)
    private String title;

    @Column(length = 50, nullable = false)
    private String writer;

    @Column(nullable = false)
    private String content;

    @CreatedDate
    @Column
    private LocalDateTime createDate;

    @LastModifiedDate
    @Column
    private LocalDateTime modifiedDate;

}


