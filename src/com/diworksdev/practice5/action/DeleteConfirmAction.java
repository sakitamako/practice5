package com.diworksdev.practice5.action;

import com.diworksdev.practice5.dao.RegistCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteConfirmAction extends ActionSupport {
    private int userId;

    public String execute() {
        RegistCompleteDAO dao = new RegistCompleteDAO();
        try {
            int result = dao.deleteAccount(userId);
            if (result == 0) {
                return ERROR; // 削除失敗時
            }
            return SUCCESS; // 削除完了画面へ
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
}
