package Springboard.boardservice.service;

import Springboard.boardservice.domain.Role;
import Springboard.boardservice.domain.User;
import Springboard.boardservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService implements UserDetailsService {

    private final UserRepository userRepository;

    @Transactional
    public Long joinUser(User user) {
        userRepository.saveUser(user);
        return user.getId();
    }


    public List<User> findMembers() {
        return userRepository.findAll();
    }




    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> findName = userRepository.findByUsername(username);
        User user = findName.get();

        List<GrantedAuthority> authorities = new ArrayList<>();

        if(("admin").equals(username)){
            authorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));
        }else {
            authorities.add(new SimpleGrantedAuthority(Role.USER.getValue()));
        }
        return new User(user.getUsername(), user.getPassword(), authorities);


        return null;
    }
}
