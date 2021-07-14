package com.book.hurryhotels.repo.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.book.hurryhotels.datamodels.BookingHistory;
import com.book.hurryhotels.repo.BookingHistoryRepo;
import com.book.hurryhotels.utils.HurryHotelConstant;

@Repository
public class BookingHistoryRepoImpl implements BookingHistoryRepo{
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<BookingHistory> getBookingHistory(String userId) {
		String query = HurryHotelConstant.QueryBookingHistory;
		List<BookingHistory> bookingHistoryList = new ArrayList<>();
		try {
			bookingHistoryList = namedParameterJdbcTemplate.query(query, new MapSqlParameterSource().addValue("userId", Integer.parseInt(userId)), new RowMapper<BookingHistory>() {

				@Override
				public BookingHistory mapRow(ResultSet rs, int rowNum) throws SQLException {
					BookingHistory bookingHistory = new BookingHistory();
					bookingHistory.setAmount(rs.getString("amount"));
					bookingHistory.setBookingId(String.valueOf(rs.getInt("bookingid")));
					bookingHistory.setCity(rs.getString("city"));
					bookingHistory.setDateOfBooking(rs.getString("dateofbooking"));
					bookingHistory.setHotelId(String.valueOf(rs.getInt("hotelid")));
					bookingHistory.setHotelName(rs.getString("hotelname"));
					bookingHistory.setImage(rs.getString("image"));
					bookingHistory.setLocation(rs.getString("locationh"));
					bookingHistory.setNoOfDays(rs.getString("no_of_days"));
					return bookingHistory;
				}
			});
		}
		catch(Exception e ) {
			e.printStackTrace();
			
		}
		
		return bookingHistoryList;
	}

	
}

