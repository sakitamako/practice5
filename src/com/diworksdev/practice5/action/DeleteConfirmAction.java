package com.diworksdev.practice5.action;

 import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.diworksdev.practice5.dto.UserDTO;
import com.opensymphony.xwork2.ActionSupport;

 public class DeleteConfirmAction extends ActionSupport implements SessionAware {
     private Map<String, Object> session;
     private UserDTO user;

     public String execute() {
     	if (session.containsKey("deleteUser")) {
             user = (UserDTO) session.get("deleteUser"); // セッションからユーザー情報を取得
             return SUCCESS;
         }
         return ERROR;
     }


     public UserDTO getUser() {
         return user;

     }

     public void setSession(Map<String, Object> session) {
         this.session = session;

     }

 }