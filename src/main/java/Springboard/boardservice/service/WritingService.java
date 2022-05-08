package Springboard.boardservice.service;

import Springboard.boardservice.domain.Writing;
import Springboard.boardservice.dto.WritingDto;
import Springboard.boardservice.repository.WritingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class WritingService {

    private WritingRepository writingRepository;

    @Transactional
    public Long save(WritingDto writingDto){
        Writing writing = writingDto.toEntity();
        writingRepository.save(writing);

        return writing.getId();
    }
}
