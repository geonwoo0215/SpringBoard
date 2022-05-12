package Springboard.boardservice.domain;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    @Column
    private int view;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;

    @Builder
    public Writing(Long id, String title, String writer, String content, int view){
        this.id = id;
        this.title = title;
        this.writer = writer;
        this.content = content;
        this.view = view;
    }
}


