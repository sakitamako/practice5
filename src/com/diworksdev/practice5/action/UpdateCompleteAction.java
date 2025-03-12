package com.diworksdev.practice5.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.diworksdev.practice5.dao.UserDAO;
import com.diworksdev.practice5.dto.UserDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateCompleteAction extends ActionSupport implements SessionAware {

    private Map<String, Object> session;

    @Override
    public String execute() {
        if (!session.containsKey("user")) {
            addActionError("セッション情報が失われました。");
            return ERROR;
        }

        UserDTO user = (UserDTO) session.get("user");
        UserDAO userDAO = new UserDAO();

        try {
            boolean isUpdated = userDAO.updateUser(user);
            if (!isUpdated) {
                addActionError("更新に失敗しました。");
                return ERROR;
            }
        } catch (SQLException e) {
            addActionError("データベースエラーが発生しました。");
            e.printStackTrace();
            return ERROR;
        }

        // 更新が成功したらセッションの情報を削除
        session.remove("user");

        return SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
