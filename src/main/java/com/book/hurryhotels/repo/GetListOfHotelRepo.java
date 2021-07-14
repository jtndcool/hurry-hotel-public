package com.book.hurryhotels.repo;

import java.util.List;

import com.book.hurryhotels.datamodels.Hotel;

public interface GetListOfHotelRepo {


	public List<Hotel> getListofHotels(String city);

}
