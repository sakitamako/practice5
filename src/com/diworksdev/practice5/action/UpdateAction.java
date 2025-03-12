package com.diworksdev.practice5.action;

import com.diworksdev.practice5.dao.RegistCompleteDAO;
import com.diworksdev.practice5.dto.UserDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateAction extends ActionSupport {
    private int userId;
    private UserDTO user;

    public String execute() {
        RegistCompleteDAO dao = new RegistCompleteDAO();
        try {
            user = dao.getUserById(userId); // DBからユーザー情報を取得
            if (user == null) {
                return ERROR;
            }
        } catch (Exception e) {
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

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
}
