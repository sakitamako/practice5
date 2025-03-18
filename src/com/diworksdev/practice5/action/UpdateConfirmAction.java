package com.diworksdev.practice5.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.diworksdev.practice5.dto.UserDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateConfirmAction extends ActionSupport implements SessionAware {

    private UserDTO user; // 確認画面に表示するユーザーデータ
    private Map<String, Object> session;
    private String maskedPassword; // 伏せ字パスワード

    @Override
    public String execute() {
        if (session == null || !session.containsKey("user")) {
            addActionError("セッションが切れています。もう一度やり直してください。");
            return ERROR;
        }

        // セッションからデータを取得し、安全にキャスト
        Object sessionUser = session.get("user");
        if (sessionUser instanceof UserDTO) {
            user = (UserDTO) sessionUser;
        } else {
            addActionError("ユーザー情報が取得できませんでした。データが失われた可能性があります。");
            return ERROR;
        }

     // 確認画面でもデータを維持するために、再度セッションに格納
        session.put("user", user);
        // 確認画面でも伏せ字のまま
        user.setMaskedPassword("●●●●●");

        return SUCCESS;
    }


    // ゲッターとセッター
    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public String getMaskedPassword() {
        return maskedPassword;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}

