package com.diworksdev.practice5.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.diworksdev.practice5.dto.UserDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateConfirmAction extends ActionSupport implements SessionAware {

	private UserDTO user; // 確認画面に表示するユーザーデータ
	private Map<String, Object> session;
	private String userPassword; // 入力されたパスワード
	private String maskedPassword; // 伏せ字パスワード
	private boolean isPasswordChanged; // パスワード変更フラグ
	// フォームから受け取るフィールド
	private String userFamilyName;
	private String userLastName;
	private String userFamilyNameKana;
	private String userLastNameKana;
	private String userMail;
	private String userGender;
	private String userPostalCode;
	private String userPrefecture;
	private String userAddress1;
	private String userAddress2;
	private String userAuthority;

	@Override
	public String execute() {
	    if (session == null || !session.containsKey("user")) {
	        addActionError("セッションが切れています。もう一度やり直してください。");
	        return ERROR;
	    }

	    // セッションからユーザーデータを取得
	    Object sessionUser = session.get("user");
	    if (sessionUser instanceof UserDTO) {
	        user = (UserDTO) sessionUser;
	    } else {
	        addActionError("ユーザー情報が取得できませんでした。");
	        return ERROR;
	    }

	    // 画面から送信されたデータを `user` にセット（例）
	    user.setUserFamilyName(userFamilyName);
	    user.setUserLastName(userLastName);
	    user.setUserFamilyNameKana(userFamilyNameKana);
	    user.setUserLastNameKana(userLastNameKana);
	    user.setUserMail(userMail);
	    user.setUserPassword(userPassword);  // ここで入力されたパスワードを設定
	    user.setUserGender(userGender);
	    user.setUserPostalCode(userPostalCode);
	    user.setUserPrefecture(userPrefecture);
	    user.setUserAddress1(userAddress1);
	    user.setUserAddress2(userAddress2);
	    user.setUserAuthority(userAuthority);

	    // ここで新しい情報が正しく `user` にセットされているか確認
	    System.out.println("===== UpdateConfirmAction: 更新されたユーザー情報 =====");
	    System.out.println("姓: " + user.getUserFamilyName());
	    System.out.println("名: " + user.getUserLastName());
	    System.out.println("カナ（姓）: " + user.getUserFamilyNameKana());
	    System.out.println("カナ（名）: " + user.getUserLastNameKana());
	    System.out.println("メール: " + user.getUserMail());
	    System.out.println("パスワード: " + user.getUserPassword()); // 実際のパスワード
	    System.out.println("性別: " + user.getUserGender());
	    System.out.println("郵便番号: " + user.getUserPostalCode());
	    System.out.println("都道府県: " + user.getUserPrefecture());
	    System.out.println("住所1: " + user.getUserAddress1());
	    System.out.println("住所2: " + user.getUserAddress2());
	    System.out.println("権限: " + user.getUserAuthority());

	    int storedPasswordLength = user.getPasswordLength();

	    // パスワードの入力有無を判定
	    if (userPassword != null && !userPassword.isEmpty()) {
	        // 変更された場合、新しいパスワードの長さ分「●」を生成
	        isPasswordChanged = true;
	        maskedPassword = generateMaskedPassword(userPassword.length());
	    } else {
	        // 変更なし → 既存パスワードの長さ分「●」を生成
	        isPasswordChanged = false;
	        maskedPassword = generateMaskedPassword(storedPasswordLength);
	        userPassword = user.getUserPassword(); // 既存パスワードを維持
	    }

	    // パスワードの長さ分だけ ● を生成
	    // ここでは実際のパスワードを保存する
	    session.put("user", user);
	    session.put("maskedPassword", maskedPassword); // 伏せ字パスワードを保存

	    return SUCCESS;
	}

	private String generateMaskedPassword(int length) {
	    StringBuilder masked = new StringBuilder();
	    for (int i = 0; i < length; i++) {
	        masked.append("●");
	    }
	    return masked.toString();
	}



	// ゲッター・セッター
	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getMaskedPassword() {
		return maskedPassword;
	}

	public void setMaskedPassword(String maskedPassword) {
		this.maskedPassword = maskedPassword;
	}

	public boolean getIsPasswordChanged() {
		return isPasswordChanged;
	}

	public void setIsPasswordChanged(boolean isPasswordChanged) {
		this.isPasswordChanged = isPasswordChanged;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
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

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
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

	public String getUserAuthority() {
		return userAuthority;
	}

	public void setUserAuthority(String userAuthority) {
		this.userAuthority = userAuthority;
	}

}