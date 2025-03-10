package com.diworksdev.practice5.action;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.diworksdev.practice5.dao.RegistCompleteDAO;
import com.diworksdev.practice5.dto.UserDTO;
import com.opensymphony.xwork2.ActionSupport;


public class UpdateCompleteAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;
    private UserDTO user;
    private RegistCompleteDAO dao = new RegistCompleteDAO();

    @Override
    public String execute() {
        try {
            // セッションからユーザー情報を取得
            if (session.containsKey("user")) {
                user = (UserDTO) session.get("user");
            } else {
                addActionError("ユーザー情報が見つかりません。");
                return ERROR;
            }

            // パスワードの処理（変更がなければ元のパスワードを使用）
            String storedPassword = dao.getUserPasswordById(user.getUserId());
            String hashedPassword;

            if (user.getUserPassword().equals("⚫︎⚫︎⚫︎⚫︎")) {
                hashedPassword = storedPassword; // 変更なし
            } else {
                hashedPassword = hashPassword(user.getUserPassword()); // 新しいパスワードをハッシュ化
            }

            // DBの更新処理
            int result = dao.updateUser(
                user.getUserId(),
                user.getUserFamilyName(),
                user.getUserLastName(),
                user.getUserFamilyNameKana(),
                user.getUserLastNameKana(),
                user.getUserMail(),
                hashedPassword,
                user.getUserGender(),
                user.getUserPostalCode(),
                user.getUserPrefecture(),
                user.getUserAddress1(),
                user.getUserAddress2(),
                user.getUserAuthority()
            );

            if (result == 0) {
                addActionError("ユーザー情報の更新に失敗しました。");
                return ERROR;
            }

            // 🔹セッションのデータも更新（重要）🔹
            session.put("user", user);

        } catch (NoSuchAlgorithmException e) {
            addActionError("パスワードのハッシュ化に失敗しました。");
            e.printStackTrace();
            return ERROR;
        } catch (Exception e) {
            addActionError("更新処理中にエラーが発生しました。");
            e.printStackTrace();
            return ERROR;
        }

        return SUCCESS;
    }

    // パスワードのハッシュ化メソッド（SHA-256）
    private String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hashedBytes = md.digest(password.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte b : hashedBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}