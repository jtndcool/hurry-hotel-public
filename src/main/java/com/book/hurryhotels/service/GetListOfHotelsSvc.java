package com.book.hurryhotels.service;

import com.book.hurryhotels.datamodels.GetListOfHotelsResponse;
import com.book.hurryhotels.datamodels.HotelInfoResponse;

public interface GetListOfHotelsSvc {

	GetListOfHotelsResponse getListofHotels(String city);
	
}
