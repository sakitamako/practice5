package com.diworksdev.practice5.dto;
import java.text.SimpleDateFormat;
import java.util.Date;

//SimpleDateFormat → 日付 (Date) を特定のフォーマット (yyyy-MM-dd) で文字列として出力するために使用。
//Date → データベースの TIMESTAMP 型 (registered_time や update_time) を扱うために使用。


public class MyPageDTO {

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
    private int deleteFlag;
    private Date updateTime;
    private Date registeredTime;

 // 日付フォーマット用
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
//  SimpleDateFormat を yyyy-MM-dd のフォーマットで初期化。
//  static final なので、クラス共通で使えるフォーマット を定義している。

//	getter（フォーマット済みで返す）
//  registeredTime が null でない場合 → sdf.format(registeredTime) で yyyy-MM-dd の文字列に変換して返す。
//  null の場合 → 空文字 ("") を返す。（NullPointerException 防止）
    public String getRegisteredTime() {
        return (registeredTime != null) ? sdf.format(registeredTime) : "";
    }

//  updateTime を yyyy-MM-dd 形式の文字列として返す。
//  null の場合は空文字を返す。
    public String getUpdateTime() {
        return (updateTime != null) ? sdf.format(updateTime) : "";
    }

    // setter
    public void setRegisteredTime(Date registeredTime) {
        this.registeredTime = registeredTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }


//  各フィールドの値を取得 (getXXX()) するメソッドと、設定 (setXXX()) するメソッド。
//  setXXX() は this.フィールド名 = 引数; でフィールドを更新。
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
        this.userGender = userGender;
    }

    public String getUserPostalCode() {
		return userPostalCode;
	}

	public void setUserPostalCode(String userPostalCode) {
		this.userPostalCode = userPostalCode;
	}

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
        this.userAuthority = userAuthority;
    }

    public int getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(int deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

}