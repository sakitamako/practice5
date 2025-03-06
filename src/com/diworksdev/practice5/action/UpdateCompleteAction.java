package com.diworksdev.practice5.action;

import com.diworksdev.practice5.dao.RegistCompleteDAO;
import com.diworksdev.practice5.dto.UserDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateCompleteAction extends ActionSupport {

	private UserDTO user;

	public String execute() {
		RegistCompleteDAO dao = new RegistCompleteDAO();
		try {

			int result = dao.updateUser(
					user.getUserId(),
					user.getUserFamilyName(),
					user.getUserLastName(),
					user.getUserFamilyNameKana(),
					user.getUserLastNameKana(),
					user.getUserMail(),
					user.getUserPassword(), // 必要ならハッシュ化
					user.getUserGender(), // int のまま渡す
					user.getUserPostalCode(),
					user.getUserPrefecture(),
					user.getUserAddress1(),
					user.getUserAddress2(),
					user.getUserAuthority());

				if (result == 0) {
					addActionError("ユーザー情報の更新に失敗しました。");
					return ERROR;

				}

		} catch (Exception e) {

			e.printStackTrace();

			addActionError("更新処理中にエラーが発生しました。");
			return ERROR;

		}

		return SUCCESS;

	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}
}
