package Springboard.boardservice.service;

import Springboard.boardservice.domain.Writing;
import Springboard.boardservice.dto.WritingDto;
import Springboard.boardservice.repository.WritingRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WritingService {

    private final WritingRepository writingRepository;

    @Transactional
    public Long save(WritingDto writingDto){
        return writingRepository.save(writingDto.toEntity()).getId();
    }

    @Transactional
    public List<WritingDto> getWritingList(){
        List<Writing> writingList = writingRepository.findAll();
        List<WritingDto> writingDtoList = new ArrayList<>();

        for(Writing writing : writingList){
            WritingDto writingDto = WritingDto.builder()
                    .id(writing.getId())
                    .writer(writing.getWriter())
                    .title(writing.getTitle())
                    .content(writing.getContent())
                    .createDate(writing.getCreateDate())
                    .build();
            writingDtoList.add(writingDto);
        }
        return writingDtoList;
    }

    @Transactional
    public WritingDto getPost(Long id) {
        Writing writing = writingRepository.findById(id).get();

        WritingDto writingDto = WritingDto.builder()
                .id(writing.getId())
                .writer(writing.getWriter())
                .title(writing.getTitle())
                .content(writing.getContent())
                .createDate(writing.getCreateDate())
                .build();
        return writingDto;
    }

    @Transactional
    public void deletePost(Long id) {
        writingRepository.deleteById(id);
    }

}
