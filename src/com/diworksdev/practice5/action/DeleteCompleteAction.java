package com.diworksdev.practice5.action;

 import com.diworksdev.practice5.dao.UserDAO;
import com.opensymphony.xwork2.ActionSupport;

 public class DeleteCompleteAction extends ActionSupport {
     private String userId;

     public void setUserId(String userId) {
         this.userId = userId;
     }

     public String execute() {
         UserDAO userDAO = new UserDAO();
         boolean isDeleted = userDAO.deleteUser(userId);

         if (isDeleted) {
             return SUCCESS; // 削除成功
         } else {
             addActionError("削除に失敗しました。");
             return ERROR; // 削除失敗
         }
     }

 }