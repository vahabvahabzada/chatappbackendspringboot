package com.example.chatappbackend.security;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.chatappbackend.entities.Role;
import com.example.chatappbackend.entities.UserEntity;
import com.example.chatappbackend.repos.UserRepo;
@Service
public class CustomUserDetailsService implements UserDetailsService{
    @Autowired
    private UserRepo repoLogin;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        UserEntity user=repoLogin.findByName(username);
        return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(),mapRolesAuthorities(user.getRoles()));
    }

    private Collection<GrantedAuthority> mapRolesAuthorities(List<Role>roles){
        return roles.stream().map(role->new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
