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

/*  TAG LAYOUT  */
body {
    width: 100%;
	margin: 0;
	padding: 200px;
	line-height: 1.6;
	letter-spacing: 1px;
	font-family: Verdana, Helvetica, sans-serif;
	color: #333;
	background: #fff;
	text-align: center;
}

body input {
	border: 1px solid #333;
}

table {
	margin: 0 auto;
}

/*  ID LAYOUT  */
#top {

	margin-left: 0px;
}

#main {
	border-right: 1px solid #333;
	border-left: 1px solid #333;
}

#main h3 {

	text-align: left;
	margin-left: 10px;
}

#main h4 {

	text-align: center;
	padding-top: 200px;
	padding-bottom: 200px;
}

#main p {

	font-size: 20px;
	text-align: center;
	border-top: 1px solid #333;
	border-bottom: 1px solid #333;
	padding-top: 10px;
	padding-bottom: 10px;
}

th, td {
	border: 1px solid #333;
	padding: 8px;
	text-align: center;

}

th {
	background: #f4f4f4;
}

.center-buttons {
	text-align: center;
}

.center-buttons form {
	display: inline-block;
}

/* ボタン共通スタイル */
input[type="submit"], a {
	background-color: #fff;
	padding: 8px 16px;
	text-decoration: none;
	font-size: 18px;
	border: 1px solid #333;
	cursor: pointer;
}

input[type="submit"]:hover, a:hover {
	background-color: #ddd;
}

/* レスポンシブデザイン */
@media ( max-width : 400px) {
	body {
		font-size: 16px;
		padding: 10px;
	}
	table {
		font-size: 14px;

	}
	input[type="submit"], a {
		font-size: 16px;
		padding: 6px 12px;
	}
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
						<td><s:property value="userGender" /></td>
						<td><s:property value="userAuthority" /></td>
						<td><s:property value="deleteFlag" /></td>
						<td><s:property value="registeredTime" /></td>
						<td><s:property value="updateTime" /></td>
						<td>
							<form action="deleteUserAction" method="post">
								<input type="hidden" name="userId"
									value="<s:property value='userId' />"> <input
									type="submit" value="削除">
							</form>
						</td>
					</tr>
				</s:iterator>
			</table>

			<div class="center-buttons">
				<p>
					Homeへ戻る場合は<a href='<s:url action="HomeAction" />'>こちら</a>
				</p>
			</div>
		</div>
		<p>フッター</p>
	</div>
	<div id="footer">
		<div id="pr"></div>
	</div>
</body>
</html>