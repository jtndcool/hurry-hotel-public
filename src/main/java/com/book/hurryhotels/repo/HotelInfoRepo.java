package com.book.hurryhotels.repo;

import com.book.hurryhotels.datamodels.Hotel;

public interface HotelInfoRepo {

	Hotel getHotelInfo(String hotelId);
}
