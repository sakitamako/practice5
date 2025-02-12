<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>アカウント更新</title>
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
        table {
            margin: auto;
            border-collapse: collapse;
        }
        td {
            padding: 10px;
        }
        .buttons {
            margin-top: 20px;
        }
        .buttons button {
            padding: 10px 15px;
            border: none;
            background-color: #007bff;
            color: white;
            cursor: pointer;
        }
        .buttons button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>アカウント更新</h2>
        <form action="updateUserAction" method="post">
            <input type="hidden" name="userId" value="<s:property value='userId'/>">
            <table>
                <tr>
                    <td>名前（姓）:</td>
                    <td><input type="text" name="userFamilyName" value="<s:property value='userFamilyName'/>"></td>
                </tr>
                <tr>
                    <td>名前（名）:</td>
                    <td><input type="text" name="userLastName" value="<s:property value='userLastName'/>"></td>
                </tr>
                <tr>
                    <td>メールアドレス:</td>
                    <td><input type="email" name="userMail" value="<s:property value='userMail'/>"></td>
                </tr>
                <tr>
                    <td>アカウント権限:</td>
                    <td>
                        <select name="userAuthority">
                            <option value="0" <s:if test="userAuthority == 0">selected</s:if>>一般</option>
                            <option value="1" <s:if test="userAuthority == 1">selected</s:if>>管理者</option>
                        </select>
                    </td>
                </tr>
            </table>
            <div class="buttons">
                <button type="submit">更新する</button>
            </div>
        </form>
        <br>
        <a href="myPageAction">キャンセル</a>
    </div>
</body>
</html>
