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

	//Listインタフェースのサイズ変更可能な配列の実装です。
	//リストのオプションの操作をすべて実装し、nullを含むすべての要素を許容します。
	//このクラスは、Listインタフェースを実装するほか、リストを格納するために内部的に使われる配列のサイズを操作するメソッドを提供します
	//ArrayList とは、 Listインタフェース を実装した コレクションクラス である。
	//ArrayList は、 Array という名にあるように配列のような感覚で扱うことができる。
	//配列 には格納できる 要素数が決まっている が、 ArrayList は 要素数は決まっていない 。
	//ArrayList は、 プリミティブ型（int, booleanなど） を入れられない。
	private ArrayList<MyPageDTO> myPageDTO;

	public String execute() {

		MyPageDAO dao = new MyPageDAO();

		try {
			myPageDTO = dao.getMyPageDTO();

			if (myPageDTO.isEmpty()) {
                System.out.println("データが取得できませんでした");
            } else {
                System.out.println("取得データ: " + myPageDTO);
            }

            session.put("myPageDTO", myPageDTO);

        } catch (SQLException e) {
            e.printStackTrace();

            return ERROR;
        }
        return SUCCESS;
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



}
