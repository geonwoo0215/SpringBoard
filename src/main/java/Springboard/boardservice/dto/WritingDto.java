package Springboard.boardservice.dto;

import Springboard.boardservice.domain.Writing;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class WritingDto {
    private Long id;
    private String title;
    private String writer;
    private String content;
    private LocalDateTime createDate;
    private LocalDateTime modifiedDate;

    public Writing toEntity(){
        Writing build = Writing.builder()
                .id(id)
                .title(title)
                .writer(writer)
                .content(content)
                .build();
        return build;
    }

    @Builder
    public WritingDto(Long id, String title, String writer, String content, LocalDateTime createDate, LocalDateTime modifiedDate) {
        this.id = id;
        this.title = title;
        this.writer = writer;
        this.content = content;
        this.createDate = createDate;
        this.modifiedDate = modifiedDate;
    }
}
