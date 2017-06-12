<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/um/include/uminclude.jsp" %>
<html>
<head>
    <title></title>
    <script type="text/javascript">
        var pageSize = 10;
        var countAll = 0;
        $(function(){
            //pageInit(1);
            queryCompanys(1);
        });

        function pageInit(pageNo) {
            $("#page").initPage(countAll, pageNo, queryCompanys);
        }

        function queryCompanys(pageNo){
            $.ajax({
                url: '/user/findusercompanys',
                type:'get',
                data: {'uid': '${param.uid}', 'pageNo': pageNo, 'pageSize': pageSize},
                dataType:'JSON',
                success : function(result){
                    var html = "";
                    if(result != null && result != ''){
                        var total = result.total;
                        if(Number(countAll) != Number(total)) {
                            countAll = total;
                        }
                        var data = result.list;
                        for(var i = 0; i < data.length; i++){
                            html += "<tr>";
                            html += "<td>"+data[i].username+"</td>"
                            html += "<td>"+data[i].companyname+"</td>"
                            html += "</tr>";
                        }
                    }
                    $("#userbody").html(html);
                    pageInit(pageNo);
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
            <%--<a href="${contextPath}/um/user/edituser.jsp">新增</a>--%>
            <%--<div>--%>
                <%--<table>--%>
                    <%--<tr>--%>
                        <%--<td>姓名</td>--%>
                        <%--<td><input type="text" id="username" name="username"/></td>--%>
                        <%--<td><input type="button" value="查询" onclick="findUser()"/></td>--%>
                    <%--</tr>--%>
                <%--</table>--%>
            <%--</div>--%>
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>用户姓名</th>
                    <th>企业名称</th>
                </tr>
                </thead>
                <tbody id="userbody">
                </tbody>
            </table>
            <%--maxshowpageitem ：最多显示的页码数字，必需; pagelistcount : 每一个页面显示的数据的个数--%>
            <ul class="page" maxshowpageitem="5" pagelistcount="10" id="page"></ul>
        </div>
    </div>
</div>
</body>
</html>
