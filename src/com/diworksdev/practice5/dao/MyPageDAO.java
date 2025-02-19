package com.diworksdev.practice5.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.diworksdev.practice5.dto.MyPageDTO;
import com.diworksdev.practice5.util.DBConnector;

//Connection → データベース接続用クラス。
//PreparedStatement → SQL クエリを実行するためのクラス。
//ResultSet → SQL の結果を格納するクラス。
//SQLException → SQL 実行時のエラー処理用クラス。
//ArrayList → MyPageDTO のデータリストを格納するために使用。
//MyPageDTO → データ取得後の情報を格納する DTO クラス。
//DBConnector → データベース接続を管理するクラス。

public class MyPageDAO {
//	DAO (Data Access Object) クラスであり、データベース操作を担当する。
//	MyPageDAO は login_user_transaction テーブルの情報を取得する機能を提供。

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
//	DBConnector のインスタンスを作成 (dbConnector)。
//	dbConnector.getConnection() を呼び出し、データベース接続 (connection) を確立。
//	DBConnector は、データベースの接続情報 (URL, ユーザー名, パスワードなど) を管理するクラス。



	public ArrayList<MyPageDTO> getMyPageDTO() throws SQLException {
//		login_user_transaction テーブルからデータを取得するメソッド。
//		戻り値 は ArrayList<MyPageDTO> で、取得したユーザー情報のリストを返す。
//		throws SQLException により、SQL 関連の例外をスローする可能性を示す。

		ArrayList<MyPageDTO> myPageDTO = new ArrayList<>();
//		MyPageDTO のオブジェクトを格納するためのリストを作成。
//		SQL の結果をこのリストに追加していく。

		String sql = "SELECT * FROM login_user_transaction WHERE delete_flag = 0 ORDER BY registered_time DESC";
//		delete_flag = 0 のレコード（削除されていないユーザー情報）を取得。
//				ORDER BY registered_time DESC で、新しい登録順に並び替える。

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
//			connection.prepareStatement(sql) で PreparedStatement オブジェクトを作成。
//			executeQuery() で SQL を実行し、結果を resultSet に格納。
//			try ブロックで囲み、SQL 実行中のエラーをキャッチできるようにしている。


			while (resultSet.next()) {
				MyPageDTO dto = new MyPageDTO();
//				while (resultSet.next()) により、取得したデータを 1 行ずつ処理。
//				MyPageDTO のインスタンス dto を作成し、各フィールドにデータをセットする。

				dto.setUserId(resultSet.getInt("id"));
				dto.setUserFamilyName(resultSet.getString("family_name"));
				dto.setUserLastName(resultSet.getString("last_name"));
				dto.setUserFamilyNameKana(resultSet.getString("family_name_kana"));
				dto.setUserLastNameKana(resultSet.getString("last_name_kana"));
				dto.setUserMail(resultSet.getString("mail"));
				dto.setUserPassword(resultSet.getString("password"));
				dto.setUserGender(resultSet.getString("gender"));
				dto.setUserPostalCode(resultSet.getString("postal_code"));
				dto.setUserPrefecture(resultSet.getString("prefecture"));
				dto.setUserAddress1(resultSet.getString("address_1"));
				dto.setUserAddress2(resultSet.getString("address_2"));
				dto.setUserAuthority(resultSet.getString("authority"));
				dto.setDeleteFlag(resultSet.getInt("delete_flag"));
				dto.setRegisteredTime(resultSet.getTimestamp("registered_time"));
                dto.setUpdateTime(resultSet.getTimestamp("update_time"));
//              ResultSet からデータを取得し、dto の各フィールドにセットする。
//              setUserId(resultSet.getInt("id")) → id カラムの値を取得し、userId にセット。
//              他の setXXX() も同様に、対応するカラムの値を取得して DTO にセットする。


				myPageDTO.add(dto);
//				dto を myPageDTO のリストに追加。
//				これにより、すべてのデータが ArrayList に格納される。

			}

		} catch (SQLException e) {
			e.printStackTrace();
//			SQLException が発生した場合、e.printStackTrace(); でエラーログを出力。
//			例外が発生すると、エラーの詳細がコンソールに表示される。

		} finally {
			connection.close();
//			finally ブロックは、try の中で例外が発生しても必ず実行される。
//			connection.close(); でデータベース接続を閉じる。
//			問題点: close() を finally で実行すると、ResultSet や PreparedStatement が開いたままの可能性があるため、try-with-resources を使うとより安全。
		}


		return myPageDTO;
//		取得した MyPageDTO のリストを return で返す。
//				MyPageAction などでこのメソッドを呼び出せば、ユーザー情報を取得できる。

	}

}