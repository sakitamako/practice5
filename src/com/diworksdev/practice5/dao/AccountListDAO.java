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
		public ArrayList<AccountListDTO> getAccountListUserInfo(String item_transaction_id) throws SQLException {

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
			String sql = "SELECT ubit.id, ubit.family_name, ubit.last_name, ubit.family_name_kana, ubit.last_name_kana,"
					+ "ubit.mail, ubit.gender, ubit.authority, ubit.delete_flag, FROM login_user_transaction ubit LEFT JOIN "
					+ "iit ON ubit.item_transaction_id = iit.id WHERE ubit.item_transaction_id= ? "
					+ "AND ubit.user_master_id= ? ORDER BY registered_time, update_time DESC";


				PreparedStatement preparedStatement = connection.prepareStatement(sql);

				preparedStatement.setString(1, item_transaction_id);

				ResultSet resultSet = preparedStatement.executeQuery();

				while (resultSet.next()) {


					AccountListDTO dto = new AccountListDTO();

					dto.setUserId(resultSet.getString("id"));
					dto.setUserFamilyName(resultSet.getString("family_name"));
					dto.setUserLastName(resultSet.getString("last_name"));
					dto.setUserFamilyNameKana(resultSet.getString("family_name_kana"));
					dto.setUserLastNameKana(resultSet.getString("last_name_kana"));
					dto.setUserMail(resultSet.getString("mail"));
					dto.setUserGender(resultSet.getString("gender"));
					dto.setUserAuthority(resultSet.getString("authority"));
					dto.setDelete_flag(resultSet.getString("delete_flag"));
					dto.setRegistered_time(resultSet.getString("registered_time"));
					dto.setUpdate_time(resultSet.getString("update_time"));


					AccountListDTO.add(dto);

				}
				return accountListDTO;

		}

}
