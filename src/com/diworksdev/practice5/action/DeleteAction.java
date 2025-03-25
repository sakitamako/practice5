package com.diworksdev.practice5.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.diworksdev.practice5.dao.RegistCompleteDAO;
import com.diworksdev.practice5.dto.UserDTO;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteAction extends ActionSupport implements SessionAware {
    private int userId;
    private UserDTO user;
    private Map<String, Object> session;

    public String execute() {
        RegistCompleteDAO dao = new RegistCompleteDAO();
        try {
            user = dao.getUserById(userId);
            if (user == null) {
                return ERROR; // ユーザーが存在しない場合
            }
            session.put("deleteUser", user); // ユーザー情報をセッションに保存
            return SUCCESS; // 削除確認画面へ
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    // Getter & Setter
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}

