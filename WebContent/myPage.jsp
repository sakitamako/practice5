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

/* テーブルの横スクロール対応 */
.table-container {
	width: 100%;
	overflow-x: auto;
}

/* テーブルデザイン */
table {
	width: 100%;
	border-collapse: collapse;
	margin: 20px 0;
	min-width: 600px;
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

/* ボタンをリンク風に */
.action-buttons {
	display: flex;
	justify-content: center;
	gap: 10px;
}

.action-buttons form {
	margin: 0;
	display: inline;
}

.action-buttons a, .action-buttons button {
	display: inline-block;
	padding: 5px 10px;
	color: #0066cc;
	text-decoration: none;
	border: none;
	background: none;
	font-size: 16px;
	cursor: pointer;
}

.action-buttons a:hover, .action-buttons button:hover {
	text-decoration: underline;
	color: #004499;
}

/* レスポンシブデザイン */
@media ( max-width : 768px) {
	body {
		font-size: 16px;
		padding: 10px;
	}
	table {
		font-size: 14px;
		min-width: 100%;
	}
	.action-buttons a, .action-buttons button {
		font-size: 14px;
		padding: 4px 8px;
	}
	#main input[type="submit"] {
		background-color: #fff; /* ボタンの背景色 */
		padding: 5px 20px; /* 内側の余白 */
		text-align: center;
		font-size: 20px; /* 文字サイズ */
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
						<td><s:if test="userGender == 0">男性</s:if> <s:else>女性</s:else></td>
						<td><s:if test="userAuthority == 0">一般</s:if> <s:else>管理者</s:else></td>
						<td><s:if test="deleteFlag == 0">有効</s:if> <s:else>無効</s:else></td>
						<td><s:property value="registeredTime" /></td>
						<td><s:property value="updateTime" /></td>
						<td>
							<div class="action-buttons">
								<!-- 削除ボタン -->
								<form action="deleteUserAction" method="post">
									<input type="hidden" name="userId"
										value="<s:property value='userId'/>">
									<button type="submit">削除</button>
								</form>

								<!-- 更新ボタン -->
								<form action="updateUserAction" method="get">
									<input type="hidden" name="userId"
										value="<s:property value='userId'/>">
									<button type="submit">更新</button>
								</form>
							</div>
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