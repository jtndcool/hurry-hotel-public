package com.book.hurryhotels.utils;

public class HurryHotelConstant {
	
	
	public static final String city ="city";
	public static final String hotelId = "hotelId";
	public static final String userId = "userId";
	public static final String amount = "amount";
	public static final String days = "days";
	public static final String username = "username";
	public static final String address = "address";
	public static final String mobile = "mobile";
	public static final String password = "password";
	public static final String email = "email";
	public static final String user_password = "user_password";
	
	public static final String success = "SUCCESS";
	public static final String failed = "FAILED";
	
	public static final String unknownError = "Some Unknown error occured";
	public static final String unkownErrorCode = "HH-001";
	
	public static final String invalidCity = "Invalid city has been entered";
	public static final String invalidCityErrorCode = "HH-002";
	
    public static final String emptyCity = "City field is set null/empty";
	public static final String emptyCityCode ="HH-003";
	
	public static final String invalidRequest = "Request is invalid ..Please try again..!";
	public static final String invalidRequestCode ="HH-004";
	
	public static final String noBooking = "No Past Booking found......!!!";
	public static final String noBookingCode ="HH-005";
	
	public static final String emailMobileAlreadyExists = "Email/Mobile already exists....! Please try to sign in with the same";
	public static final String emailMobileAlreadyExistsCode="HH-006";
	
	public static final String invalidCredentials = "Invalid Username/Password.............!";
	public static final String invalidCredentialsCode = "HH-007";
	
	//=======================================DB Queries================================================/
	public static final String QueryGetAvailableHotels="select * from hurryhotels.hotels hotel where hotel.city=:city";
	public static final String QueryBookHotel =  "INSERT INTO hurryhotels.bookings (bookingid, hotelid, userid, amount, no_of_days, dateofbooking) VALUES(nextval('hurryhotels.booking_seq'), :hotelId, :userId, :amount, :days, now())";
	public static final String QueryBookingHistory = "select * from hurryhotels.hotels inner join hurryhotels.bookings on hurryhotels.hotels.hotelid=hurryhotels.bookings.hotelid where hurryhotels.bookings.userid=:userId";
	public static final String QuerySignUp = "INSERT INTO hurryhotels.users (userid, username, address, mobile, email, user_password) VALUES(nextval('hurryhotels.user_seq'), :username, :address, :mobile, :email, :password)";
	public static final String QueryAuthenticate = "select * from hurryhotels.users where email=:email";
	public static final String QueryInfoHotel = "select * from hurryhotels.hotels where hurryhotels.hotels.hotelid=:hotelId";
	//=================================================================================================/
	

}
