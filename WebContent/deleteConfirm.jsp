<!-- このファイルが通常のHTMLファイルではなく、JSPであることを示している -->
<!-- strutsタグ（下の補足参照）を使用する際に記述します。ここでは”s”としてタグを使用 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!-- ログイン認証機能 -->
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
<title>UpdateComplete画面</title>

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
	text-align: center;
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
	margin-left: 10px;
}

#main h2 {
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

#main a {
	width: 1000px;
	border: 1px solid #333;
	color: #333;
	padding: 10px;
}

#main input[type="submit"] {
	background-color: #fff; /* ボタンの背景色 */
	padding: 5px 20px; /* 内側の余白 */
	text-align: center;
	font-size: 20px; /* 文字サイズ */
}
</style>
</head>
<body>
	<h1>アカウント削除確認画面</h1>
	<div id="main">
		<div id="top">
			<p>ナビゲーションバー</p>
			<h3>アカウント削除確認画面</h3>
		</div>
		<div>
			<table>
				<tr class="center-buttons">
					<td colspan="2">
						<h2>本当に削除してよろしいですか？</h2>
						<div
							style="display: flex; justify-content: center; gap: 20px; margin-top: 20px;">
							<s:form action="MyPageAction" method="get">
								<s:submit value="前に戻る"
									cssStyle="padding: 10px 20px; font-size: 18px;" />
							</s:form>
							<s:form action="DeleteCompleteAction" method="post">
								<s:hidden name="userId" value="%{user.userId}" />
								<s:submit value="削除する"
									cssStyle="padding: 10px 20px; font-size: 18px; background-color: red; color: white; border: none; cursor: pointer;" />
							</s:form>
						</div>
					</td>
				</tr>
			</table>
		</div>
		<p>フッター</p>
	</div>
	<div id="footer">
		<div id="pr"></div>
	</div>
</body>
</html>