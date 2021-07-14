package com.book.hurryhotels.repo.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.book.hurryhotels.datamodels.Hotel;
import com.book.hurryhotels.repo.HotelInfoRepo;
import com.book.hurryhotels.utils.HurryHotelConstant;

@Repository
public class HotelInfoRepoImpl implements HotelInfoRepo {
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public Hotel getHotelInfo(String hotelId) {
		Hotel hotel = new Hotel();
		String query = HurryHotelConstant.QueryInfoHotel;
		try {
			hotel = namedParameterJdbcTemplate.queryForObject(query, new MapSqlParameterSource().addValue("hotelId", Integer.parseInt(hotelId)), new RowMapper<Hotel>() {

				@Override
				public Hotel mapRow(ResultSet rs, int rowNum) throws SQLException {
					Hotel hotel = new Hotel();
					hotel.setCity(rs.getString("city"));
					hotel.setDescription(rs.getString("description"));
					hotel.setHotelId(rs.getString("hotelid"));
					hotel.setHotelName(rs.getString("hotelname"));
					hotel.setImage(rs.getString("image"));
					hotel.setLocation(rs.getString("locationh"));
					hotel.setPrice(rs.getString("price"));
					return hotel;
				}
			});
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return hotel;
	}

}
