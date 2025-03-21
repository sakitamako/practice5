package com.diworksdev.practice5.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.diworksdev.practice5.dao.RegistCompleteDAO;
import com.diworksdev.practice5.dto.UserDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateCompleteAction extends ActionSupport implements SessionAware {
    private Map<String, Object> session;
    private RegistCompleteDAO dao = new RegistCompleteDAO();

    @Override
    public String execute() {
        try {
            // デバッグログ
            System.out.println("Session contents: " + session);
            System.out.println("Retrieving user from session...");

            // セッションからユーザー情報を取得
            UserDTO user = (UserDTO) session.get("user");

            if (user == null) {
                System.out.println("Error: UserDTO is null");
                addActionError("更新するデータがありません。");
                return ERROR;
            }

            System.out.println("Updating User ID: " + user.getUserId());

            // データベースを更新
            int result = dao.updateUser(
                    user.getUserId(),
                    user.getUserFamilyName(),
                    user.getUserLastName(),
                    user.getUserFamilyNameKana(),
                    user.getUserLastNameKana(),
                    user.getUserMail(),
                    user.getUserPassword(),
                    user.getUserGender(),
                    user.getUserPostalCode(),
                    user.getUserPrefecture(),
                    user.getUserAddress1(),
                    user.getUserAddress2(),
                    user.getUserAuthority()
                );

            System.out.println("Update result: " + result);

            if (result > 0) {
                session.put("updateSuccess", true);  // 成功フラグをセット
                return SUCCESS; // 更新成功
            } else {
                System.out.println("Error: Update failed");
                addActionError("更新に失敗しました。");
                return ERROR;
            }
        } catch (Exception e) {
            addActionError("データ更新中にエラーが発生しました。");
            e.printStackTrace();
            return ERROR;
        }
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}

