package com.diworksdev.practice5.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.diworksdev.practice5.dto.MyPageDTO;
import com.diworksdev.practice5.util.DBConnector;

public class MyPageDAO {

	// DBから購入履歴を取得するためのメソッド
	// ①クラス、メソッドの定義
	// DTO型を最後に呼び出し元に渡すので、DTO型を戻り値にしたメソッドを作る
	// Actionクラスの値を引数として受け取る,throws=例外を意図的に起こすことが出来る処理のこと。
	public ArrayList<MyPageDTO> getMyPageDTOUserInfo() throws SQLException {

		// DTOインスタンス化
		// DTOと会話するためのコード
		ArrayList<MyPageDTO> myPageDTO = new ArrayList<MyPageDTO>();
		// ②DBConnectorのインスタンス化
		// DBへの接続準備、DBと会話するためのコード、これでログインできる
		// Connectionは特定のデータベースとの接続
		DBConnector dbConnector = new DBConnector();

		// ③getConnectionの呼び出し（DBと接続する）
		Connection con = dbConnector.getConnection();

		String sql = "SELECT * FROM total_user_transaction";

		// try.catchはjavaの例外処理のための構文
		try {

			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			// 下に1行ずらすこと
			// データが存在していれば戻り値を true で返す。存在しなければ falseで返す
			while (rs.next()) {

				// LoginDTOインスタンス化
				// DTOと会話するためのコード
				MyPageDTO dto = new MyPageDTO();

				dto.setUserId(rs.getInt("userId"));
				dto.setUserFamilyName(rs.getString("userFamilyName"));
				dto.setUserLastName(rs.getString("userLastName"));
				dto.setUserFamilyNameKana(rs.getString("userFamilyNameKana"));
				dto.setUserLastNameKana(rs.getString("userLastNameKana"));
				dto.setUserMail(rs.getString("userMail"));
				dto.setUserGender(rs.getString("userGender"));
				dto.setUserAuthority(rs.getString("userAuthority"));
				dto.setUpdateTime(rs.getTimestamp("registered_time"));
				dto.setUpdateTime(rs.getTimestamp("update_time"));

				// dtoに記憶する
				myPageDTO.add(dto);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			con.close();
		}

		// DTOファイルに格納しているデータをセットする
		return myPageDTO;

	}

	// アカウント削除機能
	public int deleteAccount(int userId) throws SQLException {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "UPDATE account SET delete_flag = 1 WHERE id = ?";

		int result = 0;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, userId);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return result;
	}
}
