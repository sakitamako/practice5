package com.diworksdev.practice5.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.diworksdev.practice5.util.DBConnector;
import com.diworksdev.practice5.util.DateUtil;
import com.diworksdev.practice5.util.UpdateUtil;

public class RegistCompleteDAO {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	private DateUtil dateUtil = new DateUtil();
	private UpdateUtil UpdateUtil = new UpdateUtil();

	private String sql = "INSERT INTO login_user_transaction(family_name, last_name, family_name_kana, "
			+ "last_name_kana, mail, password, gender, postal_code, prefecture, address_1, address_2, authority, delete_flag, registered_time, update_time) "
			+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	public void regist5(String userFamilyName, String userLastName, String userFamilyNameKana, String userLastNameKana,
			String userMail, String hashedPassword, String userGender, String userPostalCode, String userPrefecture,
			String userAddress1, String userAddress2, String userAuthority, String delete_flag) throws SQLException {

		try {

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

			} catch (Exception e) {
				e.printStackTrace();

			} finally {

			connection.close();

		}

	}

}
