package com.diworksdev.practice5.dto;

public class AccountListDTO {

	private String userId;
	private String userFamilyName;
	private String userLastName;
	private String userFamilyNameKana;
	private String userLastNameKana;
	private String userMail;
	private String userGender;
	private String userAuthority;
	private String delete_flag;
	private String registered_time;
	private String update_time;


	public String getUserId() {
        return userId;

    }
    public void setUserId(String userId) {
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

 	public String getUserGender() {
 		return userGender;

 	}

 	public void setUserGender(String userGender) {
 		System.out.println("start: setUserGender()");
 		System.out.println(userGender);
 		this.userGender = userGender;
 		System.out.println("end: setUserGender()");

 	}

 	public String getUserAuthority() {
 		return userAuthority;

 	}

 	public void setUserAuthority(String userAuthority) {
 		System.out.println("start: setUserAuthority()");
 		System.out.println(userAuthority);
 		this.userAuthority = userAuthority;
 		System.out.println("end: setUserAuthority()");

 	}

 	public String getDelete_flag() {
 		return delete_flag;

 	}

 	public void setDelete_flag(String delete_flag) {
 		this.delete_flag = delete_flag;

 	}

 	public String getRegistered_time() {
 		return registered_time;

 	}

 	public void setRegistered_time(String registered_time) {
 		this.registered_time = registered_time;

 	}

 	public String setUpdate_time() {
        return update_time;

    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;

    }


}
