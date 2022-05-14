package Springboard.boardservice.service;

import Springboard.boardservice.domain.CustomUserDetails;
import Springboard.boardservice.domain.User;
import Springboard.boardservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository repository;

    public void saveUser(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = repository.findUserByEmail(email);
        return new CustomUserDetails(user.getEmail(), user.getPassword(), user.getRole());
    }
}
