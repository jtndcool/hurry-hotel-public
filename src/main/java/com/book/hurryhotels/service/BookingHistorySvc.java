package com.book.hurryhotels.service;

import com.book.hurryhotels.datamodels.GetBookingHistoryRequest;
import com.book.hurryhotels.datamodels.GetBookingHistoryResponse;

public interface BookingHistorySvc {

	public GetBookingHistoryResponse getBookingHistory(GetBookingHistoryRequest getBookingHistoryRequest);
}
