package com.book.hurryhotels.service;

import com.book.hurryhotels.datamodels.HotelInfoResponse;

public interface HotelInfoSvc {
	HotelInfoResponse getHotelInfo(String hotelId);
	
}
