package com.book.hurryhotels.repo;

import java.util.List;

import com.book.hurryhotels.datamodels.BookingHistory;

public interface BookingHistoryRepo {
	
	public List<BookingHistory> getBookingHistory(String userId);

}
