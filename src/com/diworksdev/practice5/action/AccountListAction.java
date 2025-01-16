package com.diworksdev.practice5.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import com.diworksdev.practice5.dao.AccountListDAO;
import com.diworksdev.practice5.dto.AccountListDTO;
import com.opensymphony.xwork2.ActionSupport;

public class AccountListAction extends ActionSupport {

	public Map<String, Object> session;

	private AccountListDAO accountListDAO = new AccountListDAO();
	private ArrayList<AccountListDTO> accountListDTO = new ArrayList<AccountListDTO>();

	private String deleteFlg;
	private String message;

	public String execute() throws SQLException {

		if (!session.containsKey("login_user_id")) {

			return ERROR;

		}

		if (deleteFlg == null) {

			String item_transaction_id = session.get("id").toString();
			String user_master_id = session.get("login_user_id").toString();

			accountListDTO = accountListDAO.getAccountListUserInfo(item_transaction_id, user_master_id);

		} else if (deleteFlg.equals("1")) {

			delete();

		}

		String result = SUCCESS;

		return result;

	}

	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg = deleteFlg;

	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

	public ArrayList<AccountListDTO> getAccountListDTO() {
		return this.accountListDTO;

	}

	public String getMessage() {
		return this.message;

	}

	public void setMessage(String message) {
		this.message = message;

	}

}
