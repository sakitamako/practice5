package com.diworksdev.practice5.action;

import com.opensymphony.xwork2.ActionSupport;

public class RegistAction extends ActionSupport {

	private String userFamilyName;
	private String userLastName;
	private String userFamilyNameKana;
	private String userLastNameKana;
	private String userMail;
	private String userPassword;
	private int userGender;
	private int userPostalCode;
	private String userPostalCodeCheck;
	private String userPrefecture;
	private String userAddress1;
	private String userAddress2;
	private int userAuthority;

	@Override
	public String execute() {

		return SUCCESS;

	}

	public String getUserFamilyName() {
        return userFamilyName;

    }
    public void setUserFamilyName(String userFamilyName) {
        this.userFamilyName = userFamilyName;

    }

	public String getUserLastName() {
        return userLastName;

    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;

    }

 	public String getUserFamilyNameKana() {
 		return userFamilyNameKana;

 	}

 	public void setUserFamilyNameKana(String userFamilyNameKana) {
 		this.userFamilyNameKana = userFamilyNameKana;

 	}

 	public String getUserLastNameKana() {
 		return userLastNameKana;

 	}

 	public void setUserLastNameKana(String userLastNameKana) {
 		this.userLastNameKana = userLastNameKana;

 	}

 	public String getUserMail() {
 		return userMail;

 	}

 	public void setUserMail(String userMail) {
 		this.userMail = userMail;

 	}

 	public String getUserPassword() {
 		return userPassword;

 	}

 	public void setUserPassword(String userPassword) {
 		this.userPassword = userPassword;

 	}

 	public int getUserGender() {
 		return userGender;

 	}

 	public void setUserGender(int userGender) {
 		System.out.println("start: setUserGender()");
 		System.out.println(userGender);
 		this.userGender = userGender;
 		System.out.println("end: setUserGender()");

 	}

 	public int getUserPostalCode() {
		return userPostalCode;

	}

	public void setUserPostalCode(int userPostalCode) {
		System.out.println("start: setUserPostalCode()");
		System.out.println(userPostalCode);
		this.userPostalCode = userPostalCode;
		System.out.println("end: setUserPostalCode()");

	}

 	public String getUserPostalCodeCheck() {
 		return userPostalCodeCheck;

 	}

 	public void setUserPostalCodeCheck(String userPostalCodeCheck) {
 		System.out.println("start: setUserPostalCodeCheck()");
 		System.out.println(userPostalCodeCheck);
 		this.userPostalCodeCheck = userPostalCodeCheck;
 		System.out.println("end: setUserPostalCodeCheck()");

 	}

 	public String getUserPrefecture() {
 		return userPrefecture;

 	}

 	public void setUserPrefecture(String userPrefecture) {
 		this.userPrefecture = userPrefecture;

 	}

 	public String getUserAddress1() {
 		return userAddress1;

 	}

 	public void setUserAddress1(String userAddress1) {
 		this.userAddress1 = userAddress1;

 	}

 	public String getUserAddress2() {
 		return userAddress2;

 	}

 	public void setUserAddress2(String userAddress2) {
 		this.userAddress2 = userAddress2;

 	}

 	public int getUserAuthority() {
 		return userAuthority;

 	}

 	public void setUserAuthority(int userAuthority) {
 		System.out.println("start: setUserAuthority()");
 		System.out.println(userAuthority);
 		this.userAuthority = userAuthority;
 		System.out.println("end: setUserAuthority()");

 	}

}
