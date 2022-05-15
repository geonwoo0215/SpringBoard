package Springboard.boardservice.repository;

import Springboard.boardservice.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    public void saveMember(User user){
        em.persist(user);
    }

    public User findOne(Long id){
        return em.find(User.class, id);
    }

    public List<User> findAll(){
        return em.createQuery("select  m from Member m")
                .getResultList();
    }

    public List<User> findByName(String username) {
        return em.createQuery("select m from User m where m.username = :username", User.class)
                .setParameter("username", username)
                .getResultList();
    }
}
