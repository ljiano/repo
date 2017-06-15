<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/um/include/uminclude.jsp" %>
<html>
<head>
    <title>新增用户</title>
    <script type="text/javascript">
        function subUM(){
            $("#umform").ajaxSubmit({
                url: '/user/saveuser',
                type:'post',
                data: $("#umform").serialize(),
                beforeSubmit: function(){
                    //alert(123);
                },
                success: function(data) {
                    if(data == 'ok'){
                        window.location.href = "/um/user/listuser.jsp";
                    } else{
                        alert("err");
                    }
                },
                error: function(XmlHttpRequest, textStatus, errorThrown){
                    alert(textStatus +"--" +"err");
                }
            });
        }

    </script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-lg-3" style="box-shadow:inset 1px -1px 1px #444, inset -1px 1px 1px #444;height: 800px">
            <jsp:include page="/um/include/left.jsp"/>
        </div>

        <div class="col-lg-9" style="box-shadow: inset 1px -1px 1px #444, inset -1px 1px 1px #444;height: 800px">

            <form id="umform" action="" method="post">
                <table class="table table-striped">
                    <%--<caption></caption>--%>
                    <tr>
                        <td>用户名</td>
                        <td><input type="text" id="username" name="username"/></td>
                    </tr>
                    <tr>
                        <td>密码</td>
                        <td><input type="text" id="password" name="password"></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="button" id="subbutton" value="提交" onclick="subUM();"/>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>
</body>
</html>
