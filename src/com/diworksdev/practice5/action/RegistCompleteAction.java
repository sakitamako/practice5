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
	public String execute() {

		String result = ERROR;

		try {

			DBConnector dbConnector = new DBConnector();
			Connection con = dbConnector.getConnection();

			String userPassword = session.get("userPassword") != null ? session.get("userPassword").toString() : "";
			String hashedPassword;

			if (userPassword.isEmpty()) {
			    // ユーザーがパスワードを変更しない場合、既存のハッシュ化されたパスワードを使用
			    hashedPassword = session.get("existingHashedPassword").toString();
			} else {
			    // 新しいパスワードをハッシュ化
			    hashedPassword = hashPassword(userPassword);
			}


			if (con == null) {
				errorMessage = "エラーが発生したためアカウント登録できません。";
				return ERROR;
			}

			// 必要なセッション値のチェック
			if (!session.containsKey("userPassword") || session.get("userPassword") == null) {
				errorMessage = "セッション情報が不足しています。";
				return ERROR;
			}

			if (session.containsKey("userId") && session.get("userId") != null) {
				int userId = (int) session.get("userId");
				if (userId > 0) {
					// 更新処理
					registCompleteDAO.updateUser(userId, String.valueOf(session.get("userFamilyName")),
							String.valueOf(session.get("userLastName")),
							String.valueOf(session.get("userFamilyNameKana")),
							String.valueOf(session.get("userLastNameKana")), String.valueOf(session.get("userMail")),
							hashedPassword, String.valueOf(session.get("userGender")),
							String.valueOf(session.get("userPostalCode")),
							String.valueOf(session.get("userPrefecture")), String.valueOf(session.get("userAddress1")),
							String.valueOf(session.get("userAddress2")), String.valueOf(session.get("userAuthority")));
				}
			} else {

				// 新規登録処理
				registCompleteDAO.regist5(String.valueOf(session.get("userFamilyName")),
						String.valueOf(session.get("userLastName")), String.valueOf(session.get("userFamilyNameKana")),
						String.valueOf(session.get("userLastNameKana")), String.valueOf(session.get("userMail")),
						hashedPassword, String.valueOf(session.get("userGender")),
						String.valueOf(session.get("userPostalCode")), String.valueOf(session.get("userPrefecture")),
						String.valueOf(session.get("userAddress1")), String.valueOf(session.get("userAddress2")),
						String.valueOf(session.get("userAuthority")), String.valueOf(session.get("delete_flag")));
			}
			result = SUCCESS;

		} catch (SQLException e) {
			errorMessage = "データベースエラーが発生しました。";
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			errorMessage = "パスワードのハッシュ化に失敗しました。";
			e.printStackTrace();
		} catch (Exception e) {
			errorMessage = "予期しないエラーが発生しました。";
			e.printStackTrace();
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
