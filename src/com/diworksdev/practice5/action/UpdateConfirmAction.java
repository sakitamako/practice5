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
	    user.setUserFamilyName(user.getUserFamilyName());
	    user.setUserLastName(user.getUserLastName());
	    user.setUserFamilyNameKana(user.getUserFamilyNameKana());
	    user.setUserLastNameKana(user.getUserLastNameKana());
	    user.setUserMail(user.getUserMail());
	    user.setUserPassword(userPassword);
	    user.setUserGender(user.getUserGender());
	    user.setUserPostalCode(user.getUserPostalCode());
	    user.setUserPrefecture(user.getUserPrefecture());
	    user.setUserAddress1(user.getUserAddress1());
	    user.setUserAddress2(user.getUserAddress2());
	    user.setUserAuthority(user.getUserAuthority());

	    // ここで新しい情報が正しく `user` にセットされているか確認
	    System.out.println("===== UpdateConfirmAction: 更新されたユーザー情報 =====");
	    System.out.println("姓: " + user.getUserFamilyName());
	    System.out.println("名: " + user.getUserLastName());
	    System.out.println("カナ（姓）: " + user.getUserFamilyNameKana());
	    System.out.println("カナ（名）: " + user.getUserLastNameKana());
	    System.out.println("メール: " + user.getUserMail());
	    System.out.println("パスワード: " + user.getUserPassword());
	    System.out.println("性別: " + user.getUserGender());
	    System.out.println("郵便番号: " + user.getUserPostalCode());
	    System.out.println("都道府県: " + user.getUserPrefecture());
	    System.out.println("住所1: " + user.getUserAddress1());
	    System.out.println("住所2: " + user.getUserAddress2());
	    System.out.println("権限: " + user.getUserAuthority());

	    // 最新の `user` をセッションに保存
	    session.put("user", user);
	    System.out.println("UpdateConfirmAction: session に更新データを保存しました");

	    // パスワードの処理
	    int storedPasswordLength = user.getPasswordLength();
	    maskedPassword = generateMaskedPassword(storedPasswordLength);

	    if (userPassword != null && !userPassword.isEmpty()) {
	        isPasswordChanged = true;
	        user.setUserPassword(userPassword);
	        maskedPassword = generateMaskedPassword(userPassword.length());
	    } else {
	        isPasswordChanged = false;
	    }


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

	public boolean getIsPasswordChanged() {
		return isPasswordChanged;
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
}