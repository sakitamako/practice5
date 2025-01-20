package com.diworksdev.practice5.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import com.diworksdev.practice5.dao.AccountListDAO;
import com.diworksdev.practice5.dto.AccountListDTO;
import com.opensymphony.xwork2.ActionSupport;

public class AccountListAction extends ActionSupport {

    private Map<String, Object> session; // セッション情報
    private AccountListDAO accountListDAO = new AccountListDAO(); // DAOインスタンス
    private ArrayList<AccountListDTO> accountListDTO = new ArrayList<>(); // DTOリスト
    private String delete_flag; // 削除フラグ
    private String message; // 操作結果メッセージ

    public String execute() {
        // ログイン確認
        if (!session.containsKey("login_user_id")) {
            return ERROR;
        }

        try {
            if (delete_flag == null) {
                loadAccountList();
            } else if ("1".equals(delete_flag)) {
                deleteAccounts();
            }
        } catch (SQLException e) {
            addActionError("データベースエラーが発生しました：" + e.getMessage());
            return ERROR;
        }

        return SUCCESS;
    }

    /**
     * アカウント情報の読み込み
     * @throws SQLException データベース接続エラー
     */
    private void loadAccountList() throws SQLException {
        String itemTransactionId = session.get("id").toString();
        String userMasterId = session.get("login_user_id").toString();
        accountListDTO = accountListDAO.getAccountListUserInfo(itemTransactionId, userMasterId);

        if (accountListDTO.isEmpty()) {
            setMessage("登録されたアカウント情報がありません。");
        }
    }

    /**
     * アカウント情報の削除
     * @throws SQLException データベース接続エラー
     */
    private void deleteAccounts() throws SQLException {
        String itemTransactionId = session.get("id").toString();
        String userMasterId = session.get("login_user_id").toString();

        int deleteCount = accountListDAO.deleteAccounts(itemTransactionId, userMasterId);
        if (deleteCount > 0) {
            setMessage(deleteCount + "件のアカウント情報を削除しました。");
        } else {
            setMessage("削除対象のアカウント情報が見つかりませんでした。");
        }
    }

    // Getter and Setter
    public void setDelete_flag(String delete_flag) {
        this.delete_flag = delete_flag;
    }

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public ArrayList<AccountListDTO> getAccountListDTO() {
        return accountListDTO;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
