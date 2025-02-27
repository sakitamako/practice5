package com.diworksdev.practice5.action;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.diworksdev.practice5.dao.RegistCompleteDAO;
import com.diworksdev.practice5.util.DBConnector;
import com.opensymphony.xwork2.ActionSupport;

public class RegistCompleteAction extends ActionSupport implements SessionAware {

	private String errorMessage;

	public Map<String, Object> session;
	private RegistCompleteDAO registCompleteDAO = new RegistCompleteDAO();

	@Override
	public String execute() throws SQLException {

		String result = ERROR;

		DBConnector dbConnector = new DBConnector();
		Connection con = dbConnector.getConnection();

		try {

			if (con == null) {
				errorMessage = "エラーが発生したためアカウント登録できません。";

				result = ERROR;

			}

			String hashedPassword = null;

				if (session.containsKey("userId") && (int) session.get("userId") > 0) {
					int userId = (int) session.get("userId");
		            String inputPassword = session.get("userPassword").toString();

		            // データベースから既存のパスワードを取得
		            String storedPassword = registCompleteDAO.getUserPasswordById(userId);

		            if (inputPassword.equals("⚫︎⚫︎⚫︎⚫︎")) {
		                // 「⚫︎⚫︎⚫︎⚫︎」のままなら、既存のパスワードを使用
		                hashedPassword = storedPassword;
		            } else {
		                // 新しいパスワードが入力された場合、ハッシュ化
		                hashedPassword = hashPassword(inputPassword);
		            }

					// 更新処理
					registCompleteDAO.updateUser((int) session.get("userId"), session.get("userFamilyName").toString(),
							session.get("userLastName").toString(), session.get("userFamilyNameKana").toString(),
							session.get("userLastNameKana").toString(), session.get("userMail").toString(),
							hashedPassword, session.get("userGender").toString(),
							session.get("userPostalCode").toString(), session.get("userPrefecture").toString(),
							session.get("userAddress1").toString(), session.get("userAddress2").toString(),
							session.get("userAuthority").toString());
				} else {

					registCompleteDAO.regist5(session.get("userFamilyName").toString(),
							session.get("userLastName").toString(), session.get("userFamilyNameKana").toString(),
							session.get("userLastNameKana").toString(), session.get("userMail").toString(),
							hashedPassword, session.get("userGender").toString(),
							session.get("userPostalCode").toString(), session.get("userPrefecture").toString(),
							session.get("userAddress1").toString(), session.get("userAddress2").toString(),
							session.get("userAuthority").toString(), session.get("delete_flag").toString());
				}
				result = SUCCESS;



		}catch(

	SQLException e)
	{
		errorMessage = "アカウント登録中にエラーが発生しました。もう一度お試しください。";
		e.printStackTrace();

	}catch(
	NoSuchAlgorithmException e)
	{
		errorMessage = "パスワードのハッシュ化に失敗しました。";
		e.printStackTrace();

	}catch(
	Exception e)
	{
		errorMessage = "予期しないエラーが発生しました。";
		e.printStackTrace();

	}

	return result;
	}

	/**
	 * パスワードをSHA-256でハッシュ化するメソッド
	 *
	 * @param password
	 *            平文のパスワード
	 * @return ハッシュ化された文字列
	 * @throws NoSuchAlgorithmException
	 */
	private String hashPassword(String userPassword) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		byte[] hashedBytes = md.digest(userPassword.getBytes());
		// ハッシュ値を16進数文字列に変換
		StringBuilder sb = new StringBuilder();
		for (byte b : hashedBytes) {
			sb.append(String.format("%02x", b));
		}
		return sb.toString();
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

	public String getErrorMessage() {
		return errorMessage;

	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;

	}

}
