package com.diworksdev.practice5.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.diworksdev.practice5.dto.MyPageDTO;
import com.diworksdev.practice5.dto.UserDTO;
import com.diworksdev.practice5.util.DBConnector;
import com.diworksdev.practice5.util.DateUtil;
import com.diworksdev.practice5.util.UpdateUtil;

public class RegistCompleteDAO {

 	private DBConnector dbConnector = new DBConnector();
 	private DateUtil dateUtil = new DateUtil();
 	private UpdateUtil updateUtil = new UpdateUtil();

 	private String sql = "INSERT INTO login_user_transaction(family_name, last_name, family_name_kana, "
 			+ "last_name_kana, mail, password, password_length, gender, postal_code, prefecture, address_1, address_2, authority, delete_flag, registered_time, update_time) "
 			+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

 	// アカウント更新SQL
 	private String sqlUpdate = "UPDATE login_user_transaction SET family_name = ?, last_name = ?, family_name_kana = ?, "
 			+ "last_name_kana = ?, mail = ?, password = ?, password_length = ?, gender = ?, postal_code = ?, prefecture = ?, address_1 = ?, "
 			+ "address_2 = ?, authority = ?, update_time = ? WHERE id = ? AND delete_flag = 0";

 	// アカウント一覧取得SQL
 	private String sqlSelect = "SELECT * FROM login_user_transaction WHERE delete_flag = 0";

 	// アカウント削除SQL（delete_flagを1に更新）
 	private String sqlDelete = "UPDATE login_user_transaction SET delete_flag = 1 WHERE id = ?";

 	// 特定の userId でユーザー情報を取得するSQL
 	private String sqlGetUserById = "SELECT * FROM login_user_transaction WHERE id = ? AND delete_flag = 0";

 	public void regist5(String userFamilyName, String userLastName, String userFamilyNameKana, String userLastNameKana,
 			String userMail, String hashedPassword, String userGender, String userPostalCode, String userPrefecture,
 			String userAddress1, String userAddress2, String userAuthority, String delete_flag) throws SQLException {

 		try {
 			Connection connection = dbConnector.getConnection();
 			PreparedStatement preparedStatement = connection.prepareStatement(sql);

 			preparedStatement.setString(1, userFamilyName);
 			preparedStatement.setString(2, userLastName);
 			preparedStatement.setString(3, userFamilyNameKana);
 			preparedStatement.setString(4, userLastNameKana);
 			preparedStatement.setString(5, userMail);
 			preparedStatement.setString(6, hashedPassword);
 			preparedStatement.setInt(7, hashedPassword.length()); // パスワードの長さを保存
 			preparedStatement.setString(8, userGender);
 			preparedStatement.setString(9, userPostalCode);
 			preparedStatement.setString(10, userPrefecture);
 			preparedStatement.setString(11, userAddress1);
 			preparedStatement.setString(12, userAddress2);
 			preparedStatement.setString(13, userAuthority);
 			preparedStatement.setString(14, delete_flag);
 			preparedStatement.setString(15, dateUtil.getDate());
 			preparedStatement.setString(16, updateUtil.getUpdate());
 			preparedStatement.execute();

 		} catch (SQLException e) {
 			e.printStackTrace();
 			throw e; // 呼び出し元でエラーハンドリングできるようにする
 		}

 	}

