package com.diworksdev.practice5.action;

import com.diworksdev.practice5.dao.UserDAO;
import com.diworksdev.practice5.dto.UserDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateCompleteAction extends ActionSupport {
    private int userId;

    public String execute() {
        UserDAO dao = new UserDAO();
        UserDTO userDTO = null;

        try {
            userDTO = dao.getUserById(userId);
        } catch (Exception e) {
            e.printStackTrace();
            addActionError("ユーザー情報の取得に失敗しました。");
            return ERROR;
        }

        if (userDTO == null) {
            addActionError("ユーザーが存在しません。");
            return ERROR;
        }

        // ここで成功メッセージなどを追加可能
        return SUCCESS;
    }
}

