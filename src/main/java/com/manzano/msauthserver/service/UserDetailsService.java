package com.manzano.msauthserver.service;

import com.manzano.msauthserver.model.Authority;
import com.manzano.msauthserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;

@Service
@Transactional
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUserName(username)
                    .map(user -> new User(user.getUsername(), user.getPassword(), getGrantedAuthorities(user)))
                    .orElseThrow(() -> new UsernameNotFoundException("User " + username + " Not found"));
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private Collection<GrantedAuthority> getGrantedAuthorities(com.manzano.msauthserver.model.User user) {
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        for (Authority authority : user.getAuthorities()) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority.getName());
            grantedAuthorities.add(grantedAuthority);
        }

        return grantedAuthorities;
    }
}