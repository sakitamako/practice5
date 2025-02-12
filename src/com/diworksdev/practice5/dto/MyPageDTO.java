package com.diworksdev.practice5.dto;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    private Date updateTime;
    private Date registeredTime;

 // 日付フォーマット用
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    // getter（フォーマット済みで返す）
    public String getRegisteredTime() {
        return (registeredTime != null) ? sdf.format(registeredTime) : "";
    }

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

}