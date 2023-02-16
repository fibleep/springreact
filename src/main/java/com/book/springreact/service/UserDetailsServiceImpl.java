package com.book.springreact.service;

import com.book.springreact.persistance.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;

import com.book.springreact.domain.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User currentUser = userRepository.findByUsername(username);
        UserDetails userDetails = new  org.springframework.security.core.userdetails.User(currentUser.getUsername(), currentUser.getPassword(), true, true, true, true, AuthorityUtils.createAuthorityList(currentUser.getRole()));
        return userDetails;
    }
}
