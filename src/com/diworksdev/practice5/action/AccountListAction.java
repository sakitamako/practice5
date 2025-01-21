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

	public String execute() {


            if (delete_flag == null) {
                loadAccountList();

            } else if ("1".equals(delete_flag)) {

                deleteAccounts();

            }

	}

	/**
	 * アカウント情報の読み込み
	 *
	 * @throws SQLException
	 *             データベース接続エラー
	 */
	private void loadAccountList() throws SQLException {
		String itemTransactionId = session.get("id").toString();

		accountListDTO = accountListDAO.getAccountListUserInfo(itemTransactionId);

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

}
