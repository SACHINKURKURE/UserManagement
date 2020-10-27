package com.usrmgmt.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.usrmgmt.app.bean.AppResponse;
import com.usrmgmt.app.bean.AppUserBean;
import com.usrmgmt.app.bean.GenderMasterBean;
import com.usrmgmt.app.service.UserMgmtService;

@RestController
public class RegistrationController {
	/*
	 * 1. LOGIN API
	 * End point: https://api.ta.sixsprintscloud.com/api/v1/user/login
	 * HTTP Method: POST
	 * Sample request: {“userName”:”abc”, “password”:“xyz”}
	 * Sample success response: {“errorMessage”:null,
	 * 							"status":true,
	 * 							"data":
									{“token”:”abc”,
									“user”:
										{“id”:”123”,“userName”:”abc”,”gender”:”FEMALE”}
									}
								}
	 */
	@PostMapping(path = "/user/login", consumes = MediaType.APPLICATION_JSON_VALUE)			
	public AppResponse loginAuthenticate(@RequestBody AppUserBean appUserBean) {
		System.out.println(". . . in loginAuthenticate");
        return userMgmtService.authenticateUser(appUserBean.getUserName(), appUserBean.getPassword());  
	}

	/*
	 * 2. REGISTER API
	 * End point: https://api.ta.sixsprintscloud.com/api/v1/user
	 * HTTP Method: POST
	 * Sample request: {“userName”:”abc”, “password”:“xyz”,”gender”:”MALE”}
	 * Sample success response: {“errorMessage”:null,"status":true,"data":{“token”:”abc”,“user”:{“id”:”123”,“userName”:”abc”,”gender”:”MALE”}}}
	 * */
	@PostMapping(path = "/user/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)	
	public AppResponse registerUser(@RequestBody AppUserBean appUserBean) {
		return userMgmtService.registerUser(appUserBean.getUserName(), appUserBean.getPassword(), appUserBean.getGender());
	}

	/*
	 * 3. GET ALL USERS DATA 
	 * End Point: https://api.ta.sixsprintscloud.com/api/v1/user?page=0&size=25 
	 * Sample request: HEADER should have the following key value pair X-AUTH-TOKEN = <token got
	 * after login/register> 
	 * Sample success response: {"errorMessage":null,
	 * ”status":true, "data":{"currentPage":0, "currentPageSize":25,
	 * "totalPages":40, "totalElements":1000, "content":[ {"id":1, "userName":"abc",
	 * "password":"pass3", "gender":"OTHERS"}, {"id":2, "userName":"def",
	 * "password":"pass4", "gender":"MALE"}]}}
	 * 
	 */
	//http://localhost:5700/api/v1/user/page/0/size/25
	@RequestMapping("/user/page/{currentPageNum}/size/{currentPageSize}")
	public List<AppUserBean> getUsers(@PathVariable String currentPageNum, @PathVariable String currentPageSize) {
		return userMgmtService.getAllUserData();
	}

	/*
	 * 4. VERIFY TOKEN API
	 * End point: https://api.ta.sixsprintscloud.com/api/v1/user/verify-token 
	 * HTTP Method: POST
	 * Sample request: HEADER should have the following key value pair X-AUTH-TOKEN = <token got after login/register>
	 * .Sample success response: {“errorMessage”:null,
	 * 								”status":true,
	 * 								"data":{"id": 1,
	 * 								"userName":"abc",
	 * 								"gender":"FEMALE"}
	 * 							}
	 * */
	@PostMapping(path = "/user/verify-token", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)			
	public AppResponse verifyToken(@RequestBody AppUserBean appUserBean) {
        return userMgmtService.verifyToken(appUserBean.getToken());  
	}
	
    /*
	 * 5. GET GENDER MASTER getGenderMaster()
	 * End Point: https://api.ta.sixsprintscloud.com/api/v1/config/genders
	 * Sample success response: {“errorMessage":null,"status":true,"data": ["MALE","FEMALE","OTHERS"]}
	 * Actual Response: {"errorMessage":"null","status":"true","data":"MALE"}
	 * */
	
	@Autowired
	private UserMgmtService userMgmtService;
	
	@RequestMapping(value = "/config/genders/userID/{userID}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public GenderMasterBean getAppUserGender(@PathVariable String userID) {
		return userMgmtService.findGender(userID);				
	}	
}