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
	private String maskedPassword;
	private int userGender;
	private String userGenderCheck;
	private String userPostalCode;
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

		// セッションのデータを利用する（新規登録時にはフォーム入力、更新時にはセッションから取得）
		if (userFamilyName == null || userFamilyName.isEmpty()) {
			userFamilyName = (String) session.get("userFamilyName");
		}
		if (userLastName == null || userLastName.isEmpty()) {
			userLastName = (String) session.get("userLastName");
		}
		if (userFamilyNameKana == null || userFamilyNameKana.isEmpty()) {
			userFamilyNameKana = (String) session.get("userFamilyNameKana");
		}
		if (userLastNameKana == null || userLastNameKana.isEmpty()) {
			userLastNameKana = (String) session.get("userLastNameKana");
		}
		if (userMail == null || userMail.isEmpty()) {
			userMail = (String) session.get("userMail");
		}
		if (userPassword == null || userPassword.isEmpty()) {
			userPassword = (String) session.get("userPassword");
		}
		if (userPostalCode == null || userPostalCode.isEmpty()) {
			userPostalCode = (String) session.get("userPostalCode");
		}
		if (userPrefecture == null || userPrefecture.isEmpty()) {
			userPrefecture = (String) session.get("userPrefecture");
		}
		if (userAddress1 == null || userAddress1.isEmpty()) {
			userAddress1 = (String) session.get("userAddress1");
		}
		if (userAddress2 == null || userAddress2.isEmpty()) {
			userAddress2 = (String) session.get("userAddress2");
		}

		// 性別情報を設定
		if (session.containsKey("userGender")) {
			userGender = Integer.parseInt((String) session.get("userGender"));
		}
		userGenderCheck = (userGender == 0) ? "男性" : "女性";
		session.put("userGender", String.valueOf(userGender));

		// 権限情報を設定
		if (session.containsKey("userAuthority")) {
			userAuthority = Integer.parseInt((String) session.get("userAuthority"));
		}
		userAuthorityCheck = (userAuthority == 0) ? "一般" : "管理者";
		session.put("userAuthority", String.valueOf(userAuthority));

		// 削除フラグ情報を設定
		if (session.containsKey("delete_flag")) {
			delete_flag = Integer.parseInt((String) session.get("delete_flag"));
		}
		delete_flagCheck = (delete_flag == 0) ? "有効" : "無効";
		session.put("delete_flag", String.valueOf(delete_flag));

		// パスワードをマスクする
		StringBuilder masked = new StringBuilder();
		for (int i = 0; i < userPassword.length(); i++) {
			masked.append('●');
		}
		maskedPassword = masked.toString();

		return result;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
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

	public String getMaskedPassword() {
		return maskedPassword;
	}

	public String getUserPostalCode() {
		return userPostalCode;
	}

	public void setUserPostalCode(String userPostalCode) {
		this.userPostalCode = userPostalCode;
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
		this.userAuthority = userAuthority;
	}

	public String getUserAuthorityCheck() {
		return userAuthorityCheck;
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
}
