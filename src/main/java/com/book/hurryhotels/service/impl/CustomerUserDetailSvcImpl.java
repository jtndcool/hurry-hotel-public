package com.book.hurryhotels.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.book.hurryhotels.repo.AuthenticateRepo;
import com.book.hurryhotels.service.CustomerUserDetailSvc;

@Service
public class CustomerUserDetailSvcImpl implements CustomerUserDetailSvc{
	
	
    @Autowired
    private AuthenticateRepo authRepo;

    @Override
    public UserDetails loadUserByUsername(String username) {
        com.book.hurryhotels.datamodels.User user = authRepo.findUserRepo(username);
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), new ArrayList<>());
    }


}
