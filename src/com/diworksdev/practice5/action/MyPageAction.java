package com.diworksdev.practice5.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.diworksdev.practice5.dao.MyPageDAO;
import com.diworksdev.practice5.dto.MyPageDTO;
import com.opensymphony.xwork2.ActionSupport;

//SQLException → SQL 実行時の例外を処理するために使用。
//ArrayList → MyPageDTO のデータリストを管理するために使用。
//Map → セッション情報を格納するために使用。
//SessionAware → Struts2 のセッションを扱うためのインターフェース。
//MyPageDAO → データベースとやりとりをする DAO クラス。
//MyPageDTO → 取得したデータを格納する DTO クラス。
//ActionSupport → Struts2 の Action クラスの基本機能を提供するクラス。

public class MyPageAction extends ActionSupport implements SessionAware {
//	ActionSupport を継承しているため、Struts2 のアクションとして動作する。
//	SessionAware を実装することで、セッション管理が可能になる。

	public Map<String, Object> session;
	private ArrayList<MyPageDTO> myPageDTO;
//	session → ユーザーのセッション情報を格納する Map オブジェクト。
//	myPageDTO → MyPageDAO から取得した MyPageDTO のリストを格納。

	public String execute() {
//		Struts2 の execute メソッド。
//		アクションが実行されたときに、このメソッドが呼ばれる。
//		返り値 (String) に SUCCESS または ERROR を返すことで、Struts の画面遷移を制御する。

		MyPageDAO dao = new MyPageDAO();
//		MyPageDAO クラスのインスタンス dao を作成。
//		この dao を使ってデータベースからデータを取得する。

		try {
			myPageDTO = dao.getMyPageDTO();
//			dao.getMyPageDTO() を呼び出し、データを取得して myPageDTO に格納する。
//			getMyPageDTO() メソッドは MyPageDAO クラス内でデータベースから情報を取得する処理を実行する。

			if (myPageDTO.isEmpty()) {
                System.out.println("データが取得できませんでした");
            } else {
                System.out.println("取得データ: " + myPageDTO);
            }
//			myPageDTO が空 (isEmpty()) かどうかを確認。
//			空なら "データが取得できませんでした" を出力。
//			データがあれば "取得データ: [データ内容]" を出力。

            session.put("myPageDTO", myPageDTO);
//            session (セッションの Map) に myPageDTO を保存。
//            これにより、別の画面やアクションでもデータを利用できる。

        } catch (SQLException e) {
            e.printStackTrace();
//            SQLException が発生した場合、エラーメッセージを出力 (e.printStackTrace())。
//            ERROR を返し、エラーページへ遷移するようにする。

            return ERROR;
        }
        return SUCCESS;
    }



	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
//		SessionAware インターフェースの setSession メソッドをオーバーライド。
//		Struts2 によって渡される session オブジェクトを this.session に格納
	}


	public ArrayList<MyPageDTO> getMyPageDTO() {
		return this.myPageDTO;
//		myPageDTO を取得するためのメソッド。
//		Struts2 では get メソッドが JSP で使われるため、データ取得用に定義。

	}

}
