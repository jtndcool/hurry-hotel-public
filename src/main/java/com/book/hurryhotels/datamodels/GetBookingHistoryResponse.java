package com.book.hurryhotels.datamodels;

import java.util.List;

public class GetBookingHistoryResponse {

	private ResultStatus resultstatus;
	
	private List<BookingHistory> bookingHistoryList;

	public ResultStatus getResultstatus() {
		return resultstatus;
	}

	public void setResultstatus(ResultStatus resultstatus) {
		this.resultstatus = resultstatus;
	}

	public List<BookingHistory> getBookingHistoryList() {
		return bookingHistoryList;
	}

	public void setBookingHistoryList(List<BookingHistory> bookingHistoryList) {
		this.bookingHistoryList = bookingHistoryList;
	}

	
	
}
