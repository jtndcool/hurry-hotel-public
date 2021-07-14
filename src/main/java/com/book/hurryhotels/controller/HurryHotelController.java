package com.book.hurryhotels.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.book.hurryhotels.auth.JwtUtil;
import com.book.hurryhotels.datamodels.BookHotelRequest;
import com.book.hurryhotels.datamodels.BookHotelResponse;
import com.book.hurryhotels.datamodels.GetBookingHistoryRequest;
import com.book.hurryhotels.datamodels.GetBookingHistoryResponse;
import com.book.hurryhotels.datamodels.GetListOfHotelsRequest;
import com.book.hurryhotels.datamodels.GetListOfHotelsResponse;
import com.book.hurryhotels.datamodels.HotelInfoResponse;
import com.book.hurryhotels.datamodels.ResultStatus;
import com.book.hurryhotels.datamodels.SignInRequest;
import com.book.hurryhotels.datamodels.SignInResponse;
import com.book.hurryhotels.datamodels.SignUpRequest;
import com.book.hurryhotels.datamodels.SignUpResponse;
import com.book.hurryhotels.service.BookHotelSvc;
import com.book.hurryhotels.service.BookingHistorySvc;
import com.book.hurryhotels.service.GetListOfHotelsSvc;
import com.book.hurryhotels.service.HotelInfoSvc;
import com.book.hurryhotels.service.SignInSvc;
import com.book.hurryhotels.service.SignUpSvc;
import com.book.hurryhotels.utils.HurryHotelConstant;

import io.swagger.annotations.Api;

/*
 * @ author:Jatin Kumar / jatin.kumar.mec15@iitbhu.ac.in
 *
 */

@RestController
@Api("list of all the apis under hurryhotels.com")
public class HurryHotelController {
	

	@Autowired
	GetListOfHotelsSvc getListOfHotelsSvc;
	
	@Autowired
	HotelInfoSvc hotelInfoSvc;

	@Autowired
	BookHotelSvc bookHotelSvc;
	
	@Autowired
	BookingHistorySvc bookingHistorySvc;
	
	@Autowired
	SignUpSvc signUpSvc;
	
	@Autowired
	JwtUtil jwtUtil;
	
	@Autowired
	SignInSvc signInSvc;
	
    @Autowired
    private AuthenticationManager authenticationManager;
    
    private static final Logger logger = LoggerFactory.getLogger(HurryHotelController.class);
	/*
	 * @ Request Parameters:- City
	 */
	@PostMapping("/getHotelsList")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public ResponseEntity<GetListOfHotelsResponse> getListOfHotels(@RequestBody GetListOfHotelsRequest getListOfHotelsRequest) {
		GetListOfHotelsResponse getListOfHotelsResponse = new GetListOfHotelsResponse();
		getListOfHotelsResponse = getListOfHotelsSvc.getListofHotels(getListOfHotelsRequest.getCity());
		return new ResponseEntity<GetListOfHotelsResponse>(getListOfHotelsResponse, HttpStatus.OK);
	}
	
	
	@GetMapping("/getHotels/{city}")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public ResponseEntity<GetListOfHotelsResponse> getListOfHotelsList(@PathVariable String city) {
	
		GetListOfHotelsResponse getListOfHotelsResponse = new GetListOfHotelsResponse();
		getListOfHotelsResponse = getListOfHotelsSvc.getListofHotels(city);
		return new ResponseEntity<GetListOfHotelsResponse>(getListOfHotelsResponse, HttpStatus.OK);
	}
	
	@GetMapping("/hotelInfo/{hotelId}")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public ResponseEntity<HotelInfoResponse> getHotelInfo(@PathVariable String hotelId) {
	
		HotelInfoResponse hotelInfoResponse = new HotelInfoResponse();
		hotelInfoResponse = hotelInfoSvc.getHotelInfo(hotelId);
		return new ResponseEntity<HotelInfoResponse>(hotelInfoResponse, HttpStatus.OK);
	}
	
