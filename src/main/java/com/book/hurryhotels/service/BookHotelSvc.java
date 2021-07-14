package com.book.hurryhotels.service;

import com.book.hurryhotels.datamodels.BookHotelRequest;
import com.book.hurryhotels.datamodels.BookHotelResponse;

public interface BookHotelSvc {
	public BookHotelResponse bookHotel(BookHotelRequest bookHotelRequest);
}
