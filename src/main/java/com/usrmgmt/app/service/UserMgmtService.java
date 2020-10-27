package com.usrmgmt.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.usrmgmt.app.bean.AppResponse;
import com.usrmgmt.app.bean.AppUserBean;
import com.usrmgmt.app.bean.GenderMasterBean;
import com.usrmgmt.app.bean.ResponseUserData;
import com.usrmgmt.app.bean.UserDetail;

@Component
public class UserMgmtService {
	private static List<AppUserBean> aList = new ArrayList<AppUserBean>();
	
	static {
		//AppUserBean(String id, String userName, String password, String gender)
		AppUserBean user_1 = new AppUserBean("1", "Sachin", "Sachin@123", "MALE");
		AppUserBean user_2 = new AppUserBean("2", "Gaurav", "Gaurav@456", "MALE");
		AppUserBean user_3 = new AppUserBean("3", "Sita", "Sita@789", "FEMALE");
		AppUserBean user_4 = new AppUserBean("4", "Geeta", "Geeta@098 ", "FEMALE");
		AppUserBean user_5 = new AppUserBean("5", "Devdutt", "Devdutt@666", "OTHERS");
		
		aList.add(user_1);
		aList.add(user_2);
		aList.add(user_3);
		aList.add(user_4);
		aList.add(user_5);
	}
	
	/*
	* Sample success response: {“errorMessage”:null,
	* 							"status":true,
	* 							"data":
	*									{“token”:”abc”,
	*									“user”:
	*										{“id”:”123”,“userName”:”abc”,”gender”:”FEMALE”}
	*									}
	*								}
	*
	*/
	
	public AppResponse authenticateUser(String loginName, String password){
		for (AppUserBean appUserBean : aList) {
			if (appUserBean.getUserName().equals(loginName)
					&& appUserBean.getPassword().equals(password)) {
				System.out.println("appUserBean.getId(): " + appUserBean.getId());
				String id = appUserBean.getId();
				String userName = appUserBean.getUserName();
			    String gender = appUserBean.getGender();
				
			    UserDetail userDetail =  new UserDetail(id, userName, gender);
				String token = "abc";
				ResponseUserData responseUserData = new ResponseUserData(token, userDetail);
				
				String errorMessage = null;
				boolean status = true;				
				AppResponse appResponse = new AppResponse(errorMessage, status, responseUserData);
				return appResponse;
			}
		}
		return null;
	}
	
	public AppResponse registerUser(String newUserName, String newUserPassword, String newUserGender) {
		AppUserBean newUser = new AppUserBean("99", newUserName, newUserPassword, newUserGender);
		 /* Sample success response: {“errorMessage”:null,
		  * 						"status":true,
		  * 						"data":
		  * 							{“token”:”abc”,
		  * 							“user”:
		  * 								{“id”:”123”, "userName”:”abc”, ”gender”:”MALE”}
		  * 							}
		  * 						}
		 * */
		if(newUser!=null) {
			String id = newUser.getId();
			String userName = newUser.getUserName();
		    String gender = newUser.getGender();
			
		    UserDetail userDetail =  new UserDetail(id, userName, gender);
			String token = "abc";
			ResponseUserData responseUserData = new ResponseUserData(token, userDetail);
			
			String errorMessage = null;
			boolean status = true;				
			AppResponse appResponse = new AppResponse(errorMessage, status, responseUserData);
			return appResponse;
		}else
			return null;
	}
	
	public List<AppUserBean> getAllUserData() {
		return aList;
	}
	
	 /* Sample success response: {“errorMessage”:null,
	  * 						"status":true,
	  * 						"data":
	  * 							{“token”:”abc”,
	  * 							“user”:
	  * 								{“id”:”123”, "userName”:”abc”, ”gender”:”MALE”}
	  * 							}
	  * 						}
	 * */
	public AppResponse verifyToken(String userToken) {
		System.out.println(". . . in verifyToken for " + userToken);
		for (AppUserBean appUserBean : aList) {
			System.out.println(". . . now >>> appUserBean.getToken() is " + appUserBean.getToken());
			if (appUserBean.getToken().equals(userToken)) {
				String id = appUserBean.getId();
				String userName = appUserBean.getUserName();
			    String gender = appUserBean.getGender();
				
			    UserDetail userDetail =  new UserDetail(id, userName, gender);
				String token = appUserBean.getToken();
				ResponseUserData responseUserData = new ResponseUserData(token, userDetail);
				
				String errorMessage = null;
				boolean status = true;				
				AppResponse appResponse = new AppResponse(errorMessage, status, responseUserData);
				return appResponse;
			}
		}
		return null;
	}
	
	public GenderMasterBean findGender(String userID) {
		System.out.println("... in findGender for userID: " + userID);
		for (AppUserBean appUserBean : aList) {
			if (appUserBean.getId().equals(userID)) {
				System.out.println("appUserBean.getId(): " + appUserBean.getId());
				String errorMsg = null;
				boolean status = true;
				String genderData = appUserBean.getGender();
				GenderMasterBean genderMasterBean = new GenderMasterBean(errorMsg, status, genderData);
				return genderMasterBean ;
			}
		}
		return null;
	}
}