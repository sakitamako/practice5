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

        // セッションからユーザーデータを取得
        Object sessionUser = session.get("user");
        if (sessionUser instanceof UserDTO) {
            user = (UserDTO) sessionUser;
        } else {
            addActionError("ユーザー情報が取得できませんでした。");
            return ERROR;
        }

        // 既存のパスワード取得
        String existingPassword = user.getUserPassword();
        String storedPassword = (String) session.get("userPassword"); // セッションにあるパスワード

        // 入力画面でパスワードを変更しなかった場合、セッションのパスワードを使用
        if (existingPassword == null || existingPassword.isEmpty()) {
            if (storedPassword != null) {
                existingPassword = storedPassword;
                user.setUserPassword(existingPassword); // ユーザーオブジェクトにセット
            }
        } else {
            session.put("userPassword", existingPassword); // 新しいパスワードを保存
        }

        // 伏せ字パスワードの作成（StringBuilder を使用）
        if (existingPassword != null && !existingPassword.isEmpty()) {
            maskedPassword = generateMaskedPassword(existingPassword.length());
        } else {
            maskedPassword = "（パスワード未設定）";
        }

        // 伏せ字パスワードをセッションに保存
        session.put("maskedPassword", maskedPassword);

        return SUCCESS;
    }

    /**
     * 指定された長さの伏せ字パスワードを作成する
     */
    private String generateMaskedPassword(int length) {
        StringBuilder masked = new StringBuilder();
        for (int i = 0; i < length; i++) {
            masked.append("●");
        }
        return masked.toString();
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

