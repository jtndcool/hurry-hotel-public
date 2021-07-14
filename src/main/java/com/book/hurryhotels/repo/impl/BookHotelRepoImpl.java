package com.book.hurryhotels.repo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.book.hurryhotels.repo.BookHotelRepo;
import com.book.hurryhotels.utils.HurryHotelConstant;
@Repository
public class BookHotelRepoImpl implements BookHotelRepo{
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public int bookHotel(String amount, String userId, String hotelId, String days) {
		int result = 0;
		String query = HurryHotelConstant.QueryBookHotel;
		try {
			result = namedParameterJdbcTemplate.update(query, new MapSqlParameterSource()
					.addValue(HurryHotelConstant.amount, amount)
					.addValue(HurryHotelConstant.userId, Integer.parseInt(userId))
					.addValue(HurryHotelConstant.days, days)
					.addValue(HurryHotelConstant.hotelId, Integer.parseInt(hotelId)));
			return result;		
		}
		catch(Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

}
