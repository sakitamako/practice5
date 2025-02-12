package com.diworksdev.practice5.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.diworksdev.practice5.dto.MyPageDTO;
import com.diworksdev.practice5.util.DBConnector;

public class MyPageDAO {

	private DBConnector dbConnector = new DBConnector();
	// ③getConnectionの呼び出し（DBと接続する）
	private Connection connection = dbConnector.getConnection();

	// DBから購入履歴を取得するためのメソッド
	// ①クラス、メソッドの定義
	// DTO型を最後に呼び出し元に渡すので、DTO型を戻り値にしたメソッドを作る
	// Actionクラスの値を引数として受け取る,throws=例外を意図的に起こすことが出来る処理のこと。
	public ArrayList<MyPageDTO> getMyPageDTO() throws SQLException {

		// DTOインスタンス化
		// DTOと会話するためのコード
		ArrayList<MyPageDTO> myPageDTO = new ArrayList<>();


		String sql = "SELECT * FROM login_user_transaction WHERE delete_flag = 0 ORDER BY registered_time DESC";

		// try.catchはjavaの例外処理のための構文
		try {

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			// 下に1行ずらすこと
			// データが存在していれば戻り値を true で返す。存在しなければ falseで返す
			while (resultSet.next()) {

				// LoginDTOインスタンス化
				// DTOと会話するためのコード
				MyPageDTO dto = new MyPageDTO();

				dto.setUserId(resultSet.getInt("id"));
				dto.setUserFamilyName(resultSet.getString("family_name"));
				dto.setUserLastName(resultSet.getString("last_name"));
				dto.setUserFamilyNameKana(resultSet.getString("family_name_kana"));
				dto.setUserLastNameKana(resultSet.getString("last_name_kana"));
				dto.setUserMail(resultSet.getString("mail"));
				dto.setUserGender(resultSet.getString("gender"));
				dto.setUserAuthority(resultSet.getString("authority"));
				dto.setDeleteFlag(resultSet.getInt("delete_flag"));
				dto.setRegisteredTime(resultSet.getTimestamp("registered_time"));
                dto.setUpdateTime(resultSet.getTimestamp("update_time"));


				// dtoに記憶する
				myPageDTO.add(dto);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			connection.close();
		}

		// DTOファイルに格納しているデータをセットする
		return myPageDTO;

	}

}