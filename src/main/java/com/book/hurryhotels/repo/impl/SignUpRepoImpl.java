package com.book.hurryhotels.repo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.book.hurryhotels.repo.SignUpRepo;
import com.book.hurryhotels.utils.HurryHotelConstant;

@Repository
public class SignUpRepoImpl implements SignUpRepo {
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public int signUp(String username, String password, String mobile, String email, String address) {
	   int res = 0;
	   String query = HurryHotelConstant.QuerySignUp;
	   try {
		   res = namedParameterJdbcTemplate.update(query, new MapSqlParameterSource()
				   .addValue(HurryHotelConstant.username, username)
				   .addValue(HurryHotelConstant.password, password)
				   .addValue(HurryHotelConstant.address, address)
				   .addValue(HurryHotelConstant.mobile, mobile)
				   .addValue(HurryHotelConstant.email, email));
	   }
	   catch(DuplicateKeyException e) {
		   e.printStackTrace();
		   res = -1;
	   }
	   catch(Exception e) {
		   e.printStackTrace();
		   res=0;
	   }
		return res;
	}

}
