<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8" />
    <meta name="description" content="中国最好的软件与微电子学院之一，是按新模式建立、新机制运行的北京大学直属学院。" />
    <meta name="Keywords" Content="北京大学软件与微电子学院,综合信息服务平台,学生信息综合管理与服务平台,教学辅助管理系统,北大软微教辅系统" />
    <title>登录 - 北京大学软件与微电子学院 - 综合信息服务平台</title>
    <%String path = request.getContextPath(); %>
    <link rel="stylesheet" type="text/css" href="<%=path %>/static/css/default.css" />
    <style type="text/css">
        #Bottom {
            line-height:20px;
            bottom:0;
            background: #F9F7EA;
            border-top: 1px solid #EFE6BB;
            bottom: 0;
            color: #B9DDFF;
            font-size: 11px;
            text-align: center;
            position: fixed;
            width:100%;
        }
    </style>
<meta name="__hash__" content="4327d5c993e8aff6cb1bcd179c4fc691_7f5799ed5bf1ae9ee1b90fc21772b7ff" /></head>

<body class="loginWeb" style="text-align: center">
    <div class="loginBox">
        <div class="innerBox">
            <div class="logo"> <img src="<%=path %>/static/images/logo.png" /></div>
            <form style="text-align: match-parent">
                <div class="loginInfo" style="margin-left: 15px">
                    <ul>
                        <li class="row1">登录账号：</li>
                        <li class="row2"><input class="input" name="user[username]" id="username" size="30" type="text" placeholder="默认为学号或职工号" title="默认为学号或职工号" /></li>
                    </ul>
                    <ul>
                        <li class="row1">登录密码：</li>
                        <li class="row2"><input class="input" name="user[password]" id="pwd" size="30" type="password" placeholder="默认为八位生日数字" title="默认为八位生日数字" /></li>
                    </ul>
                    <ul>
                        <li class="row1">验证码：</li>
                        <li class="row2"><input class="input" id="verify_code" size="10" name="verify_code" type="text" onkeydown="javascript:KeyDown(event, 'commitButton')" />
                        <img src="/index.php/Public/verifyCode.html" id="codeImg"  title="看不清？单击此处刷新" onclick="this.src+='?rand='+Math.random();"  style="cursor: pointer; vertical-align: middle;"/></li>
                    </ul>
                </div>
            <input type="hidden" name="__hash__" value="4327d5c993e8aff6cb1bcd179c4fc691_7f5799ed5bf1ae9ee1b90fc21772b7ff" /></form>
            <div class="clear"></div>
            <div class="operation"><button id="commitButton" class="btn submit">登录</button>
                <button class="btn findPwd" onclick=location.href="/index.php/Public/resetPassword.html">找回密码</button>
                <br>为保证优质体验，请使用Chrome(谷歌)或Firefox(火狐)浏览器
                </div>
        </div>
    </div>
    <div id="Bottom">
        © 2014 - 2017 北京大学软件与微电子学院 - 综合信息服务平台 All rights reserved - 技术支持邮箱: icampus@ss.pku.edu.cn
    </div>

    <script type="text/javascript" src="<%=path %>/static/js/base.js">
</script>

<script type="text/javascript">
    //$(window).resize(autoSize);
    $(function(){
        autoSize();
        $(".loginOut").click(function(){
            var url=$(this).attr("href");
            popup.confirm('你确定要退出吗？','你确定要退出吗',function(action){
                if(action == 'ok'){ window.location=url; }
            });
            return false;
        });

        var time=self.setInterval(function(){$("#today").html(date("Y-m-d H:i:s"));},1000);
    });

    function KeyDown(e, $id) {
        e = (e) ? e : ((window.event) ? window.event : ""); //兼容IE和Firefox获得keyBoardEvent对象
        var key = e.keyCode ? e.keyCode : e.which;//兼容IE和Firefox获得keyBoardEvent对象的键值
        if (key == 13) {
            $('#' + $id).click();
        }
    }
</script>
    <script src="<%=path %>/static/js/jquery.form.js"></script>
    <script type="text/javascript">
        $(function(){
            // 登录
            $(".submit").click(function(){
                $("#commitButton").attr('disabled',"true");
                $("#commitButton").text('提交中');
                if($("#username").val() == ''
                   || $("#pwd").val() == ''
                   || $("#verify_code").val() == ''){
                    popup.alert("请填写完整的表单后进行登录！");
                    $("#commitButton").removeAttr('disabled');
                    $("#commitButton").text('登录');
                    return false;
                }
                commonAjaxSubmit("/index.php/Public/login.html",'',$("#commitButton"));
            });

            var explorer = navigator.userAgent;
            var supported = false;
            if (explorer.indexOf("Firefox") >= 0
                    || explorer.indexOf("Chrome") >= 0
                    || explorer.indexOf("Safari") >= 0) {
                supported = true;
            }
            if (!supported) {
                popup.alert("为保证优质体验，请使用Chrome(谷歌)或Firefox(火狐)浏览器！");
            }

        });
    </script>

</body>
</html>