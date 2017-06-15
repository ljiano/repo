<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/um/include/uminclude.jsp" %>
<html>
<head>
    <title></title>
    <script type="text/javascript">
        var pageSize = 10;
        var countAll = null;
        $(function(){
            //pageInit('${pageNo}');
            queryUser(1);
        });

        function pageInit(pageNo) {
            $("#page").initPage(countAll, pageNo, queryUser);
        }

        function queryUser(pageNo){
            var username = $("#username").val();
            $.ajax({
                url: '/user/finduserstr',
                type:'post',
                data:{'username': username, 'pageNo': pageNo, 'pageSize': pageSize},
                dataType:'json',
                success:function(result){
                    if(result != null && result != ''){
                        var total = result.total;
                        if(countAll == null || Number(countAll) != Number(total)) {
                            countAll = total;
                            pageInit(pageNo);
                        }
                        var data = result.list;
                        var html = "";
                        for(var i = 0; i < data.length; i++){
                            html += "<tr>";
                            html += "<td>"+data[i].id+"</td>";
                            html += "<td>"+data[i].username+"</td>";
                            html += "<td>"+data[i].password+"</td>";
                            html += "<td><a href='javascript:showCompanys("+data[i].id+")'>查看</a></td>"
                            html += "</tr>";
                        }
                        $("#userbody").html(html);
                    } else {
                        alert("查询失败！");
                    }
                }
            });
        }

        function findUser(){
            queryUser(1);
        }

        function showCompanys(uid) {
            window.location.href = '${contextPath}/um/user/showcompanys.jsp?uid=' + uid;
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
            <a href="${contextPath}/um/user/edituser.jsp">新增</a>
            <div>
                <table>
                    <tr>
                        <td>姓名</td>
                        <td><input type="text" id="username" name="username"/> </td>
                        <td><input type="button" value="查询" onclick="findUser()"/> </td>
                    </tr>
                </table>
            </div>
            <table class="table table-striped">
                <%--<caption></caption>--%>

                <thead>
                <tr>
                    <th>序号</th>
                    <th>姓名</th>
                    <th>密码</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody id="userbody">
                    <c:forEach items="${page.list}" var="user">
                        <tr>
                            <td>${user.id}</td>
                            <td>${user.username}</td>
                            <td>${user.password}</td>
                            <td><a href="javascript:showCompanys('${user.id}')">查看</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <%--maxshowpageitem ：最多显示的页码数字，必需; pagelistcount : 每一个页面显示的数据的个数--%>
            <ul class="page" maxshowpageitem="5" pagelistcount="10" id="page"></ul>
        </div>
    </div>
</div>
</body>
</html>
