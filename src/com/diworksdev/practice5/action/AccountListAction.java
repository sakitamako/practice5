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

	public String execute() throws SQLException {

		accountListDTO = accountListDAO.getRegist5(session.get("userId").toString(),
				session.get("userFamilyName").toString(), session.get("userLastName").toString(),
				session.get("userFamilyNameKana").toString(), session.get("userLastNameKana").toString(),
				session.get("userMail").toString(), session.get("userGender").toString(),
				session.get("userAuthority").toString(), session.get("delete_flag").toString(),
				session.get("registered_time").toString(), session.get("update_time").toString());

		String result = SUCCESS;

		return result;

	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public ArrayList<AccountListDTO> getAccountListDTO() {
		return accountListDTO;
	}

}
