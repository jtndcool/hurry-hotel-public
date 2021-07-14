package com.book.hurryhotels.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.hurryhotels.datamodels.Hotel;
import com.book.hurryhotels.datamodels.HotelInfoResponse;
import com.book.hurryhotels.datamodels.ResultStatus;
import com.book.hurryhotels.repo.HotelInfoRepo;
import com.book.hurryhotels.service.HotelInfoSvc;
import com.book.hurryhotels.utils.HurryHotelConstant;

@Service
public class HotelInfoSvcImpl implements HotelInfoSvc {
	
	@Autowired
	HotelInfoRepo hotelInfoRepo;

	@Override
	public HotelInfoResponse getHotelInfo(String hotelId) {
		HotelInfoResponse hotelInfoResponse = new HotelInfoResponse();
		Hotel hotel = hotelInfoRepo.getHotelInfo(hotelId);
		ResultStatus resultStatus = new ResultStatus();
		if(hotel == null) {
		
			resultStatus.setStatus(HurryHotelConstant.failed);
			resultStatus.setErrorCode(HurryHotelConstant.invalidRequestCode);
			resultStatus.setErrorMsg(HurryHotelConstant.invalidRequest);
			hotelInfoResponse.setResultStatus(resultStatus);
			return hotelInfoResponse;
		}
		else {
			hotelInfoResponse.setHotel(hotel);
			resultStatus.setStatus(HurryHotelConstant.success);
			hotelInfoResponse.setResultStatus(resultStatus);
		}
		return hotelInfoResponse;
	}

}
