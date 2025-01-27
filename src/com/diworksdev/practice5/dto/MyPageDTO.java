package com.diworksdev.practice5.dto;

public class MyPageDTO {

    private String id;
    private String family_name;
    private String last_name;
    private String family_name_kana;
    private String last_name_kana;
    private String mail;
    private String gender;
    private String authority;
    private String delete_flag;
    private String registered_time;
    private String update_time;

    // Getter and Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFamily_name() {
        return family_name;
    }

    public void setFamily_name(String family_name) {
        this.family_name = family_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFamily_name_kana() {
        return family_name_kana;
    }

    public void setFamily_name_kana(String family_name_kana) {
        this.family_name_kana = family_name_kana;
    }

    public String getLast_name_kana() {
        return last_name_kana;
    }

    public void setLast_name_kana(String last_name_kana) {
        this.last_name_kana = last_name_kana;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
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

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }
}