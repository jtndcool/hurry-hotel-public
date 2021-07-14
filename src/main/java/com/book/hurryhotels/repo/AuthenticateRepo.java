package com.book.hurryhotels.repo;

import com.book.hurryhotels.datamodels.User;

public interface AuthenticateRepo {

	public User findUserRepo(String username); 
	
}
