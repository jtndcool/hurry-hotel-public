package com.book.hurryhotels.repo.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.book.hurryhotels.datamodels.User;
import com.book.hurryhotels.repo.AuthenticateRepo;
import com.book.hurryhotels.utils.HurryHotelConstant;

@Repository
public class AuthenticateRepoImpl implements AuthenticateRepo {
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public User findUserRepo(String email) {
		
		String query = HurryHotelConstant.QueryAuthenticate;
		User user = new User();
		try {
			user = namedParameterJdbcTemplate.queryForObject(query, new MapSqlParameterSource().addValue(HurryHotelConstant.email, email), new RowMapper<User>() {

				@Override
				public User mapRow(ResultSet rs, int rowNum) throws SQLException {
					User user = new User();
					user.setEmail(rs.getString(HurryHotelConstant.email));
					user.setPassword(rs.getString(HurryHotelConstant.user_password));
					user.setUserName(rs.getString(HurryHotelConstant.username));
					user.setUserId(rs.getString(HurryHotelConstant.userId));
					return user;
				}
			});
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return user;
	}

}
