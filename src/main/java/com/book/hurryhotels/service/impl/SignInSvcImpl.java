package com.book.hurryhotels.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.hurryhotels.datamodels.User;
import com.book.hurryhotels.repo.AuthenticateRepo;
import com.book.hurryhotels.service.SignInSvc;

@Service
public class SignInSvcImpl implements SignInSvc {
	
	@Autowired
	private AuthenticateRepo authRepo;

	@Override
	public User signIn(String email) {
		return authRepo.findUserRepo(email);
	}

}
