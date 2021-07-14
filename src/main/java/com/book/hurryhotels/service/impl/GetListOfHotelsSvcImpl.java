package com.book.hurryhotels.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.hurryhotels.datamodels.GetListOfHotelsResponse;
import com.book.hurryhotels.datamodels.Hotel;
import com.book.hurryhotels.datamodels.ResultStatus;
import com.book.hurryhotels.repo.GetListOfHotelRepo;
import com.book.hurryhotels.service.GetListOfHotelsSvc;
import com.book.hurryhotels.utils.HurryHotelConstant;

@Service
public class GetListOfHotelsSvcImpl implements GetListOfHotelsSvc {
	
	@Autowired
	GetListOfHotelRepo getListOfHotelRepo;
	
	@Override
	public GetListOfHotelsResponse getListofHotels(String city) {
	 
		GetListOfHotelsResponse getListOfHotelsResponse = new GetListOfHotelsResponse();
		if(city == null) {
			ResultStatus resultStatus = new ResultStatus();
			resultStatus.setStatus(HurryHotelConstant.failed);
			resultStatus.setErrorCode(HurryHotelConstant.emptyCityCode);
			resultStatus.setErrorMsg(HurryHotelConstant.emptyCity);
			getListOfHotelsResponse.setResultStatus(resultStatus);
			return getListOfHotelsResponse;
		}
		List<Hotel> hotelList = getListOfHotelRepo.getListofHotels(city);
		if(hotelList.isEmpty()) {
			ResultStatus resultStatus = new ResultStatus();
			resultStatus.setStatus(HurryHotelConstant.failed);
			resultStatus.setErrorCode(HurryHotelConstant.invalidCityErrorCode);
			resultStatus.setErrorMsg(HurryHotelConstant.invalidCity);
			getListOfHotelsResponse.setResultStatus(resultStatus);
			return getListOfHotelsResponse;
		}
		ResultStatus resultStatus = new ResultStatus();
		resultStatus.setStatus(HurryHotelConstant.success);
		getListOfHotelsResponse.setHotelList(hotelList);
		getListOfHotelsResponse.setResultStatus(resultStatus);
		return getListOfHotelsResponse;
	}

}
