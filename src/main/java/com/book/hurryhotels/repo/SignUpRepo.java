package com.book.hurryhotels.repo;

public interface SignUpRepo {

	public int signUp(String username, String password, String mobile, String email, String address);
}
