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
            comp.selectCompany("compinput", false);
            queryCompany(1);

            $(document).keypress(function(e) {
                // 回车键事件
                if(e.which == 13) {
                    findCompany();
                }
            });
        });

        function pageInit(pageNo) {
            $("#page").initPage(countAll, pageNo, queryCompany);
        }

        function queryCompany(pageNo) {
            var companyname = $("#companyname").val();
            $.ajax({
                url: '/company/findcompanystr',
                type: 'post',
                data: {'companyname': companyname, 'pageNo': pageNo, 'pageSize': pageSize},
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
                            html += "<tr>";
                            html += "<td style='text-align: center'>" + data[i].id + "</td>";
                            html += "<td>" + data[i].companyname + "</td>";
                            html += "<td>" +
                            "<a href='javascript:viewComp(" + data[i].id + ")'>查看</a>&nbsp;|" +
                            "&nbsp;<a href='javascript:editComp(" + data[i].id + ")'>编辑</a>" +
                            "</td>";
                            html += "</tr>";
                        }
                        $("#companybody").html(html);
                    } else {
                        alert("查询失败！");
                    }
                }
            });
        }

        function findCompany() {
            queryCompany(1);
        }

        function viewComp(id) {

        }
        function editComp(id) {
            window.location.href = "/company/loadcompany?cid=" + id;
        }

        function addComp(){
            window.location.href = "${contextPath}/um/company/editcompany.jsp";
        }
    </script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-lg-12" style="box-shadow: inset 1px -1px 1px #444, inset -1px 1px 1px #444;height: 800px">
            <div class="row">
                <div class="col-lg-9">
                    <div class="input-group input-group-lg">
                        <span class="input-group-addon">名称</span>
                        <input type="text" class="form-control" placeholder="企业名称"
                               id="companyname" name="companyname" width="200px">
                    </div>
                </div>
                <div class="col-lg-3">
                    <div class="input-group input-group-lg">
                        <span class="input-group-addon" onclick="findCompany()">查询</span>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="btn-toolbar" role="toolbar">
                        <div class="btn-group">
                            <button type="button" class="btn btn-default" onclick="addComp();">新增</button>
                        </div>
                    </div>
                    <table class="table table-striped table-hover">
                        <%--<caption style="padding-left: 2px" onclick="addComp();">新增</caption>--%>
                        <thead>
                        <tr>
                            <th style="text-align: center; width: 69px">序号</th>
                            <th style="text-align: center">企业名称</th>
                            <th style="text-align: center">操作</th>
                        </tr>
                        </thead>
                        <tbody id="companybody">
                        </tbody>
                    </table>
                    <%--maxshowpageitem ：最多显示的页码数字，必需; pagelistcount : 每一个页面显示的数据的个数--%>
                    <ul class="page" maxshowpageitem="5" pagelistcount="10" id="page"></ul>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
