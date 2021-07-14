package com.book.hurryhotels.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.hurryhotels.datamodels.BookHotelRequest;
import com.book.hurryhotels.datamodels.BookHotelResponse;
import com.book.hurryhotels.datamodels.ResultStatus;
import com.book.hurryhotels.repo.BookHotelRepo;
import com.book.hurryhotels.service.BookHotelSvc;
import com.book.hurryhotels.utils.HurryHotelConstant;

@Service
public class BookHotelSvcImpl implements BookHotelSvc{

	@Autowired
	BookHotelRepo bookHotelRepo;
	
	@Override
	public BookHotelResponse bookHotel(BookHotelRequest bookHotelRequest) {
		BookHotelResponse bookHotelResponse = new BookHotelResponse();
		if(bookHotelRequest.getHotelId()==null || bookHotelRequest.getNoOfDays()==null || bookHotelRequest.getPrice() == null || bookHotelRequest.getUserId() ==null) {
			ResultStatus resultStatus = new ResultStatus();
			resultStatus.setStatus(HurryHotelConstant.failed);
			resultStatus.setErrorCode(HurryHotelConstant.invalidRequestCode);
			resultStatus.setErrorMsg(HurryHotelConstant.invalidRequest);
			bookHotelResponse.setResultStatus(resultStatus);
			return bookHotelResponse;
		}
		String amount = String.valueOf(Integer.parseInt(bookHotelRequest.getPrice())*Integer.parseInt(bookHotelRequest.getNoOfDays()));
		
		int result = bookHotelRepo.bookHotel(amount, bookHotelRequest.getUserId(), bookHotelRequest.getHotelId(), bookHotelRequest.getNoOfDays());
		
		if(result==1) {
			ResultStatus resultStatus = new ResultStatus();
			resultStatus.setStatus(HurryHotelConstant.success);
			bookHotelResponse.setResultStatus(resultStatus);
			return bookHotelResponse;
		}
		else {
			ResultStatus resultStatus = new ResultStatus();
			resultStatus.setStatus(HurryHotelConstant.failed);
			resultStatus.setErrorCode(HurryHotelConstant.unkownErrorCode);
			resultStatus.setErrorMsg(HurryHotelConstant.unknownError);
			bookHotelResponse.setResultStatus(resultStatus);
			return bookHotelResponse;
		}
	}

}
