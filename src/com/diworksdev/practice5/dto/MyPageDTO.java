package com.diworksdev.practice5.dto;

import java.sql.Timestamp;

public class MyPageDTO {

	private int userId;
    private String userFamilyName;
    private String userLastName;
    private String userFamilyNameKana;
    private String userLastNameKana;
    private String userMail;
    private String userGender;
    private String userAuthority;
    private int deleteFlag;
    private Timestamp updateTime;
    private Timestamp registeredTime;

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

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getUserAuthority() {
        return userAuthority;
    }

    public void setUserAuthority(String userAuthority) {
        this.userAuthority = userAuthority;
    }

    public int getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(int deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public Timestamp getRegisteredTime() {
        return registeredTime;
    }

    public void setRegisteredTime(Timestamp registeredTime) {
        this.registeredTime = registeredTime;
    }

}