package com.diworksdev.practice5.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.diworksdev.practice5.dao.RegistCompleteDAO;
import com.diworksdev.practice5.dto.MyPageDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MyPageAction extends ActionSupport implements SessionAware {

	//Map<String, Object>=キーを値にマッピングするオブジェクト。
	//マップには、同一のキーを複数登録できない。各キーは1つの値にしかマッピングできません。
    //このインタフェースは、インタフェースというよりむしろ完全に抽象クラスであったDictionaryクラスに代わるものです
	//全てのクラス 変数 変数名
	public Map<String, Object> session;

	//②DTOとDAOのインスタンス化（コピーして値を代入）
	private RegistCompleteDAO registCompleteDAO = new RegistCompleteDAO();

	//Listインタフェースのサイズ変更可能な配列の実装です。
	//リストのオプションの操作をすべて実装し、nullを含むすべての要素を許容します。
	//このクラスは、Listインタフェースを実装するほか、リストを格納するために内部的に使われる配列のサイズを操作するメソッドを提供します
	//ArrayList とは、 Listインタフェース を実装した コレクションクラス である。
	//ArrayList は、 Array という名にあるように配列のような感覚で扱うことができる。
	//配列 には格納できる 要素数が決まっている が、 ArrayList は 要素数は決まっていない 。
	//ArrayList は、 プリミティブ型（int, booleanなど） を入れられない。
	private ArrayList<MyPageDTO> myPageDTO = new ArrayList<MyPageDTO>();

	//フィールド変数
	//JSPから受け取る値
	//※必ずJSPでの定義と同じ名前にする
	//このクラスのみ 変数 変数名
	private String delete_flag;
	private String message;

	//全てのクラス 変数 変数名(struts) throws=例外を意図的に起こすことが出来る処理のこと。
	public String execute() {

		// ユーザーがログインしていない場合はエラーを返す
        if (!session.containsKey("login_user_id")) {
            return ERROR;
        }

        try {
            // アカウント削除処理
            if ("1".equals(delete_flag)) {
                String user_id = session.get("login_user_id").toString();
                int result = registCompleteDAO.deleteAccount(Integer.parseInt(user_id));

                if (result > 0) {
                    message = "アカウントを削除しました。";
                } else {
                    message = "アカウント削除に失敗しました。";
                }
            }

            // アカウント一覧取得
            myPageDTO = registCompleteDAO.getMyPageDTOUserInfo();

        } catch (SQLException e) {
            e.printStackTrace();
            return ERROR;
        }

        return SUCCESS;
    }


	//外部のSETをここに代入して元々の値を外部から持ってきた値に変えて格納する
	//フィールド変数に対応したgetterとsetterを定義
	//受け取ったテーブルの値を自身のdeleteFlgフィールドに格納
	public void setDelete_flag(String delete_flag) {
		this.delete_flag = delete_flag;

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
	public ArrayList<MyPageDTO> getMyPageDTO() {
		return this.myPageDTO;

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
