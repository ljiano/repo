<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/um/include/uminclude.jsp" %>
<html>
<head>
    <title></title>
    <script type="text/javascript">
        function closeWin() {
            window.close();
        }
        function saveCompany() {
            $("#comForm").ajaxSubmit({
                url: '/company/savecompany',
                type: 'post',
                data: $("#comForm").serialize(),
                beforeSubmit: function () {
                    //alert(123);
                },
                success: function (data) {
                    if (data == 'ok') {
                        window.location.href = "/um/company/listcompany.jsp";
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
            <form id="comForm" method="post">
                <input type="hidden" id="id" name="id" value="${param.cid}"/>
                <table>
                    <tr>
                        <td>企业名称</td>
                        <td><input type="text" id="companyname" name="companyname" value="${company.companyname}"/></td>
                        <td>组织机构代码</td>
                        <td><input type="text" id="companycode" name="companycode"/></td>
                    </tr>
                    <tr>
                        <td>企业性质</td>
                        <td><input type="text" id="companytype" name="companytype"/></td>
                        <td>行业</td>
                        <td><input type="text" id="industryname" name="industryname"/></td>
                    </tr>
                    <tr>
                        <td>地区</td>
                        <td><input type="text" id="area" name="area"/></td>
                        <td>注册规模</td>
                        <td><input type="text" id="gm" name="gm"/></td>
                    </tr>
                    <tr>
                        <td>法人</td>
                        <td><input type="text" id="legal" name="legal"/></td>
                        <td>总资产</td>
                        <td><input type="text" id="capital" name="capital"/></td>
                    </tr>
                    <tr>
                        <td>营业执照注册号</td>
                        <td><input type="text" id="f1" name="f1"/></td>
                        <td>通讯地址</td>
                        <td><input type="text" id="f2" name="f2"/></td>
                    </tr>
                    <tr>
                        <td>年份</td>
                        <td><input type="text" id="f3" name="f3"/></td>
                        <td>季度</td>
                        <td><input type="text" id="f4" name="f4"/></td>
                    </tr>
                </table>
                <table>
                    <tr>
                        <td><input type="button" value="保存" onclick="saveCompany();"/></td>
                        <td><input type="button" value="关闭" onclick="closeWin();"/></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>
</body>
</html>
