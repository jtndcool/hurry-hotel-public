package com.book.hurryhotels.service;

import com.book.hurryhotels.datamodels.SignUpRequest;
import com.book.hurryhotels.datamodels.SignUpResponse;

public interface SignUpSvc {
	
	public SignUpResponse signUp(SignUpRequest signUpRequest);
}
