package Springboard.boardservice.dto;

import Springboard.boardservice.domain.Writing;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
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
}