	/*
	 * @ Request Parameters:-HoteilId, UserId, daysOfBooking, price
	 */
	@PostMapping("/bookHotel")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public ResponseEntity<BookHotelResponse> bookHotel(@RequestBody BookHotelRequest bookHotelRequest) {
		BookHotelResponse bookHotelResponse = new BookHotelResponse();
		bookHotelResponse = bookHotelSvc.bookHotel(bookHotelRequest);
		return new ResponseEntity<BookHotelResponse>(bookHotelResponse , HttpStatus.OK);
	}
	
	
	@PostMapping("/bookHotelTest")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public ResponseEntity<BookHotelResponse> bookHotelTest(@RequestBody BookHotelRequest bookHotelRequest) {
		BookHotelResponse bookHotelResponse = new BookHotelResponse();
		bookHotelResponse = bookHotelSvc.bookHotel(bookHotelRequest);
		return new ResponseEntity<BookHotelResponse>(bookHotelResponse , HttpStatus.OK);
	}
	
	/*
	 * Request Parameters:-UserId
	 */
	@PostMapping("/getBookingHistory")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public ResponseEntity<GetBookingHistoryResponse> showBookedHistory(@RequestBody GetBookingHistoryRequest bookingHistoryRequest) {
		GetBookingHistoryResponse bookingHistoryResponse = new GetBookingHistoryResponse();
		bookingHistoryResponse = bookingHistorySvc.getBookingHistory(bookingHistoryRequest);
		return new ResponseEntity<GetBookingHistoryResponse>(bookingHistoryResponse, HttpStatus.OK);
	}
	
	/*
	 * for testing purpose
	 */
	@PostMapping("/getBookingHistoryTest")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public ResponseEntity<GetBookingHistoryResponse> showBookedHistoryTest(@RequestBody GetBookingHistoryRequest bookingHistoryRequest) {
		GetBookingHistoryResponse bookingHistoryResponse = new GetBookingHistoryResponse();
		bookingHistoryResponse = bookingHistorySvc.getBookingHistory(bookingHistoryRequest);
		return new ResponseEntity<GetBookingHistoryResponse>(bookingHistoryResponse, HttpStatus.OK);
	}
	
	
	/*
	 * Request Parameters:-UserId
	 */
	@PostMapping("/signUp")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public ResponseEntity<SignUpResponse> signUp(@RequestBody SignUpRequest signUpRequest) {
		
		return new ResponseEntity<SignUpResponse>(signUpSvc.signUp(signUpRequest), HttpStatus.OK);
	}
	
	/*
	 * Request Parameters:-UserId
	 */
	@PostMapping("/authenticate")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public ResponseEntity<SignInResponse> authenticate(@RequestBody SignInRequest signInRequest) {
		SignInResponse signInResponse  = new SignInResponse();
		
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(signInRequest.getEmail(), signInRequest.getPassword())
            );
        } catch (Exception ex) {
        	logger.info("==============================================Failed====================================================="+ex);
        	ResultStatus resultStatus = new ResultStatus();
        	resultStatus.setErrorCode(HurryHotelConstant.invalidCredentialsCode);
        	resultStatus.setErrorMsg(HurryHotelConstant.invalidCredentials);
        	resultStatus.setStatus(HurryHotelConstant.failed);
			signInResponse.setResultStatus(resultStatus );
        	
        	return new ResponseEntity<SignInResponse>(signInResponse, HttpStatus.OK);
        }
        
        String jwt = jwtUtil.generateToken(signInRequest.getEmail());
        logger.info("==============================================JWT generated successfully=====================================================");
        ResultStatus resultStatus = new ResultStatus();
    	resultStatus.setStatus(HurryHotelConstant.success);
		signInResponse.setResultStatus(resultStatus );
        signInResponse.setJwt(jwt);	
        signInResponse.setUser(signInSvc.signIn(signInRequest.getEmail()));
		
		return new ResponseEntity<SignInResponse>(signInResponse, HttpStatus.OK);
	}


}
