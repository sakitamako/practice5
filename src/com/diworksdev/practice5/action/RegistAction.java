package com.diworksdev.practice5.action;

import java.sql.SQLException;

import com.diworksdev.practice5.dao.RegistCompleteDAO;
import com.diworksdev.practice5.dto.MyPageDTO;
import com.opensymphony.xwork2.ActionSupport;

public class RegistAction extends ActionSupport {

	private int userId;
	private String userFamilyName;
	private String userLastName;
	private String userFamilyNameKana;
	private String userLastNameKana;
	private String userMail;
	private String userPassword;
	private int userGender;
	private String userPostalCode;
//	private String userPostalCodeCheck;
	private String userPrefecture;
	private String userAddress1;
	private String userAddress2;
	private int userAuthority;

	@Override
	public String execute() {
		// userId が 0 の場合は新規登録、それ以外なら更新処理（データ取得）
        if (userId > 0) {
            // DAO を使って userId に該当するユーザー情報を取得
            RegistCompleteDAO dao = new RegistCompleteDAO();
            MyPageDTO user = null;

            try {
				user = dao.getUserById(userId);
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

            if (user != null) {
                // 取得した情報をセット
                this.userFamilyName = user.getUserFamilyName();
                this.userLastName = user.getUserLastName();
                this.userFamilyNameKana = user.getUserFamilyNameKana();
                this.userLastNameKana = user.getUserLastNameKana();
                this.userMail = user.getUserMail();
                this.userGender = user.getUserGender();
                this.userPostalCode = user.getUserPostalCode();
                this.userPrefecture = user.getUserPrefecture();
                this.userAddress1 = user.getUserAddress1();
                this.userAddress2 = user.getUserAddress2();
                this.userAuthority = user.getUserAuthority();
            }
        }

        return SUCCESS;
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
//		if (userPostalCode == null) {
//	        System.out.println("郵便番号が未入力です");
//
//		}
		this.userPostalCode = userPostalCode;
		System.out.println("end: setUserPostalCode()");

	}
/*
 	public String getUserPostalCodeCheck() {
 		return userPostalCodeCheck;

 	}

 	public void setUserPostalCodeCheck(String userPostalCodeCheck) {
 		System.out.println("start: setUserPostalCodeCheck()");
 		System.out.println(userPostalCodeCheck);
 		this.userPostalCodeCheck = userPostalCodeCheck;
 		System.out.println("end: setUserPostalCodeCheck()");

 	}
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
