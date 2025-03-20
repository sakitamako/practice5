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

		int storedPasswordLength = user.getPasswordLength();
		maskedPassword = generateMaskedPassword(storedPasswordLength);

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
		// セッションに保存
		session.put("user", user);
		session.put("maskedPassword", this.maskedPassword);

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