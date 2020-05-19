<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Getting Started: Serving Web Content</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body><%--pib_login/merchant_payment--%>
<form method="POST" action='http://localhost:8082/ibs_payment/billLogin'>
    <input type="text" name="spk" id="spk" placeholder="City Secure Payment Key" value="sdfjsdkjeo">
    <input type="text" name="sti" id="sti" placeholder="Merchant Transaction Id" value="sjdfoisddoif">
    <input type="text" name="txa" id="txa" placeholder="Amount" value="10">
    <input type="text" name="additionalInfo" id="additionalInfo" placeholder="Additional Information" value="sdfj">

    <input type="submit" class="btn whiteBtn" value="Submit"/>
</form>
</body>
</html>
