<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Access-Control-Allow-Origin" content="*">
<title>saturn</title>
</head>
<body>
Hello Spring OK.jsp Init

<form style="display: none" id="form" action="http://218.76.54.230:16610/Webgateway/doDispatcher" method="post">
    <!--<form action="http://127.0.0.1/Webgateway/doDispatcher" method="post">-->


    <input type="text" name="appID" value="${appID}"></br>
    <input type="text" name="serviceId" value="wdfkPage"></br>
    <input type="text" name="reqTime" value="2018/06/01 11:29:38"></br>
    <input type="text" name="ChannelNo" value="0020003"></br>
    <input type="text" name="background" value="af012a"></br>
    <input type="text" name="randomKey" value="UMsmRmvsX95Q==">
    <input type="text" name="sign" value="bG/044bjgMSxFTqKTnw==">
    <input type="text" name="busiNo" value="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa">
    <input type="text" name="data" value="kZtIfAD64tsNfHLNlUugPEutRBE3OVHPnVk95/Alm8X4">

</form>

<script type="text/javascript" src="../js/Jquery.js"></script>
<script type="text/javascript">
    $(document).ready( function () {
        $("#form").submit();
    });

</script>
</body>
</html>