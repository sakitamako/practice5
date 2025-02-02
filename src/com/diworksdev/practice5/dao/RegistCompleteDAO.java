package com.diworksdev.practice5.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.diworksdev.practice5.dto.MyPageDTO;
import com.diworksdev.practice5.util.DBConnector;
import com.diworksdev.practice5.util.DateUtil;
import com.diworksdev.practice5.util.UpdateUtil;

public class RegistCompleteDAO {

	private DBConnector dbConnector = new DBConnector();
	private DateUtil dateUtil = new DateUtil();
	private UpdateUtil UpdateUtil = new UpdateUtil();

	private String sql = "INSERT INTO login_user_transaction(family_name, last_name, family_name_kana, "
			+ "last_name_kana, mail, password, gender, postal_code, prefecture, address_1, address_2, authority, delete_flag, registered_time, update_time) "
			+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	// アカウント一覧取得SQL
	private String sqlSelect = "SELECT * FROM login_user_transaction";

	// アカウント削除SQL（delete_flagを1に更新）
	private String sqlDelete = "UPDATE login_user_transaction SET delete_flag = 1 WHERE id = ?";

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
			preparedStatement.setString(7, userGender);
			preparedStatement.setString(8, userPostalCode);
			preparedStatement.setString(9, userPrefecture);
			preparedStatement.setString(10, userAddress1);
			preparedStatement.setString(11, userAddress2);
			preparedStatement.setString(12, userAuthority);
			preparedStatement.setString(13, delete_flag);
			preparedStatement.setString(14, dateUtil.getDate());
			preparedStatement.setString(15, UpdateUtil.getUpdate());
			preparedStatement.execute();

		} catch (SQLException e) {
            e.printStackTrace();
            throw e; // 呼び出し元でエラーハンドリングできるようにする
        }

	}

	// アカウント一覧取得メソッド
	public ArrayList<MyPageDTO> getMyPageListUserInfo() throws SQLException {
		ArrayList<MyPageDTO> myPageList = new ArrayList<>();

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

				myPageList.add(dto);
			}

		} catch (SQLException e) {
            e.printStackTrace();
            throw e; // 呼び出し元で処理できるようにする
        }
		return myPageList;
	}

	// アカウント削除メソッド
	public int deleteAccount(int userId) throws SQLException {
		int result = 0;

		try (

				Connection connection = dbConnector.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sqlDelete)) {

			preparedStatement.setInt(1, userId);
			result = preparedStatement.executeUpdate();

		} catch (SQLException e) {
            e.printStackTrace();
            throw e; // 呼び出し元でエラーハンドリング
        }

		return result;
	}
}
