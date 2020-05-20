<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Getting Started: Serving Web Content</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<form action="/post-ssl-login" method="POST">
    <table>
        <tr></tr>
        <tr>
            <td><label for="merchantKey"> Merchant Key /User Name</label></td>
            <td><input type="text" id="merchantKey" name="merchantKey"></td>
        </tr>
        <tr>
            <td><label for="sslRefId">SSL RefId</label></td>
            <td><input type="sslRefId" id="sslRefId" name="sslRefId"></td>
        </tr>
        <tr>
            <td><label for="productPrice">Product Price </label></td>
            <td><input type="text" id="productPrice" name="productPrice"></td>
        </tr>
        <tr>
            <td><label for="merchantName">Merchant Name </label></td>
            <td><input type="text" id="merchantName" name="merchantName"></td>
        </tr>
        <tr>
            <td></td>
            <td>
                <button type="submit" name="Submit" value="Submit">Submit</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>