package com.diworksdev.practice5.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.diworksdev.practice5.dao.MyPageDAO;
import com.diworksdev.practice5.dto.MyPageDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MyPageAction extends ActionSupport implements SessionAware {

	//Map<String, Object>=キーを値にマッピングするオブジェクト。
	//マップには、同一のキーを複数登録できない。各キーは1つの値にしかマッピングできません。
    //このインタフェースは、インタフェースというよりむしろ完全に抽象クラスであったDictionaryクラスに代わるものです
	//全てのクラス 変数 変数名
	public Map<String, Object> session;

	//②DTOとDAOのインスタンス化（コピーして値を代入）
	private MyPageDAO myPageDAO = new MyPageDAO();

	//Listインタフェースのサイズ変更可能な配列の実装です。
	//リストのオプションの操作をすべて実装し、nullを含むすべての要素を許容します。
	//このクラスは、Listインタフェースを実装するほか、リストを格納するために内部的に使われる配列のサイズを操作するメソッドを提供します
	//ArrayList とは、 Listインタフェース を実装した コレクションクラス である。
	//ArrayList は、 Array という名にあるように配列のような感覚で扱うことができる。
	//配列 には格納できる 要素数が決まっている が、 ArrayList は 要素数は決まっていない 。
	//ArrayList は、 プリミティブ型（int, booleanなど） を入れられない。
	private ArrayList<MyPageDTO> myPageList = new ArrayList<MyPageDTO>();

	//フィールド変数
	//JSPから受け取る値
	//※必ずJSPでの定義と同じ名前にする
	//このクラスのみ 変数 変数名
	private String deleteFlg;
	private String message;

	//全てのクラス 変数 変数名(struts) throws=例外を意図的に起こすことが出来る処理のこと。
	public String execute() throws SQLException {

		//履歴の削除がされているか否か、チェックをしています。
		//もしdeleteFlgとnullが等しい場合はDBから取得した履歴情報を、「myPageList」に格納しています
		if (deleteFlg == null) {

			//sessionに記憶しているIDとlogin_user_idを取得してテキストで表す文字列を返す
			//item_transaction_idとuser_master_idはDBに問い合わせて受け取ったデータ
			String userFamilyName = session.get("userFamilyName").toString();


			//DBから取得した履歴情報を、「myPageList」に格納しています
			myPageList = myPageDAO.getMyPageUserInfo(userFamilyName);

		}

		//resultに上記処理結果を代入
		String result = SUCCESS;

		//resultにSUCCESS代入＝myPage.jspに遷移する、商品情報を正しく削除しました。や商品情報の削除に失敗しました。を表示する
		return result;

	}


	//外部のSETをここに代入して元々の値を外部から持ってきた値に変えて格納する
	//フィールド変数に対応したgetterとsetterを定義
	//受け取ったテーブルの値を自身のdeleteFlgフィールドに格納
	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg = deleteFlg;

	}

	//外部のSETをここに代入して元々の値を外部から持ってきた値に変えて格納する
	//フィールド変数に対応したgetterとsetterを定義
	//受け取ったテーブルの値を自身のsessionフィールドに格納
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

	//外部からここにアクセスして、外部にデータを渡している
	//フィールド変数に対応したgetterとsetterを定義
	//DTOから戻り値として受け取った、myPageListフィールドの値をmyPage.jspに渡している
	public ArrayList<MyPageDTO> getMyPageList() {
		return this.myPageList;

	}

	//外部からここにアクセスして、外部にデータを渡している
	//フィールド変数に対応したgetterとsetterを定義
	//受け取った値の代わりにmessageフィールドの値をmyPage.jspに渡している
	public String getMessage() {
		return this.message;

	}

	//外部のSETをここに代入して元々の値を外部から持ってきた値に変えて格納する
	//フィールド変数に対応したgetterとsetterを定義
	//受け取ったテーブルの値を自身のmessageフィールドに格納
	public void setMessage(String message) {
		this.message = message;

	}

}
