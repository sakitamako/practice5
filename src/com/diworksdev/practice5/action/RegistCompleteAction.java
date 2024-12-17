package com.diworksdev.practice5.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.diworksdev.practice5.dao.RegistCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class RegistCompleteAction extends ActionSupport implements SessionAware {

	public Map<String, Object> session;
	private RegistCompleteDAO registCompleteDAO = new RegistCompleteDAO();


	// 全てのクラス 変数 変数名(struts) throws=例外を意図的に起こすことが出来る処理のこと。
	@Override
	public String execute() throws SQLException {

		String result = ERROR;

		registCompleteDAO.regist5(session.get("userFamilyName").toString(), session.get("userLastName").toString(),
				session.get("userFamilyNameKana").toString(), session.get("userLastNameKana").toString(),
				session.get("userMail").toString(), session.get("userPassword").toString(),
				session.get("userGender").toString(), session.get("userPostalCode").toString(),
				session.get("userPrefecture").toString(), session.get("userAddress1").toString(),
				session.get("userAddress2").toString(), session.get("userAuthority").toString(),
				session.get("delete_flag").toString());

		result = SUCCESS;

		return result;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

	public RegistCompleteDAO getRegistCompleteDAO() {
		return registCompleteDAO;

	}

	public void setRegistCompleteDAO(RegistCompleteDAO registCompleteDAO) {
		this.registCompleteDAO = registCompleteDAO;

	}

}