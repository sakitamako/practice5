package com.diworksdev.practice5.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.diworksdev.practice5.dto.UserDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateConfirmAction extends ActionSupport implements SessionAware {

    private UserDTO user;
    private Map<String, Object> session;

    @Override
    public String execute() {
        // フォームの入力値を取得（JSPのname属性と一致するフィールドが必要）
        if (user != null) {
            session.put("user", user); // セッションにデータを格納
        } else if (session.containsKey("user")) {
            user = (UserDTO) session.get("user"); // セッションからデータを取得
        } else {
            return ERROR; // セッションにもデータがない場合はエラー
        }

        return SUCCESS;
    }

    // ゲッター・セッター
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

