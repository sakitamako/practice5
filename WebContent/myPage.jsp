<!-- このファイルが通常のHTMLファイルではなく、JSPであることを示している -->
<!-- strutsタグ（下の補足参照）を使用する際に記述します。ここでは”s”としてタグを使用 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!-- ユーザー登録機能 -->
<!DOCTYPE html>
<html>
<head>
<!-- 実務で必要になる、検索エンジンに引っかかりやすくなる、どういうコード入力すればより便利になるか -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="imagetoolbar" content="no" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<title>MyPage画面</title>

<style type="text/css">

/* 全体レイアウト */
body {
	margin: 0;
	padding: 20px;
	font-family: Verdana, Helvetica, sans-serif;
	color: #333;
	background: #fff;
}

/* テーブルを画面の中央に配置 */
table {
	width: 80%; /* 必要に応じて調整 */
	margin: 20px auto; /* 水平方向にセンター配置 */
	border-collapse: collapse;
	min-width: 600px;
	border: 1px solid #333;
	text-align: center; /* テーブル内のテキストを中央寄せ */
}

/* 行を中央寄せする */
tr {
	font-weight: normal;
	display: table-row;
	text-align: center;
}

#main {
	border-right: 1px solid #333;
	border-left: 1px solid #333;
}

#main h3 {
	text-align: left;
	margin-left: 10px;
}

#main p {
	font-size: 20px;
	text-align: center;
	border-top: 1px solid #333;
	border-bottom: 1px solid #333;
	padding: 10px 0;
}

/* 操作リンク全体のデザイン */
.action-links {
	display: flex;
	justify-content: center;
	align-items: center;
	gap: 10px;
}

/* 削除と更新の間の仕切り */
.action-links span {
	display: inline-block;
	width: 1px;
	height: 20px;
	background-color: #333;
}

/* リンクのデザイン */
.action-links a {
	text-decoration: none;
	color: #333;
	padding: 5px 10px;
}

.action-links a:hover {
	text-decoration: underline;
}
</style>
</head>
<body>
	<div id="header">
		<div id="pr"></div>
	</div>
	<h1>アカウント一覧画面</h1>
	<div id="main">
		<div id="top">
			<p>ナビゲーションバー</p>
			<h3>アカウント一覧画面</h3>
		</div>
		<div>

			<table border="1">
				<tr>
					<th>Id</th>
					<th>名前（姓）</th>
					<th>名前（名）</th>
					<th>カナ（姓）</th>
					<th>カナ（名）</th>
					<th>メールアドレス</th>
					<th>性別</th>
					<th>アカウント権限</th>
					<th>削除フラグ</th>
					<th>登録日時</th>
					<th>更新日時</th>
					<th>操作</th>
				</tr>
				<s:iterator value="myPageDTO">
					<tr>
						<td><s:property value="userId" /></td>
						<td><s:property value="userFamilyName" /></td>
						<td><s:property value="userLastName" /></td>
						<td><s:property value="userFamilyNameKana" /></td>
						<td><s:property value="userLastNameKana" /></td>
						<td><s:property value="userMail" /></td>
						<td><s:if test="userGender == 0">男性</s:if> <s:else>女性</s:else></td>
						<td><s:if test="userAuthority == 0">一般</s:if> <s:else>管理者</s:else></td>
						<td><s:if test="deleteFlag == 0">有効</s:if> <s:else>無効</s:else></td>
						<td><s:property value="registeredTime" /></td>
						<td><s:property value="updateTime" /></td>
						<td>
							<div class="action-links">
								<!-- 更新ボタンをStrutsのフォームに変更 -->
								<s:form action="UpdateUserAction" method="post">
									<s:hidden name="userId" value="%{userId}" />
									<s:submit value="更新" />
								</s:form>

								<span></span>
								<!-- 仕切り用の縦線 -->

								<!-- 削除ボタン -->
								<s:form action="DeleteUserAction" method="post">
									<s:hidden name="userId" value="%{userId}" />
									<s:submit value="削除" />
								</s:form>
							</div>
						</td>
					</tr>
				</s:iterator>
			</table>
		</div>
		<p>フッター</p>
	</div>
	<div id="footer">
		<div id="pr"></div>
	</div>
</body>
</html>