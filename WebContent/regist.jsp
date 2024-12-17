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
<title>Regist画面</title>

<style type="text/css">

/*  TAG LAYOUT  */
body {
	margin: 0;
	padding: 200px;
	line-height: 1.6;
	letter-spacing: 1px;
	font-family: Verdana, Helvetica, sans-serif;
	font-size: 20px;
	color: #333;
	background: #fff;
}

body input {
	border: 1px solid #333;
}

table {
	margin: 0 auto;
}

/*  ID LAYOUT  */
#top {
	width: 100%;
	margin-left: 0px;
}

#header {
	width: 100%;
}

#main {
	width: 100%;
	text-align: center;
	border-right: 1px solid #333;
	border-left: 1px solid #333;
}

#main h3 {
	width: 100%;
	text-align: left;
	margin-left: 20px;
}

#main h4 {
	width: 100%;
	text-align: center;
	padding-top: 200px;
	padding-bottom: 200px;
}

#main p {
	width: 100%;
	font-size: 20px;
	text-align: center;
	border-top: 1px solid #333;
	border-bottom: 1px solid #333;
	padding-top: 10px;
	padding-bottom: 10px;
}

.submit-center {
	display: block;
	margin: 0 auto;
	background: #fff;
	font-size: 20px;
	padding: 5px 20px;
}

body .fielderror {
	color: #ff0000; /* ここで希望の色コードに変更 */
}
</style>
</head>
<body>
	<div id="header">
		<div id="pr"></div>
	</div>
	<h1>アカウント登録画面</h1>
	<div id="main">
		<div id="top">
			<p>ナビゲーションバー</p>
			<h3>アカウント登録画面</h3>
		</div>
		<div>
			<table>
				<s:form action="RegistConfirmAction" method="post">
					<tr>
						<td><label>名前（姓）</label></td>
					</tr>
					<tr>
						<td><label>名前（名）</label></td>
					</tr>
					<tr>
						<td><label>カナ（姓）</label></td>
					</tr>
					<tr>
						<td><label>カナ（名）</label></td>
					</tr>
					<tr>
						<td><label>メールアドレス</label></td>
					</tr>
					<tr>
						<td><label>パスワード</label></td>
					</tr>
					<tr>
						<td><label>性別</label></td>
					</tr>
					<tr>
						<td><label>郵便番号</label></td>
					</tr>
					<tr>
						<td><label>住所（都道府県）</label></td>
					</tr>
					<tr>
						<td><label>住所（市区町村）</label></td>
					<tr>
						<td><label>住所（番地）</label></td>
					</tr>
					<tr>
						<td><label>アカウント権限</label></td>
					</tr>
					<tr>
						<td colspan="2"><s:submit value="  確認する  "
								cssClass="submit-center" /></td>
					</tr>
				</s:form>
				<s:if test="hasActionErrors()">
					<div style="color: red;">
						<s:actionerror />
					</div>
				</s:if>
			</table>
		</div>
		<p>フッター</p>
	</div>
	<div id="footer">
		<div id="pr"></div>
	</div>
</body>
</html>