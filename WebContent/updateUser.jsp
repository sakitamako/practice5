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
<title>UpdateConfirm画面</title>

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
	margin-left: 10px;
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

.center-buttons {
	text-align: center;
}

.center-buttons form {
	display: inline-block;
}

/* ボタン共通スタイル */
input[type="submit"] {
	background-color: #fff; /* ボタンの背景色 */
	padding: 5px 20px; /* 内側の余白 */
	text-align: center;
	font-size: 20px; /* 文字サイズ */
}
</style>
<script>
	let originalMaskedPassword = "<s:property value='maskedPassword' />";
	let isPasswordChanged = false;

	function detectPasswordChange() {
		let passwordField = document.getElementById("userPassword");
		// 入力値が「●」でない場合、変更フラグをONにする
		isPasswordChanged = passwordField.value !== originalMaskedPassword;
	}

	function togglePasswordVisibility() {
		let passwordField = document.getElementById("userPassword");
		if (passwordField.type === "password") {
			passwordField.type = "text";
		} else {
			passwordField.type = "password";
		}
	}
</script>

</head>
<body>
	<div id="header">
		<div id="pr"></div>
	</div>
	<h1>アカウント更新画面</h1>
	<div id="main">
		<div id="top">
			<p>ナビゲーションバー</p>
			<h3>アカウント更新画面</h3>
		</div>
		<div>
			<table>
				<s:form action="UpdateConfirmAction" method="post">
					<s:hidden name="userId" value="%{user.userId}" />
					<tr>
						<td><label>名前（姓）</label></td>
						<td><s:textfield name="userFamilyName"
								value="%{user.userFamilyName}" /></td>
					</tr>
					<tr>
						<td><label>名前（名）</label></td>
						<td><s:textfield name="userLastName"
								value="%{user.userLastName}" /></td>
					</tr>
					<tr>
						<td><label>カナ（姓）</label></td>
						<td><s:textfield name="userFamilyNameKana"
								value="%{user.userFamilyNameKana}" /></td>
					</tr>
					<tr>
						<td><label>カナ（名）</label></td>
						<td><s:textfield name="userLastNameKana"
								value="%{user.userLastNameKana}" /></td>
					</tr>
					<tr>
						<td><label>メールアドレス</label></td>
						<td><s:textfield name="userMail" value="%{user.userMail}" /></td>
					</tr>
					<tr>
						<td><label>パスワード</label></td>
						<td><input type="password" name="userPassword"
                            value="%{maskedPassword}" /></td>
					</tr>
					<tr>
						<td><label>性別</label></td>
						<td><s:radio name="userGender" list="#{'0':'男性','1':'女性'}"
								value="%{user.userGender}" /></td>
					</tr>
					<tr>
						<td><label>郵便番号</label></td>
						<td><s:textfield name="userPostalCode"
								value="%{user.userPostalCode}" /></td>
					</tr>
					<tr>
						<td><label>住所（都道府県）</label></td>
						<td><s:select name="userPrefecture"
								list="#{'北海道':'北海道','青森県':'青森県','岩手県':'岩手県','宮城県':'宮城県',
                         '秋田県':'秋田県','山形県':'山形県','福島県':'福島県','茨城県':'茨城県',
                         '栃木県':'栃木県','群馬県':'群馬県','埼玉県':'埼玉県','千葉県':'千葉県',
                         '東京都':'東京都','神奈川県':'神奈川県','新潟県':'新潟県','富山県':'富山県',
                         '石川県':'石川県','福井県':'福井県','山梨県':'山梨県','長野県':'長野県',
                         '岐阜県':'岐阜県','静岡県':'静岡県','愛知県':'愛知県','三重県':'三重県',
                         '滋賀県':'滋賀県','京都府':'京都府','大阪府':'大阪府','兵庫県':'兵庫県',
                         '奈良県':'奈良県','和歌山県':'和歌山県','鳥取県':'鳥取県','島根県':'島根県',
                         '岡山県':'岡山県','広島県':'広島県','山口県':'山口県','徳島県':'徳島県',
                         '香川県':'香川県','愛媛県':'愛媛県','高知県':'高知県','福岡県':'福岡県',
                         '佐賀県':'佐賀県','長崎県':'長崎県','熊本県':'熊本県','大分県':'大分県',
                         '宮崎県':'宮崎県','鹿児島県':'鹿児島県','沖縄県':'沖縄県'}"
								value="%{user.userPrefecture}" /></td>
					</tr>
					<tr>
						<td><label>住所（市区町村）</label></td>
						<td><s:textfield name="userAddress1"
								value="%{user.userAddress1}" /></td>
					</tr>
					<tr>
						<td><label>住所（番地）</label></td>
						<td><s:textfield name="userAddress2"
								value="%{user.userAddress2}" /></td>
					</tr>
					<tr>
						<td><label>権限</label></td>
						<td><s:select name="userAuthority"
								list="#{'0':'一般','1':'管理者'}" value="%{user.userAuthority}" /></td>
					</tr>
					<tr>
						<td colspan="2" style="text-align: center;"><s:submit
								value="確認する" cssClass="submit-center"
								cssStyle="padding: 10px 20px; font-size: 18px; background-color: white; color: black; border: 1px solid black; cursor: pointer; display: block; margin: 0 auto;" />
						</td>
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
