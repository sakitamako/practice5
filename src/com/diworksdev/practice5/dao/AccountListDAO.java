package com.diworksdev.practice5.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.diworksdev.practice5.dto.AccountListDTO;
import com.diworksdev.practice5.util.DBConnector;

public class AccountListDAO {

		private DBConnector dbConnector = new DBConnector();

		private Connection connection = dbConnector.getConnection();

		public ArrayList<AccountListDTO> getAccountListUserInfo(String item_transaction_id, String user_master_id) throws SQLException {

			ArrayList<AccountListDTO> accountListDTO = new ArrayList<AccountListDTO>();

			//「LEFT JOIN」を用いて複数のテーブルを結合することによってユーザ情報と履歴情報を紐付けて一括して取得することができる
			//④sql文を書く：値は ? を入れておく（どんな値でも使いまわしできるようにするため）
			//SELECT データを抽出する
			//＊ テーブルに含まれる項目全て
			//FROM 〇〇 〇〇という名前のテーブルからデータを選択する
			//WHERE ＜条件＞抽出条件を指定
			//データベースに入ってる条件を満たしたデータがsqlに代入される
			//JOINの左側のテーブルが結合条件に一致しなくてもレコードをは返します
			//ORDER BY=降順に並べ替える
			String sql = "SELECT ubit.id, iit.item_name, ubit.total_price, ubit.total_count, ubit.pay,"
					+ "ubit.insert_date FROM user_buy_item_transaction ubit LEFT JOIN item_info_transaction "
					+ "iit ON ubit.item_transaction_id = iit.id WHERE ubit.item_transaction_id= ? "
					+ "AND ubit.user_master_id= ? ORDER BY insert_date DESC";


				PreparedStatement preparedStatement = connection.prepareStatement(sql);

				preparedStatement.setString(1, item_transaction_id);
				preparedStatement.setString(2, user_master_id);

				ResultSet resultSet = preparedStatement.executeQuery();

				while (resultSet.next()) {


					AccountListDTO dto = new AccountListDTO();

					dto.setUserId(resultSet.getString("id"));
					dto.setUserFamilyName(resultSet.getString("item_name"));
					dto.setUserLastName(resultSet.getString("total_price"));
					dto.setUserFamilyNameKana(resultSet.getString("total_count"));
					dto.setUserLastNameKana(resultSet.getString("pay"));
					dto.setUserMail(resultSet.getString("insert_date"));
					dto.setUserGender(resultSet.getString("item_name"));
					dto.setUserAuthority(resultSet.getString("total_price"));
					dto.setDelete_flag(resultSet.getString("total_count"));
					dto.setRegistered_time(resultSet.getString("pay"));
					dto.setUpdate_time(resultSet.getString("insert_date"));


					AccountListDTO.add(dto);

				}
				return accountListDTO;

		}

}
