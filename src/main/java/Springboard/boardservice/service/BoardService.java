package Springboard.boardservice.service;

import Springboard.boardservice.domain.Board;
import Springboard.boardservice.dto.BoardDto;
import Springboard.boardservice.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public Long saveBoard(BoardDto boardDto){
        boardRepository.save(boardDto.toEntity());
        return boardDto.getId();
    }

    public List<Board> findAll(){
        return boardRepository.findAll();
    }

    @Transactional
    public Page<Board> getBoardList(Pageable pageable){
        boardRepository.findAll(pageable);
    }

    public Page<Board> paging(int page) {
        return boardRepository.findAll(PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "id")));
    }

    @Transactional
    public void updateVisit(Long id, BoardDto boardDto){
        Board board = boardRepository.findById(id).orElseThrow(() ->
                new IllegalStateException("해당 게시글이 존재하지 않습니다."));
        board.updateVisit(boardDto.getCountVisit());
    }


}
