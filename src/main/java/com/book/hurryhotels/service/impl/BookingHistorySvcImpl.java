package com.book.hurryhotels.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.hurryhotels.datamodels.BookingHistory;
import com.book.hurryhotels.datamodels.GetBookingHistoryRequest;
import com.book.hurryhotels.datamodels.GetBookingHistoryResponse;
import com.book.hurryhotels.datamodels.ResultStatus;
import com.book.hurryhotels.repo.BookingHistoryRepo;
import com.book.hurryhotels.service.BookingHistorySvc;
import com.book.hurryhotels.utils.HurryHotelConstant;

@Service
public class BookingHistorySvcImpl implements BookingHistorySvc{
	
	@Autowired
	BookingHistoryRepo bookingHistoryRepo;

	@Override
	public GetBookingHistoryResponse getBookingHistory(GetBookingHistoryRequest getBookingHistoryRequest) {
		GetBookingHistoryResponse bookHotelResponse = new GetBookingHistoryResponse();
		if(getBookingHistoryRequest.getUserId() == null) {
			ResultStatus resultStatus = new ResultStatus();
			resultStatus.setStatus(HurryHotelConstant.failed);
			resultStatus.setErrorCode(HurryHotelConstant.invalidRequestCode);
			resultStatus.setErrorMsg(HurryHotelConstant.invalidRequest);
			bookHotelResponse.setResultstatus(resultStatus);
			return bookHotelResponse;
		}
		List<BookingHistory> bookingHistoryList = bookingHistoryRepo.getBookingHistory(getBookingHistoryRequest.getUserId());
		if(bookingHistoryList.isEmpty()) {
			ResultStatus resultStatus = new ResultStatus();
			resultStatus.setStatus(HurryHotelConstant.failed);
			resultStatus.setErrorCode(HurryHotelConstant.noBookingCode);
			resultStatus.setErrorMsg(HurryHotelConstant.noBooking);
			bookHotelResponse.setResultstatus(resultStatus);
			return bookHotelResponse;
		}
		else {
			ResultStatus resultStatus = new ResultStatus();
			resultStatus.setStatus(HurryHotelConstant.success);
			bookHotelResponse.setResultstatus(resultStatus);
			bookHotelResponse.setBookingHistoryList(bookingHistoryList);
			return bookHotelResponse;
		}
	}

}
