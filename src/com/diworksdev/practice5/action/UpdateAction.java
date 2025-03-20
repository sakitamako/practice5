package com.diworksdev.practice5.action;

 import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.diworksdev.practice5.dao.RegistCompleteDAO;
import com.diworksdev.practice5.dto.UserDTO;
import com.opensymphony.xwork2.ActionSupport;

 public class UpdateAction extends ActionSupport implements SessionAware {
     private int userId;
     private UserDTO user;
     private Map<String, Object> session; // セッション管理用
     private RegistCompleteDAO dao = new RegistCompleteDAO(); // DAOをクラス変数として定義

     @Override
     public String execute() {

     	// 確認画面から戻ってきた場合、セッションの `user` を使用
         if (session.containsKey("user")) {
             user = (UserDTO) session.get("user");
             return SUCCESS;
         }

         if (userId <= 0) { // IDが不正な場合はエラー
             addActionError("ユーザーIDが不正です。");
             return ERROR;
         }

         try {
             user = dao.getUserById(userId); // DBからユーザー情報を取得
             if (user == null) {
                 addActionError("指定されたユーザーが見つかりません。");
                 return ERROR;
             }

             // 取得したユーザー情報をセッションに保存
             session.put("user", user);

         } catch (Exception e) {
             addActionError("データ取得中にエラーが発生しました。");
             e.printStackTrace();
             return ERROR;
         }
         return SUCCESS;
     }

     // ゲッターとセッター
     public int getUserId() {
         return userId;
     }

     public void setUserId(int userId) {
         this.userId = userId;
     }

     public UserDTO getUser() {
         return user;
     }

     public void setUser(UserDTO user) {
         this.user = user;
     }

     @Override
     public void setSession(Map<String, Object> session) {
         this.session = session;
     }
 }
