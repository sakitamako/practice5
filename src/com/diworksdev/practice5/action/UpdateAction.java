package com.diworksdev.practice5.action;

import com.diworksdev.practice5.dao.RegistCompleteDAO;
import com.diworksdev.practice5.dto.UserDTO;
import com.opensymphony.xwork2.ActionSupport;



public class UpdateAction extends ActionSupport {

	private int userId;
	private String userFamilyName;
	private String userLastName;
	private String userFamilyNameKana;
	private String userLastNameKana;
	private String userMail;
	private String userPassword;
	private int userGender;
	private String userPostalCode;
	private String userPrefecture;
	private String userAddress1;
	private String userAddress2;
	private int userAuthority;

	private RegistCompleteDAO dao = new RegistCompleteDAO();

	@Override
	public String execute() {

		if (userId <= 0) {
			return SUCCESS; // 新規登録の場合はそのまま画面遷移
		}


		try {
			UserDTO user = dao.getUserById(userId); // DBからユーザー情報を取得

			if (user == null) {
				addActionError("該当するユーザーが見つかりません。");
				return ERROR;
			}

			// ユーザー情報をセット
            setUserDetails(user);

        } catch (Exception e) {
            e.printStackTrace();
            addActionError("ユーザー情報の取得中にエラーが発生しました。");
            return ERROR;
        }

        return SUCCESS;
    }

	private void setUserDetails(UserDTO user) {
        this.userFamilyName = user.getUserFamilyName();
        this.userLastName = user.getUserLastName();
        this.userFamilyNameKana = user.getUserFamilyNameKana();
        this.userLastNameKana = user.getUserLastNameKana();
        this.userMail = user.getUserMail();
        this.userPassword = user.getUserPassword();
        this.userGender = user.getUserGender();
        this.userPostalCode = user.getUserPostalCode();
        this.userPrefecture = user.getUserPrefecture();
        this.userAddress1 = user.getUserAddress1();
        this.userAddress2 = user.getUserAddress2();
        this.userAuthority = user.getUserAuthority();
    }

	// ゲッター・セッター
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserFamilyName() {
		return userFamilyName;

	}

	public void setUserFamilyName(String userFamilyName) {
		this.userFamilyName = userFamilyName;

	}

	public String getUserLastName() {
		return userLastName;

	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;

	}

	public String getUserFamilyNameKana() {
		return userFamilyNameKana;

	}

	public void setUserFamilyNameKana(String userFamilyNameKana) {
		this.userFamilyNameKana = userFamilyNameKana;

	}

	public String getUserLastNameKana() {
		return userLastNameKana;

	}

	public void setUserLastNameKana(String userLastNameKana) {
		this.userLastNameKana = userLastNameKana;

	}

	public String getUserMail() {
		return userMail;

	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;

	}

	public String getUserPassword() {
		return userPassword;

	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;

	}

	public int getUserGender() {
		return userGender;

	}

	public void setUserGender(int userGender) {
		System.out.println("start: setUserGender()");
		System.out.println(userGender);
		this.userGender = userGender;
		System.out.println("end: setUserGender()");

	}

	public String getUserPostalCode() {
		return userPostalCode;

	}

	public void setUserPostalCode(String userPostalCode) {
		System.out.println("start: setUserPostalCode()");
		System.out.println(userPostalCode);
		// if (userPostalCode == null) {
		// System.out.println("郵便番号が未入力です");
		//
		// }
		this.userPostalCode = userPostalCode;
		System.out.println("end: setUserPostalCode()");

	}

	/*
	 * public String getUserPostalCodeCheck() { return userPostalCodeCheck;
	 *
	 * }
	 *
	 * public void setUserPostalCodeCheck(String userPostalCodeCheck) {
	 * System.out.println("start: setUserPostalCodeCheck()");
	 * System.out.println(userPostalCodeCheck); this.userPostalCodeCheck =
	 * userPostalCodeCheck; System.out.println("end: setUserPostalCodeCheck()");
	 *
	 * }
	 */
	public String getUserPrefecture() {
		return userPrefecture;

	}

	public void setUserPrefecture(String userPrefecture) {
		this.userPrefecture = userPrefecture;

	}

	public String getUserAddress1() {
		return userAddress1;

	}

	public void setUserAddress1(String userAddress1) {
		this.userAddress1 = userAddress1;

	}

	public String getUserAddress2() {
		return userAddress2;

	}

	public void setUserAddress2(String userAddress2) {
		this.userAddress2 = userAddress2;

	}

	public int getUserAuthority() {
		return userAuthority;

	}

	public void setUserAuthority(int userAuthority) {
		System.out.println("start: setUserAuthority()");
		System.out.println(userAuthority);
		this.userAuthority = userAuthority;
		System.out.println("end: setUserAuthority()");

	}

}