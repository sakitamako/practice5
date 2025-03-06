package com.diworksdev.practice5.action;

import com.diworksdev.practice5.dto.UserDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateConfirmAction extends ActionSupport {

	private UserDTO user; // 確認画面に表示するユーザーデータ

	public String execute() {
        // 特にロジックは不要（入力データをそのまま使う）
        return SUCCESS;

	}

	// ゲッターとセッター
    public UserDTO getUser() {
    	return user;
    }

    public void setUser(UserDTO user) {
    	this.user = user;
    }

}