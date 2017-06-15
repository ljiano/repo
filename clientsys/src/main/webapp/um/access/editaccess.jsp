<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/um/include/uminclude.jsp" %>
<html>
<head>
    <title></title>
    <script type="text/javascript">
        $(function () {
//            $('#tg').on("changeDate", function(){
//                alert(123);
//            });
            comp.selectCompany("company", false);
            var nowTemp = new Date();
            var now = new Date(nowTemp.getFullYear(), nowTemp.getMonth(), nowTemp.getDate(), 0, 0, 0, 0);

            var startDate = $("#startdate").datepicker({
                "onRender": function (date) {
//                    return date.valueOf() < now.valueOf() ? "disabled" :"";
                    return "";
                }
            }).on("changeDate", function (ev) {
                if (ev.date.valueOf() > endDate.date.valueOf()) {
                    var newDate = new Date(ev.date);
                    newDate.setDate(newDate.getDate() + 1);
                    endDate.setVal(newDate);
                }
                startDate.hide();
                $("#enddate")[0].focus();
            }).data('datepicker');
            var endDate = $("#enddate").datepicker({
                'onRender': function (date) {
                    return date.valueOf() < startDate.date.valueOf() ? "disabled" : "";
                }
            }).on("changeDate", function (ev) {
                endDate.hide();
            }).data('datepicker');
        });

        function subAccess() {
            $("#accForm").ajaxSubmit({
                url: '/access/saveaccess',
                type: 'post',
                data: $("#accForm").serialize(),
                success: function (data) {
                    if (data == 'ok') {
                        window.location.href = "/um/access/listaccess.jsp";
                    }
                }
            });
        }
    </script>
</head>
<body>


<%--<div class="input-append date" id="dp3" data-date="" data-date-format="yyyy-mm-dd">--%>
<%--<input class="span2" size="16" type="text">--%>
<%--<span class="add-on"><i class="icon-calendar"></i></span>--%>
<%--</div>--%>
<%--<um:dateField id="tg" name="tg" format="yyyy-mm-dd"/>--%>
<div class="container">
    <div class="row">
        <div class="col-lg-3" style="box-shadow:inset 1px -1px 1px #444, inset -1px 1px 1px #444;height: 800px">
            <jsp:include page="/um/include/left.jsp"/>
        </div>

        <div class="col-lg-9" style="box-shadow: inset 1px -1px 1px #444, inset -1px 1px 1px #444;height: 800px">
            <form id="accForm" method="post">
                <table>
                    <tr>
                        <td>企业</td>
                        <td>
                            <input type="text" id="company" name="company"/>
                        </td>
                    </tr>
                    <tr>
                        <td>拜访时间</td>
                        <td>
                            <div class="input-append date" id="startdate" data-date="" data-date-format="yyyy-mm-dd">
                                <input class="span2" size="16" type="text" name="startdate">
                                <span class="add-on"><i class="icon-calendar"></i></span>
                            </div>
                            至
                            <div class="input-append date" id="enddate" data-date="" data-date-format="yyyy-mm-dd">
                                <input class="span2" size="16" type="text" name="enddate">
                                <span class="add-on"><i class="icon-calendar"></i></span>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="button" value="提交" onclick="subAccess();"/>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>
</body>
</html>
