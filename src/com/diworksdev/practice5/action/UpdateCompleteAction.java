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
	private RegistCompleteDAO dao = new RegistCompleteDAO();

	@Override
	public String execute() {
		try {
			// セッションの内容を出力（デバッグ用）
 			System.out.println("===== UpdateCompleteAction: セッション情報 =====");
 			System.out.println("Session contents: " + session);
 			System.out.println("Retrieving user from session...");

 		// セッションからユーザー情報を取得
 			UserDTO user = (UserDTO) session.get("user");

 			if (user == null) {
 				System.out.println("Error: UserDTO is null");
 				addActionError("更新するデータがありません。");
 				return ERROR;
 			}

 		// 取得した `user` の内容をログ出力
 			System.out.println("----- UpdateCompleteAction: userの内容 -----");
 			System.out.println("ID: " + user.getUserId());
 			System.out.println("姓: " + user.getUserFamilyName());
 			System.out.println("名: " + user.getUserLastName());
 			System.out.println("カナ（姓）: " + user.getUserFamilyNameKana());
 			System.out.println("カナ（名）: " + user.getUserLastNameKana());
 			System.out.println("メール: " + user.getUserMail());
 			System.out.println("パスワード: " + user.getUserPassword());
 			System.out.println("性別: " + user.getUserGender());
 			System.out.println("郵便番号: " + user.getUserPostalCode());
 			System.out.println("都道府県: " + user.getUserPrefecture());
 			System.out.println("住所1: " + user.getUserAddress1());
 			System.out.println("住所2: " + user.getUserAddress2());
 			System.out.println("権限: " + user.getUserAuthority());

 			// ここで、ログの `user` の値が更新されているか確認してください！

 			// パスワードをハッシュ化（新しいパスワードが入力された場合のみ）
 			if (user.getUserPassword() != null && !user.getUserPassword().isEmpty()) {
 				String hashedPassword = hashPassword(user.getUserPassword());
 				user.setUserPassword(hashedPassword);
 			}

 		// データベースを更新
 			int result = dao.updateUser(user.getUserId(), user.getUserFamilyName(), user.getUserLastName(),
 					user.getUserFamilyNameKana(), user.getUserLastNameKana(), user.getUserMail(),
 					user.getUserPassword(), user.getUserGender(), user.getUserPostalCode(), user.getUserPrefecture(),
 					user.getUserAddress1(), user.getUserAddress2(), user.getUserAuthority());

 			System.out.println("Update result: " + result);


 			if (result > 0) {
 				session.put("updateSuccess", true); // 成功フラグをセット
 				return SUCCESS;
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

 	// パスワードをSHA-256でハッシュ化するメソッド
 	private String hashPassword(String password) {
 		try {
 			MessageDigest md = MessageDigest.getInstance("SHA-256");
 			byte[] hash = md.digest(password.getBytes());
 			StringBuilder hexString = new StringBuilder();
 			for (byte b : hash) {
 				hexString.append(String.format("%02x", b));
 			}
 			return hexString.toString();
 		} catch (NoSuchAlgorithmException e) {
 			e.printStackTrace();
 			return null;
 		}

 	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
