package com.diworksdev.practice5.action;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class RegistConfirmAction extends ActionSupport implements SessionAware {

	private String userFamilyName;
	private String userLastName;
	private String userFamilyNameKana;
	private String userLastNameKana;
	private String userMail;
	private String userPassword;
	private int userGender;
	private String userGenderCheck;
	private String userPostalCode;
	//private String userPostalCodeCheck;
	private String userPrefecture;
	private String userAddress1;
	private String userAddress2;
	private int userAuthority;
	private String userAuthorityCheck;
	private int delete_flag;
	private String delete_flagCheck;


	public Map<String, Object> session;

	@Override
	public String execute() {

		String result = SUCCESS;

		if (!(userFamilyName.equals("")) && !(userLastName.equals("")) && !(userFamilyNameKana.equals(""))
				&& !(userLastNameKana.equals("")) && !(userMail.equals("")) && !(userPassword.equals(""))
				&& !(userPostalCode.equals("")) && !(userPrefecture.equals("")) && !(userAddress1.equals("")) && !(userAddress2.equals(""))) {

			session.put("userFamilyName", userFamilyName);
			session.put("userLastName", userLastName);
			session.put("userFamilyNameKana", userFamilyNameKana);
			session.put("userLastNameKana", userLastNameKana);
			session.put("userMail", userMail);
			session.put("userPassword", userPassword);
			session.put("userPostalCode", userPostalCode);
			session.put("userPrefecture", userPrefecture);
			session.put("userAddress1", userAddress1);
			session.put("userAddress2", userAddress2);

		}

		if (userGender == 0) {
			userGenderCheck = "男性";

		} else if (userGender == 1) {
			userGenderCheck = "女性";

		}

		session.put("userGender", userGenderCheck);
		System.out.println("Gender: " + userGenderCheck);

		if (userAuthority == 0) {
			userAuthorityCheck = "一般";

		} else if (userAuthority == 1) {
			userAuthorityCheck = "管理者";

		}

		session.put("userAuthority", userAuthorityCheck);
		System.out.println("Authority: " + userAuthorityCheck);

		if (delete_flag == 0) {
			delete_flagCheck = "有効";

		} else if (delete_flag == 1) {
			delete_flagCheck = "無効";

		}

		session.put("delete_flag", delete_flagCheck);
		System.out.println("delete_flag: " + delete_flagCheck);

		return result;

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

	public String getUserGenderCheck() {
		return userGenderCheck;

	}

	public void setUserGenderCheck(String userGenderCheck) {
		this.userGenderCheck = userGenderCheck;

	}

	public String getUserPostalCode() {
		return userPostalCode;

	}

	public void setUserPostalCode(String userPostalCode) {
		System.out.println("start: setUserPostalCode()");
		System.out.println(userPostalCode);
		this.userPostalCode = userPostalCode;
		System.out.println("end: setUserPostalCode()");

	}
//
//	public String getUserPostalCodeCheck() {
//		return userPostalCodeCheck;
//
//	}
//
//	public void setUserPostalCodeCheck(String userPostalCodeCheck) {
//		this.userPostalCodeCheck = userPostalCodeCheck;
//
//	}

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

	public String getUserAuthorityCheck() {
		return userAuthorityCheck;

	}

	public void setUserAuthorityCheck(String userAuthorityCheck) {
		this.userAuthorityCheck = userAuthorityCheck;

	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

	public int getDelete_flag() {
		return delete_flag;

	}

	public void setDelete_flag(int delete_flag) {
		this.delete_flag = delete_flag;

	}

	public String getDelete_flagCheck() {
		return delete_flagCheck;

	}

	public void setDelete_flagCheck(String delete_flagCheck) {
		this.delete_flagCheck = delete_flagCheck;

	}

}

