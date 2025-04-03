package com.diworksdev.practice5.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.diworksdev.practice5.dao.RegistCompleteDAO;
import com.diworksdev.practice5.dto.UserDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateAction extends ActionSupport implements SessionAware {
	private int userId;
	private String userPassword; // パスワードフィールドを追加
	private UserDTO user;
	private Map<String, Object> session;
	private RegistCompleteDAO dao = new RegistCompleteDAO();

	@Override
	public String execute() {
	    if (session.containsKey("user")) {
	        user = (UserDTO) session.get("user");

	        // 確認画面から戻る場合、実際のパスワードを復元
	        if (session.containsKey("userPassword")) {
	            userPassword = (String) session.get("userPassword");
	        }
	        return SUCCESS;
	    }

	    // ユーザー情報を取得し、セッションに保存
	    try {
	        user = dao.getUserById(userId);
	        if (user == null) {
	            addActionError("指定されたユーザーが見つかりません。");
	            return ERROR;
	        }

	        session.put("user", user);
	        session.put("userPassword", user.getUserPassword()); // 実際のパスワードをセッションに保存

	        // パスワードをマスク表示用に処理
	        String password = user.getUserPassword(); // 実際のパスワード
	        int passwordLength = password.length();
	        StringBuilder maskedPassword = new StringBuilder();
	        for (int i = 0; i < passwordLength; i++) {
	            maskedPassword.append("●");
	        }
	        session.put("maskedPassword", maskedPassword.toString()); // 伏せ字をセッションに保存

	    } catch (Exception e) {
	        addActionError("データ取得中にエラーが発生しました。");
	        e.printStackTrace();
	        return ERROR;
	    }
	    return SUCCESS;
	}



	// ゲッターとセッター
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
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
