package com.diworksdev.practice5.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.diworksdev.practice5.dto.MyPageDTO;
import com.diworksdev.practice5.util.DBConnector;

public class MyPageDAO {

		//②DBConnectorのインスタンス化
		//DBへの接続準備、DBと会話するためのコード、これでログインできる
		//Connectionは特定のデータベースとの接続
		private DBConnector dbConnector = new DBConnector();

		//③getConnectionの呼び出し（DBと接続する）
		private Connection connection = dbConnector.getConnection();

		//DBから購入履歴を取得するためのメソッド
		//①クラス、メソッドの定義
		//DTO型を最後に呼び出し元に渡すので、DTO型を戻り値にしたメソッドを作る
		//Actionクラスの値を引数として受け取る,throws=例外を意図的に起こすことが出来る処理のこと。
		public ArrayList<MyPageDTO> getMyPageUserInfo(String userFamilyName) throws SQLException {

			//DTOインスタンス化
			//DTOと会話するためのコード
			ArrayList<MyPageDTO> myPageDTO = new ArrayList<MyPageDTO>();

			//「LEFT JOIN」を用いて複数のテーブルを結合することによってユーザ情報と履歴情報を紐付けて一括して取得することができる
			//④sql文を書く：値は ? を入れておく（どんな値でも使いまわしできるようにするため）
			//SELECT データを抽出する
			//＊ テーブルに含まれる項目全て
			//FROM 〇〇 〇〇という名前のテーブルからデータを選択する
			//WHERE ＜条件＞抽出条件を指定
			//データベースに入ってる条件を満たしたデータがsqlに代入される
			//JOINの左側のテーブルが結合条件に一致しなくてもレコードをは返します
			//ORDER BY=降順に並べ替える
			String sql = "SELECT iit.id, ubit.family_name, ubit.userLastName, ubit.userFamilyNameKana, ubit.userLastNameKana,"
					+ "ubit.userMail, ubit.userGender, ubit.userAuthority, ubit.delete_flag, FROM total_user_transaction"
					+ "ORDER BY registered_time update_time DESC";

			//try.catchはjavaの例外処理のための構文
			try {

				//tryの中にはエラーが発生しそうな処理を書く
				//⑤PreparedStatement（DBまで運んでくれる箱のイメージ）に代入
				PreparedStatement preparedStatement = connection.prepareStatement(sql);

				//⑥sql文の?に入れる値をsetする
				preparedStatement.setString(1, userFamilyName);


				//⑥sql文の?に入れる値をsetする
				ResultSet resultSet = preparedStatement.executeQuery();

				//下に1行ずらすこと
				//データが存在していれば戻り値を true で返す。存在しなければ falseで返す
				while (resultSet.next()) {

					//LoginDTOインスタンス化
					//DTOと会話するためのコード
					MyPageDTO dto = new MyPageDTO();

					//取得した結果を1件ずつDTOに格納し、更にDTOをArrayListに格納している
					dto.setUserId(resultSet.getString("userId"));
					dto.setUserFamilyName(resultSet.getString("userFamilyName"));
					dto.setUserLastName(resultSet.getString("userLastName"));
					dto.setUserFamilyNameKana(resultSet.getString("userFamilyNameKana"));
					dto.setUserLastNameKana(resultSet.getString("userLastNameKana"));
					dto.setUserMail(resultSet.getString("userMail"));
					dto.setUserGender(resultSet.getString("userGender"));
					dto.setUserAuthority(resultSet.getString("userAuthority"));
					dto.setDelete_flag(resultSet.getString("delete_flag"));
					dto.setRegistered_time(resultSet.getString("registered_time"));
					dto.setUpdate_time(resultSet.getString("update_time"));

					//dtoに記憶する
					myPageDTO.add(dto);

				}

				//処理中にSQL関連のエラーが発生した際に実行する処理
				//tryの中でエラーが発生した場合、catchが受け取り
				//例外がスローされる原因となったエラーまたは動作の説明を返す
			} catch(Exception e) {
				e.printStackTrace();

				//DB接続を終了する際、必ず書くメソッド
				//最後に実行されるものを指定するための構文
				//例外が発生しcatchされてもされなくても、共通してやってほしい処理や、やらなければいけない処理を書くところ。
			} finally {

				//⑨con.close()で接続を切る
				//データベースとの接続をクローズ
				//これをしないとデータベースを接続したまま作業が実行されてしまってメモリに負荷がかかる
				connection.close();

			}

			//DTOファイルに格納しているデータをセットする
			return myPageDTO;

		}

		//DBから購入履歴を削除するためのメソッド
		//①クラス、メソッドの定義
		//全てのクラス 整数数値 変数名 引数
		//Actionクラスの値を引数として受け取る,throws=例外を意図的に起こすことが出来る処理のこと。
		public int buyItemHistoryDelete(String item_transaction_id, String user_master_id) throws SQLException {

			//DELETE=削除
			//FROM 〇〇 〇〇という名前のテーブルからデータを選択する
			//WHERE ＜条件＞抽出条件を指定
			//④sql文を書く：値は ? を入れておく（どんな値でも使いまわしできるようにするため）
			String sql = "DELETE FROM user_buy_item_transaction WHERE item_transaction_id= ? AND user_master_id = ?";

			//⑤PreparedStatement（DBまで運んでくれる箱のイメージ）に代入
			PreparedStatement preparedStatement;

			//基本データ型の値0をresultに代入
			int result = 0;

			//tryの中にはエラーが発生しそうな処理を書く
			try {

				//tryの中にはエラーが発生しそうな処理を書く
				//⑤PreparedStatement（DBまで運んでくれる箱のイメージ）に代入
				preparedStatement = connection.prepareStatement(sql);

				//⑥sql文の?に入れる値をsetする
				preparedStatement.setString(1, item_transaction_id);


				//⑥sql文の?に入れる値をsetする
				result = preparedStatement.executeUpdate();

				//処理中にSQL関連のエラーが発生した際に実行する処理
				//tryの中でエラーが発生した場合、catchが受け取り
				//例外がスローされる原因となったエラーまたは動作の説明を返す
			} catch (SQLException e) {
				e.printStackTrace();

				//DB接続を終了する際、必ず書くメソッド
				//最後に実行されるものを指定するための構文
				//例外が発生しcatchされてもされなくても、共通してやってほしい処理や、やらなければいけない処理を書くところ。
			} finally {

				//⑨con.close()で接続を切る
				//データベースとの接続をクローズ
				//これをしないとデータベースを接続したまま作業が実行されてしまってメモリに負荷がかかる
				connection.close();

			}

			//Actionクラスに削除した件数を返す
			return result;


		}

	}
