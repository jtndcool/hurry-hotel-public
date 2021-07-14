package com.book.hurryhotels.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.hurryhotels.datamodels.ResultStatus;
import com.book.hurryhotels.datamodels.SignUpRequest;
import com.book.hurryhotels.datamodels.SignUpResponse;
import com.book.hurryhotels.repo.SignUpRepo;
import com.book.hurryhotels.service.SignUpSvc;
import com.book.hurryhotels.utils.HurryHotelConstant;

@Service
public class SignUpSvcImpl implements SignUpSvc{

	@Autowired
	SignUpRepo signUpRepo;
	
	@Override
	public SignUpResponse signUp(SignUpRequest signUpRequest) {
		SignUpResponse response = new SignUpResponse();
		
		if(signUpRequest.getUser()!=null) {
			if(signUpRequest.getUser().getAddress() == null || signUpRequest.getUser().getEmail() == null || 
					signUpRequest.getUser().getMobile() == null || signUpRequest.getUser().getPassword() == null
	 || signUpRequest.getUser().getUserName() == null) {
				
				ResultStatus resultStatus = new ResultStatus();
				resultStatus.setStatus(HurryHotelConstant.failed);
				resultStatus.setErrorCode(HurryHotelConstant.invalidRequestCode);
				resultStatus.setErrorMsg(HurryHotelConstant.invalidRequest);
				response.setResultStatus(resultStatus);
				return response;
			}
		}
		int res = 0;
		 res = signUpRepo.signUp(signUpRequest.getUser().getUserName(), signUpRequest.getUser().getPassword(), signUpRequest.getUser().getMobile(),
					signUpRequest.getUser().getEmail(), signUpRequest.getUser().getAddress());
		 if(res == 1) {
			 ResultStatus resultStatus = new ResultStatus();
			 resultStatus.setStatus(HurryHotelConstant.success);
			 response.setResultStatus(resultStatus);
		 }
		 else if(res == -1){
			 ResultStatus resultStatus = new ResultStatus();
				resultStatus.setStatus(HurryHotelConstant.failed);
				resultStatus.setErrorCode(HurryHotelConstant.emailMobileAlreadyExistsCode);
				resultStatus.setErrorMsg(HurryHotelConstant.emailMobileAlreadyExists);
				response.setResultStatus(resultStatus);
		 }
		 else {
			 	ResultStatus resultStatus = new ResultStatus();
				resultStatus.setStatus(HurryHotelConstant.failed);
				resultStatus.setErrorCode(HurryHotelConstant.unkownErrorCode);
				resultStatus.setErrorMsg(HurryHotelConstant.unknownError);
				response.setResultStatus(resultStatus);
		 }
		return response;
	}

}
