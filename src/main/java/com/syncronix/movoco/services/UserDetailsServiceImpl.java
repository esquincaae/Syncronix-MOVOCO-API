package com.syncronix.movoco.services;

import com.syncronix.movoco.entities.User;
import com.syncronix.movoco.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IUserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{

       User user = repository.findByEmail(email)
               .orElseThrow(()-> new UsernameNotFoundException("User not found"));

        return new UserDetailsImpl(user);
    }
}
