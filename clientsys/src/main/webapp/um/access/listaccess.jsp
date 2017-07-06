<%@ page import="com.ljo.tag.UMFunction" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/um/include/uminclude.jsp" %>
<html>
<head>
    <title></title>
    <script type="text/javascript">
        var pageSize = 10;
        var countAll = null;
        $(function () {
            //pageInit('${pageNo}');
            comp.selectCompany("company", false);
            queryaccess(1);
        });

        function pageInit(pageNo) {
            $("#page").initPage(countAll, pageNo, queryaccess);
        }

        function queryaccess(pageNo) {
            var companyId = $("#company").val();
            var username = $("#username").val();
            $.ajax({
                url: '/access/findaccessstr',
                type: 'post',
                data: {'username': username, 'cid': companyId,  'pageNo': pageNo, 'pageSize': pageSize},
                dataType: 'json',
                success: function (result) {
                    if (result != null && result != '') {
                        var total = result.total;
                        if (countAll == null || Number(countAll) != Number(total)) {
                            countAll = total;
                            pageInit(pageNo);
                        }
                        var data = result.list;
                        var html = "";
                        for (var i = 0; i < data.length; i++) {
                            var accessTime = new Date(data[i].accesstime.time).format('yyyy-MM-dd');
                            var endTime = new Date(data[i].endtime.time).format('yyyy-MM-dd');
//                            var year = accessTime.getFullYear();
//                            var month = accessTime.getMonth() + 1;
//                            var day = accessTime.getDate();
//                            var _year = endTime.getFullYear();
//                            var _month = endTime.getMonth() + 1;
//                            var _day = endTime.getDate();
                            <%--alert(<%= UMFunction.formatDate()%>);--%>
                            html += "<tr>";
                            html += "<td>" + data[i].username + "</td>";
                            html += "<td>" + data[i].companyname + "</td>";
                            html += "<td>" + accessTime + "至"+ endTime+"</td>";
                            html += "</tr>";
                        }
                        $("#accessbody").html(html);
                    } else {
                        alert("查询失败！");
                    }
                }
            });
        }

        function findaccess() {
            queryaccess(1);
        }
    </script>
</head>
<body>
<div class="container">
    <div class="row">
        <%--<div class="col-lg-3" style="box-shadow:inset 1px -1px 1px #444, inset -1px 1px 1px #444;height: 800px">--%>
            <%--<jsp:include page="/um/include/left.jsp"/>--%>
        <%--</div>--%>

        <div class="col-lg-12" style="box-shadow: inset 1px -1px 1px #444, inset -1px 1px 1px #444;height: 800px">
            <a href="${contextPath}/um/access/editaccess.jsp">新增</a>
            <div>
                <table>
                    <tr>
                        <td>用户名称</td>
                        <td><input type="text" id="username" name="username"/> </td>
                        <td>企业</td>
                        <td><input type="text" id="company" name="company"> </td>
                        <td><input type="button" value="查询" onclick="findaccess()"/> </td>
                    </tr>
                </table>
            </div>
            <table class="table table-striped">
                <%--<caption></caption>--%>
                <thead>
                <tr>
                    <th>用户名称</th>
                    <th>企业名称</th>
                    <th>拜访时间</th>
                </tr>
                </thead>
                <tbody id="accessbody">

                </tbody>
            </table>
            <%--maxshowpageitem ：最多显示的页码数字，必需; pagelistcount : 每一个页面显示的数据的个数--%>
            <ul class="page" maxshowpageitem="5" pagelistcount="10" id="page"></ul>
        </div>
    </div>
</div>
</body>
</html>
