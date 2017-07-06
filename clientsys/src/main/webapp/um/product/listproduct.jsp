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
            //comp.selectproduct("compinput", false);
            queryproduct(1);
        });

        function pageInit(pageNo) {
            $("#page").initPage(countAll, pageNo, queryproduct);
        }

        function queryproduct(pageNo){
            var name = $("#name").val();
            $.ajax({
                url: '/product/findproductstr',
                type:'post',
                data:{'name': name, 'pageNo': pageNo, 'pageSize': pageSize},
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
                            html += "<td>"+data[i].name+"</td>";
                            html += "</tr>";
                        }
                        $("#productbody").html(html);
                    } else {
                        alert("查询失败！");
                    }
                }
            });
        }

        function findproduct(){
            queryproduct(1);
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
            <a href="${contextPath}/um/product/editproduct.jsp">新增</a>
            <div>
                <table>
                    <tr>
                        <td>名称</td>
                        <td><input type="text" id="name" name="name"/> </td>
                        <td><input type="button" value="查询" onclick="findproduct()"/> </td>
                    </tr>
                </table>
            </div>
            <table class="table table-striped">
                <%--<caption></caption>--%>
                <thead>
                <tr>
                    <th>序号</th>
                    <th>产品名称</th>
                </tr>
                </thead>
                <tbody id="productbody">
                </tbody>
            </table>
            <%--maxshowpageitem ：最多显示的页码数字，必需; pagelistcount : 每一个页面显示的数据的个数--%>
            <ul class="page" maxshowpageitem="5" pagelistcount="10" id="page"></ul>
        </div>
    </div>
</div>
</body>
</html>
