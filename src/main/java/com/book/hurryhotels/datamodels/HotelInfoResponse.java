package com.book.hurryhotels.datamodels;

public class HotelInfoResponse {
  ResultStatus resultStatus;
  Hotel hotel;
public ResultStatus getResultStatus() {
	return resultStatus;
}
public void setResultStatus(ResultStatus resultStatus) {
	this.resultStatus = resultStatus;
}
public Hotel getHotel() {
	return hotel;
}
public void setHotel(Hotel hotel) {
	this.hotel = hotel;
}
  
}
