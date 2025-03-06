package com.diworksdev.practice5.action;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.diworksdev.practice5.dao.RegistCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class RegistCompleteAction extends ActionSupport implements SessionAware {

    private String errorMessage;
    public Map<String, Object> session;
    private RegistCompleteDAO registCompleteDAO = new RegistCompleteDAO();

    @Override
    public String execute() throws SQLException {
        String result = ERROR;

        try {
            String hashedPassword = null;

            if (session.containsKey("userId") && (int) session.get("userId") > 0) {
                int userId = (int) session.get("userId");
                String inputPassword = session.get("userPassword").toString();

                // データベースから既存のパスワードを取得
                String storedPassword = registCompleteDAO.getUserPasswordById(userId);

                if (inputPassword.equals("⚫︎⚫︎⚫︎⚫︎")) {
                    hashedPassword = storedPassword;
                } else {
                    hashedPassword = hashPassword(inputPassword);
                }

                // 更新処理
                registCompleteDAO.updateUser(userId, session.get("userFamilyName").toString(),
                        session.get("userLastName").toString(), session.get("userFamilyNameKana").toString(),
                        session.get("userLastNameKana").toString(), session.get("userMail").toString(),
                        hashedPassword, Integer.parseInt(session.get("userGender").toString()),
                        session.get("userPostalCode").toString(), session.get("userPrefecture").toString(),
                        session.get("userAddress1").toString(), session.get("userAddress2").toString(),
                        Integer.parseInt(session.get("userAuthority").toString()));
            } else {
                String userPassword = session.get("userPassword").toString();
                hashedPassword = hashPassword(userPassword);

                registCompleteDAO.regist5(session.get("userFamilyName").toString(),
                        session.get("userLastName").toString(), session.get("userFamilyNameKana").toString(),
                        session.get("userLastNameKana").toString(), session.get("userMail").toString(),
                        hashedPassword, session.get("userGender").toString(),
                        session.get("userPostalCode").toString(), session.get("userPrefecture").toString(),
                        session.get("userAddress1").toString(), session.get("userAddress2").toString(),
                        session.get("userAuthority").toString(), session.get("delete_flag").toString());
            }

            result = SUCCESS;

        } catch (SQLException e) {
            errorMessage = "アカウント登録中にエラーが発生しました。もう一度お試しください。";
            e.printStackTrace();
            result = ERROR;
        } catch (NoSuchAlgorithmException e) {
            errorMessage = "パスワードのハッシュ化に失敗しました。";
            e.printStackTrace();
            result = ERROR;
        } catch (Exception e) {
            errorMessage = "予期しないエラーが発生しました。";
            e.printStackTrace();
            result = ERROR;
        }

        return result;
    }

    private String hashPassword(String userPassword) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hashedBytes = md.digest(userPassword.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte b : hashedBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}

