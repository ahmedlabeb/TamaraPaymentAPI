package com.tamara.tamarapaymentapi.api.control;

import com.tamara.tamarapaymentapi.configuration.MyUserDetails;
import com.tamara.tamarapaymentapi.api.entity.User;
import com.tamara.tamarapaymentapi.api.entity.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailService implements UserDetailsService {

    private UserRepository userRepository;

    public UserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByName(username);
        if (user.isEmpty())
            throw new UsernameNotFoundException("No user found with username: " + username);
        return user.map(MyUserDetails::new).get();
    }
}
