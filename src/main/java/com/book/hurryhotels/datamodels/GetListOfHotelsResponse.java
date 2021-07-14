package com.book.hurryhotels.datamodels;

import java.util.List;

public class GetListOfHotelsResponse {
	
		private ResultStatus resultStatus;
		private List<Hotel> hotelList;
		public ResultStatus getResultStatus() {
			return resultStatus;
		}
		public void setResultStatus(ResultStatus resultStatus) {
			this.resultStatus = resultStatus;
		}
		public List<Hotel> getHotelList() {
			return hotelList;
		}
		public void setHotelList(List<Hotel> hotelList) {
			this.hotelList = hotelList;
		}
		
		
}
