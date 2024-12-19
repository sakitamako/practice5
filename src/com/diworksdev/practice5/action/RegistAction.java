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
 // フィールド変数に対応したgetterとsetterを定義
 	// Actionクラスから呼び出され、userNameフィールドの値をActionに渡す
 	public String getUserFamilyNameKana() {
 		return userFamilyNameKana;
 	}
 	// フィールド変数に対応したgetterとsetterを定義
 	// DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のuserNameフィールドに格納
 	public void setUserFamilyNameKana(String userFamilyNameKana) {
 		this.userFamilyNameKana = userFamilyNameKana;
 	}
 	// フィールド変数に対応したgetterとsetterを定義
 	// Actionクラスから呼び出され、loginUserIdフィールドの値をActionに渡す
 	public String getUserLastNameKana() {
 		return userLastNameKana;
 	}
 	// フィールド変数に対応したgetterとsetterを定義
 	// DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のloginUserIdフィールドに格納
 	public void setUserLastNameKana(String userLastNameKana) {
 		this.userLastNameKana = userLastNameKana;
 	}
 	// フィールド変数に対応したgetterとsetterを定義
 	// Actionクラスから呼び出され、loginPasswordフィールドの値をActionに渡す
 	public String getUserMail() {
 		return userMail;
 	}
 	// フィールド変数に対応したgetterとsetterを定義
 	// DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のloginPasswordフィールドに格納
 	public void setUserMail(String userMail) {
 		this.userMail = userMail;
 	}
 	// フィールド変数に対応したgetterとsetterを定義
 	// Actionクラスから呼び出され、userNameフィールドの値をActionに渡す
 	public String getUserPassword() {
 		return userPassword;
 	}
 	// フィールド変数に対応したgetterとsetterを定義
 	// DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のuserNameフィールドに格納
 	public void setUserPassword(String userPassword) {
 		this.userPassword = userPassword;
 	}
 	// フィールド変数に対応したgetterとsetterを定義
 	// Actionクラスから呼び出され、loginUserIdフィールドの値をActionに渡す
 	public int getUserGender() {
 		return userGender;
 	}
 	// フィールド変数に対応したgetterとsetterを定義
 	// DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のloginUserIdフィールドに格納
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

 	// フィールド変数に対応したgetterとsetterを定義
 	// Actionクラスから呼び出され、loginPasswordフィールドの値をActionに渡す
 	public String getUserPostalCodeCheck() {
 		return userPostalCodeCheck;
 	}
 	// フィールド変数に対応したgetterとsetterを定義
 	// DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のloginPasswordフィールドに格納
 	public void setUserPostalCodeCheck(String userPostalCodeCheck) {
 		System.out.println("start: setUserPostalCodeCheck()");
 		System.out.println(userPostalCodeCheck);
 		this.userPostalCodeCheck = userPostalCodeCheck;
 		System.out.println("end: setUserPostalCodeCheck()");
 	}
 	// フィールド変数に対応したgetterとsetterを定義
 	// Actionクラスから呼び出され、userNameフィールドの値をActionに渡す
 	public String getUserPrefecture() {
 		return userPrefecture;
 	}
 	// フィールド変数に対応したgetterとsetterを定義
 	// DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のuserNameフィールドに格納
 	public void setUserPrefecture(String userPrefecture) {
 		this.userPrefecture = userPrefecture;
 	}
 	// フィールド変数に対応したgetterとsetterを定義
 	// Actionクラスから呼び出され、loginUserIdフィールドの値をActionに渡す
 	public String getUserAddress1() {
 		return userAddress1;
 	}
 	// フィールド変数に対応したgetterとsetterを定義
 	// DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のloginUserIdフィールドに格納
 	public void setUserAddress1(String userAddress1) {
 		this.userAddress1 = userAddress1;
 	}
 	// フィールド変数に対応したgetterとsetterを定義
 	// Actionクラスから呼び出され、loginPasswordフィールドの値をActionに渡す
 	public String getUserAddress2() {
 		return userAddress2;
 	}
 	// フィールド変数に対応したgetterとsetterを定義
 	// DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のloginPasswordフィールドに格納
 	public void setUserAddress2(String userAddress2) {
 		this.userAddress2 = userAddress2;
 	}
 	// フィールド変数に対応したgetterとsetterを定義
 	// Actionクラスから呼び出され、userNameフィールドの値をActionに渡す
 	public int getUserAuthority() {
 		return userAuthority;
 	}
 	// フィールド変数に対応したgetterとsetterを定義
 	// DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のuserNameフィールドに格納
 	public void setUserAuthority(int userAuthority) {
 		System.out.println("start: setUserAuthority()");
 		System.out.println(userAuthority);
 		this.userAuthority = userAuthority;
 		System.out.println("end: setUserAuthority()");
 	}


}
