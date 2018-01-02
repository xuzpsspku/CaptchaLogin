<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>开始验证</title>
</head>
<body>
<form action="submit.action" method="post">
用户名：<input type="text" name="username"><br/><br/>
密 &nbsp; &nbsp;码：<input type="password" name="password"><br/><br/>
验证码：<input type="text" name="checkcode"> &nbsp;<img src="random.jpg" alt="验证码图片" align="center" title="看不清？点击更换图片" onclick="javascript:this.src='random.jpg?tm='+Math.random()" /><br/><br/>
<input type="submit" value="提交"/>&nbsp; &nbsp;<input type="reset">
</form>
</body>
</html>