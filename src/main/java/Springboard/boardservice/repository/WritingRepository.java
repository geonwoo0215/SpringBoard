package Springboard.boardservice.repository;

import Springboard.boardservice.domain.Writing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface WritingRepository extends JpaRepository<Writing, Long> {


    @Modifying
    @Query("update Writing p set p.view = p.view + 1 where p.id = :id")
    int updateView(Long id);
}
