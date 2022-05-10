package Springboard.boardservice.dto;

import Springboard.boardservice.domain.Writing;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class WritingDto {
    private Long id;
    private String title;
    private String writer;
    private String content;
    private int view;
    private LocalDateTime createDate;
    private LocalDateTime modifiedDate;

    public Writing toEntity(){
        Writing build = Writing.builder()
                .id(id)
                .title(title)
                .writer(writer)
                .content(content)
                .view(view)
                .build();
        return build;
    }

    @Builder
    public WritingDto(Long id, String title, String writer, String content, int view, LocalDateTime createDate, LocalDateTime modifiedDate) {
        this.id = id;
        this.title = title;
        this.writer = writer;
        this.content = content;
        this.view = view;
        this.createDate = createDate;
        this.modifiedDate = modifiedDate;
    }
}