 	// ユーザー情報更新メソッド
 	public int updateUser(int userId, String userFamilyName, String userLastName, String userFamilyNameKana,
 			String userLastNameKana, String userMail, String hashedPassword, String userGender, String userPostalCode,
 			String userPrefecture, String userAddress1, String userAddress2, String userAuthority) throws SQLException {

 		int result = 0;

 		try (Connection connection = dbConnector.getConnection();
 				PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdate)) {

 			preparedStatement.setString(1, userFamilyName);
 			preparedStatement.setString(2, userLastName);
 			preparedStatement.setString(3, userFamilyNameKana);
 			preparedStatement.setString(4, userLastNameKana);
 			preparedStatement.setString(5, userMail);
 			preparedStatement.setString(6, hashedPassword);
 			preparedStatement.setInt(7, hashedPassword.length()); // 更新時もパスワードの長さを保存
 			preparedStatement.setString(8, userGender);
 			preparedStatement.setString(9, userPostalCode);
 			preparedStatement.setString(10, userPrefecture);
 			preparedStatement.setString(11, userAddress1);
 			preparedStatement.setString(12, userAddress2);
 			preparedStatement.setString(13, userAuthority);
 			preparedStatement.setString(14, updateUtil.getUpdate());
 			preparedStatement.setInt(15, userId);

 			result = preparedStatement.executeUpdate();
 			System.out.println("Update executed, affected rows: " + result);

 			return result;
 		}
 	}

 	// アカウント一覧取得メソッド
 	public ArrayList<MyPageDTO> getMyPageDTOUserInfo() throws SQLException {
 		ArrayList<MyPageDTO> myPageDTO = new ArrayList<>();

 		try (Connection connection = dbConnector.getConnection();
 				PreparedStatement preparedStatement = connection.prepareStatement(sqlSelect);
 				ResultSet rs = preparedStatement.executeQuery()) {

 			while (rs.next()) {
 				MyPageDTO dto = new MyPageDTO();
 				dto.setUserId(rs.getInt("id"));
 				dto.setUserFamilyName(rs.getString("family_name"));
 				dto.setUserLastName(rs.getString("last_name"));
 				dto.setUserFamilyNameKana(rs.getString("family_name_kana"));
 				dto.setUserLastNameKana(rs.getString("last_name_kana"));
 				dto.setUserMail(rs.getString("mail"));
 				dto.setUserGender(rs.getString("gender"));
 				dto.setUserAuthority(rs.getString("authority"));
 				dto.setDeleteFlag(rs.getInt("delete_flag"));
 				dto.setRegisteredTime(rs.getTimestamp("registered_time"));
 				dto.setUpdateTime(rs.getTimestamp("update_time"));

 				myPageDTO.add(dto);
 			}

 		} catch (SQLException e) {
 			e.printStackTrace();
 			throw e; // 呼び出し元で処理できるようにする
 		}
 		return myPageDTO;
 	}

 	// アカウント削除メソッド
 	public int deleteAccount(int userId) throws SQLException {

 		try (

 				Connection connection = dbConnector.getConnection();
 				PreparedStatement preparedStatement = connection.prepareStatement(sqlDelete)) {

 			preparedStatement.setInt(1, userId);
 			return preparedStatement.executeUpdate();
 		}
 	}

 	// 特定の userId に該当するユーザー情報を取得するメソッド
 	public UserDTO getUserById(int userId) throws SQLException {
 		UserDTO user = null;

 		try (Connection connection = dbConnector.getConnection();
 				PreparedStatement preparedStatement = connection.prepareStatement(sqlGetUserById)) {

 			preparedStatement.setInt(1, userId);
 			ResultSet rs = preparedStatement.executeQuery();

 			if (rs.next()) {
 				user = new UserDTO();
 				user.setUserId(rs.getInt("id"));
 				user.setUserFamilyName(rs.getString("family_name"));
 				user.setUserLastName(rs.getString("last_name"));
 				user.setUserFamilyNameKana(rs.getString("family_name_kana"));
 				user.setUserLastNameKana(rs.getString("last_name_kana"));
 				user.setUserMail(rs.getString("mail"));
 				user.setUserGender(rs.getString("gender"));
 				user.setUserPostalCode(rs.getString("postal_code"));
 				user.setUserPrefecture(rs.getString("prefecture"));
 				user.setUserAddress1(rs.getString("address_1"));
 				user.setUserAddress2(rs.getString("address_2"));
 				user.setUserAuthority(rs.getString("authority"));

 			}
 		}
 		return user;

 	}
 }