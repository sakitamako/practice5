package com.diworksdev.practice5.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.diworksdev.practice5.dao.RegistCompleteDAO;
import com.diworksdev.practice5.dto.UserDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateAction extends ActionSupport implements SessionAware {
	private int userId;
	private UserDTO user;
	private Map<String, Object> session; // セッション管理用

	@Override
	public String execute() {

		RegistCompleteDAO dao = new RegistCompleteDAO(); // DAOをクラス変数として定義
		try {
			user = dao.getUserById(userId);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} // ←ここでDBから取得
        if (user == null) {
            addActionError("該当ユーザーが見つかりません。");
            return ERROR;
        }

        session.put("user", user); // 入力画面に表示する用
        return SUCCESS;
    }

	// ゲッターとセッター
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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
