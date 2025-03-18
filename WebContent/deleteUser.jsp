<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>アカウント削除確認</title>
    <style>
        body {
            text-align: center;
            font-family: Arial, sans-serif;
        }
        .container {
            margin-top: 50px;
            border: 1px solid #ccc;
            padding: 20px;
            display: inline-block;
            background: #f9f9f9;
        }
        .buttons {
            margin-top: 20px;
        }
        .buttons a {
            text-decoration: none;
            padding: 10px 15px;
            border: 1px solid #333;
            background-color: #007bff;
            color: white;
            margin: 0 10px;
            display: inline-block;
        }
        .buttons a:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>アカウント削除確認</h2>
        <p>本当にこのアカウントを削除しますか？</p>
        <p>ユーザーID: <s:property value="userId" /></p>
        <div class="buttons">
            <a href="deleteUserAction?userId=<s:property value='userId'/>">削除する</a>
            <a href="myPageAction">キャンセル</a>
        </div>
    </div>
</body>
</html>
