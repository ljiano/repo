<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/um/include/uminclude.jsp" %>
<html>
<head>
    <title></title>
    <script type="text/javascript">
        function closeWin() {
            window.close();
        }
        function saveproduct() {
            $("#prooForm").ajaxSubmit({
                url: '/product/saveproduct',
                type: 'post',
                data: $("#prooForm").serialize(),
                beforeSubmit: function () {
                    //alert(123);
                },
                success: function (data) {
                    if (data == 'ok') {
                        window.location.href = "/um/product/listproduct.jsp";
                    } else {
                        alert("err");
                    }
                },
                error: function (XmlHttpRequest, textStatus, errorThrown) {
                    alert(textStatus + "--" + "err");
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
            <form id="prooForm" method="post">
                <table>
                    <tr>
                        <td>产品名称</td>
                        <td><input type="text" id="name" name="name"/></td>
                    </tr>
                </table>
                <table>
                    <tr>
                        <td><input type="button" value="保存" onclick="saveproduct();"/></td>
                        <td><input type="button" value="关闭" onclick="closeWin();"/></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>
</body>
</html>
