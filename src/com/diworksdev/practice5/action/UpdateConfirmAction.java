package com.diworksdev.practice5.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.diworksdev.practice5.dto.UserDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateConfirmAction extends ActionSupport implements SessionAware {

	private UserDTO user; // 確認画面に表示するユーザーデータ
	private Map<String, Object> session;

	@Override
    public String execute() {
        // セッションに保存されたデータを取得
        if (session.containsKey("user")) {
            user = (UserDTO) session.get("user");
        } else {
            addActionError("ユーザー情報が見つかりません。");
            return ERROR;
        }
        return SUCCESS;
    }

    // ゲッターとセッター
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