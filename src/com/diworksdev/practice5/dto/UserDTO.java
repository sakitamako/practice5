package com.diworksdev.practice5.dto;

 import java.sql.Timestamp;

 public class UserDTO {
     private int userId;
     private String userFamilyName;
     private String userLastName;
     private String userFamilyNameKana;
     private String userLastNameKana;
     private String userMail;
     private String userPassword;
     private String maskedPassword; // 追加
     private String userGender;
     private String userPostalCode;
     private String userPrefecture;
     private String userAddress1;
     private String userAddress2;
     private String userAuthority;
     private int deleteFlag;
     private Timestamp registeredTime;
     private Timestamp updateTime;
     private int passwordLength;

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

     public String getMaskedPassword() {
         return maskedPassword;
     }

     public void setMaskedPassword(int passwordLength) {
         StringBuilder masked = new StringBuilder();
         for (int i = 0; i < passwordLength; i++) {
             masked.append("●");
         }
         this.maskedPassword = masked.toString();
     }

     public String getUserGender() {
         return userGender;
     }

     public void setUserGender(String userGender) {
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

     public Timestamp getRegisteredTime() {
         return registeredTime;
     }

     public void setRegisteredTime(Timestamp registeredTime) {
         this.registeredTime = registeredTime;
     }

     public Timestamp getUpdateTime() {
         return updateTime;
     }

     public void setUpdateTime(Timestamp updateTime) {
         this.updateTime = updateTime;
     }

     public int getPasswordLength() {
         return passwordLength;
     }

     public void setPasswordLength(int passwordLength) {
         this.passwordLength = passwordLength;
         setMaskedPassword(passwordLength);
     }
 }
