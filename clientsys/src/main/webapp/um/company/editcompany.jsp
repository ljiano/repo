<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/um/include/uminclude.jsp" %>
<html>
<head>
    <title></title>
    <script type="text/javascript">
        var contsize = '${contsize}';
        function closeWin() {
            window.close();
        }
        function saveCompany() {
            var contacts = [];
            var contacttr = $("#contacttable").find("tr:gt(0)");
            if(contacttr.length > 0){
                for(var i = 0; i < contacttr.length; i++) {
                    var contact = $(contacttr[i]).find("td:eq(9)").text();
                    if(contact != null && contact != ""){
                        contacts.push($.parseJSON(contact));
                    }
                }
            }
            $("#contacts").val(JSON.stringify(contacts));
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

        function addContact() {
            $("#contForm").resetForm();
            $("#iscore1").removeAttr("checked");
            $("#iscore2").removeAttr("checked");
            $("#tr_index").val(0);
            $("#contactid").val(0);
            $("#conWin").modal({
                backdrop: false,
                keyboard: false
            });
        }

        function saveContact(){
            var index = $("#tr_index").val();
            var cont = {}
            cont['tr_index'] = index == 0 ? contsize : index;
            cont['contactid'] = $("#contactid").val();
            cont['contactname'] = $("#contactname").val();
            cont['contactposition'] = $("#contactposition").val();
            cont['contacttel'] = $("#contacttel").val();
            cont['contactphone'] = $("#contactphone").val();
            cont['contactno'] = $("#contactno").val();
            cont['contactemail'] = $("#contactemail").val();
            cont['iscore'] = $("input[type='radio'][name='iscore']:checked").val();
            if(index == 0){
                var contacthtml = "<tr id='cont_" + contsize + "'>";
                contacthtml += "<td>" + cont.contactname + "</td>";
                contacthtml += "<td>" + cont.contactposition + "</td>";
                contacthtml += "<td>" + cont.contacttel + "</td>";
                contacthtml += "<td>" + cont.contactphone + "</td>";
                contacthtml += "<td>" + cont.contactno + "</td>";
                contacthtml += "<td>" + cont.contactemail + "</td>";
                contacthtml += "<td>" + (cont.iscore == 1 ? "是" : cont.iscore == 2 ? "否" : "") + "</td>";
                contacthtml += "<td>" +
                "<a href='javascript:editContact(" + contsize + ")'>编辑</a>&nbsp;" +
                "<a href='javascript:removeContact(" + contsize + ")'>删除</a>&nbsp;" +
                "</td>";
                contacthtml += "<td style='display: none'>" + cont.contactid + "</td>";
                contacthtml += "<td style='display: none'>" + JSON.stringify(cont) + "</td>";
                contacthtml += "</tr>";
                $("#contactbody").append(contacthtml);
                contsize++;
            } else {
                $($("#cont_" + index).find("td")[0]).text(cont.contactname);
                $($("#cont_" + index).find("td")[1]).text(cont.contactposition);
                $($("#cont_" + index).find("td")[2]).text(cont.contacttel);
                $($("#cont_" + index).find("td")[3]).text(cont.contactphone);
                $($("#cont_" + index).find("td")[4]).text(cont.contactno);
                $($("#cont_" + index).find("td")[5]).text(cont.contactemail);
                $($("#cont_" + index).find("td")[6]).text(cont.iscore == 1 ? "是" : "否");
                $($("#cont_" + index).find("td")[8]).text(cont.contactid);
                $($("#cont_" + index).find("td")[9]).text(JSON.stringify(cont));
            }
            $("#conWin").modal('hide');
        }

        function editContact(index) {
            $("#contForm").resetForm();
            $("#iscore1").removeProp("checked");
            $("#iscore2").removeProp("checked");
            $("#tr_index").val(index);
            var td = $("#cont_" + index).find("td");
            if(td.length > 9){
                var cont = $.parseJSON($.trim($($(td[9])).text()));
                $("#contactname").val(cont.contactname);
                $("#contactposition").val(cont.contactposition);
                $("#contacttel").val(cont.contacttel);
                $("#contactphone").val(cont.contactphone);
                $("#contactno").val(cont.contactno);
                $("#contactemail").val(cont.contactemail);
                if(cont.iscore == 1) {
                    $("#iscore1").prop('checked', 'checked');
                } else if(cont.iscore == 2){
                    $("#iscore2").prop('checked', 'checked');
                }
                $("#contactid").val(cont.contactid);
            }
            $("#conWin").modal({
                backdrop: false,
                keyboard: false
            });
        }

        function removeContact(index){
            var td = $("#cont_" + index).find("td");
            var contactid = $.trim($(td[8]).text());
            if(contactid > 0){
                var delIds = $("#deletecontactids").val();
                if(delIds.length > 0){
                    delIds += ",";
                }
                delIds += contactid;
                $("#deletecontactids").val(delIds);
            }
            $("#cont_" + index).remove();
        }
    </script>
</head>
<body>
<div class="container">
    <%--<div class="row">--%>
    <%--<div class="col-lg-3" style="box-shadow:inset 1px -1px 1px #444, inset -1px 1px 1px #444;height: 800px">--%>
    <%--<jsp:include page="/um/include/left.jsp"/>--%>
    <%--</div>--%>

    <div style="box-shadow: inset 1px -1px 1px #bce8f1, inset -1px 1px 1px #bce8f1;height: 800px">
        <div class="panel panel-primary">
            <div class="panel-heading">
                <div class="panel-title">
                    企业基本信息
                </div>
            </div>
            <div class="panel-body">
                <form class="form-horizontal" id="comForm" method="post" role="form">
                    <input type="hidden" id="id" name="id" value="${param.cid}">
                    <input type="hidden" id="deletecontactids" name="deletecontactids">
                    <input type="hidden" id="contacts" name="contacts">

                    <div class="form-group">
                        <label class="col-sm-2 control-label" for="companyname">企业名称</label>

                        <div class="col-sm-3">
                            <input class="form-control" type="text" id="companyname" name="companyname"
                                   value="${company.companyname}"
                                   placeholder="请输入企业名称"/>
                        </div>
                        <label class="col-sm-2 control-label" for="companycode">组织机构代码</label>

                        <div class="col-sm-3">
                            <input class="form-control" type="text" id="companycode" name="companycode"
                                    value="${company.companycode}"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label" for="companytype">企业性质</label>

                        <div class="col-sm-3">
                            <input class="form-control" type="text" id="companytype" name="companytype">
                        </div>
                        <label class="col-sm-2 control-label" for="industryname">行业</label>

                        <div class="col-sm-3">
                            <input class="form-control" type="text" id="industryname" name="industryname">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label" for="area">地区</label>

                        <div class="col-sm-3">
                            <input class="form-control" type="text" id="area" name="area">
                        </div>
                        <label class="col-sm-2 control-label" for="gm">注册规模</label>

                        <div class="col-sm-3">
                            <input class="form-control" type="text" id="gm" name="gm">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label" for="legal">法人</label>

                        <div class="col-sm-3">
                            <input class="form-control" type="text" id="legal" name="legal">
                        </div>
                        <label class="col-sm-2 control-label" for="industryname">总资产</label>

                        <div class="col-sm-3">
                            <input class="form-control" type="text" id="capital" name="capital">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label" for="f1">营业执照注册号</label>

                        <div class="col-sm-3">
                            <input class="form-control" type="text" id="f1" name="f1">
                        </div>
                        <label class="col-sm-2 control-label" for="f2">通讯地址</label>

                        <div class="col-sm-3">
                            <input class="form-control" type="text" id="f2" name="f2">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label" for="f3">年份</label>

                        <div class="col-sm-3">
                            <input class="form-control" type="text" id="f3" name="f3">
                        </div>
                        <label class="col-sm-2 control-label" for="f4">季度</label>

                        <div class="col-sm-3">
                            <input class="form-control" type="text" id="f4" name="f4">
                        </div>
                    </div>

                </form>
            </div>
        </div>

        <div class="panel panel-primary">
            <div class="panel-heading">
                <div class="panel-title">
                    联系人信息
                </div>
            </div>
            <div class="panel-body">
                <div class="btn-toolbar" role="toolbar">
                    <div class="btn-group">
                        <button type="button" class="btn btn-default" onclick="addContact();">新增</button>
                    </div>
                </div>
                <table class="table table-condensed table-hover" id="contacttable">
                    <thead>
                    <tr>
                        <th style="font-size: 14px; font-family: Arial">联系人姓名</th>
                        <th style="font-size: 14px; font-family: Arial">是否为主要联系人</th>
                        <th style="font-size: 14px; font-family: Arial">办公电话</th>
                        <th style="font-size: 14px; font-family: Arial">手机</th>
                        <th style="font-size: 14px; font-family: Arial">传真号码</th>
                        <th style="font-size: 14px; font-family: Arial">电子邮箱</th>
                        <th style="font-size: 14px; font-family: Arial">职位</th>
                        <th style="font-size: 14px; font-family: Arial">操作</th>
                        <th style="display: none"></th>
                        <th style="display: none"></th>
                    </tr>
                    </thead>
                    <tbody id="contactbody">
                        <c:forEach items="${contlist}" var="cont" varStatus="step">
                            <tr id="cont_${step.count}">
                                <td> ${cont.contactname} </td>
                                <td> ${cont.contactposition} </td>
                                <td> ${cont.contacttel} </td>
                                <td> ${cont.contactphone} </td>
                                <td> ${cont.contactno} </td>
                                <td> ${cont.contactemail} </td>
                                <td> ${cont.iscore == 1 ? "是" : cont.iscore == 2 ? "否" : ""} </td>
                                <td>
                                    <a href="javascript:editContact('${step.count}')">编辑</a>&nbsp;
                                    <a href="javascript:removeContact('${step.count}')">删除</a>&nbsp;
                                </td>
                                <td style='display: none'> ${cont.contactid} </td>
                                <td style='display: none'> ${cont.contstr} </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <div>
            <p style="margin-left: 80px">
                <button type="button" class="btn btn-primary btn-lg" onclick="saveCompany();">提交</button>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <button type="button" class="btn btn-primary btn-lg">关闭</button>
            </p>
        </div>
    </div>
    <%--</div>--%>
    <div class="modal fade" id="conWin" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
         aria-hidden="true" style="display: none;">
        <div class="modal-dialog" style="width: 900px">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                    <h4 class="modal-title" id="myModalLabel" contenteditable="false">新增联系人</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" id="contForm" method="post" role="form">
                        <input type="hidden" id="tr_index" name="tr_index" value="">
                        <input type="hidden" id="contactid" name="contactid" value="0">
                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="contactname">联系人姓名</label>
                            <div class="col-sm-4">
                                <input class="form-control" type="text" id="contactname" name="contactname">
                            </div>
                            <label class="col-sm-2 control-label" for="contactposition">联系人职位</label>
                            <div class="col-sm-4">
                                <input class="form-control" type="text" id="contactposition" name="contactposition"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="contacttel">办公电话</label>
                            <div class="col-sm-4">
                                <input class="form-control" type="text" id="contacttel" name="contacttel">
                            </div>
                            <label class="col-sm-2 control-label" for="contactphone">手机</label>
                            <div class="col-sm-4">
                                <input class="form-control" type="text" id="contactphone" name="contactphone"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="contactno">传真号码</label>
                            <div class="col-sm-4">
                                <input class="form-control" type="text" id="contactno" name="contactno">
                            </div>
                            <label class="col-sm-2 control-label" for="contactemail">电子邮箱</label>
                            <div class="col-sm-4">
                                <input class="form-control" type="text" id="contactemail" name="contactemail"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="contactno">是否为主要联系人</label>
                            <div class="col-sm-4">
                                <div class="row">
                                    <label class="col-sm-2 control-label" for="iscore1">是</label>
                                    <div class="radio-inline col-sm-4">
                                        <input class="form-control" type="radio" id="iscore1" name="iscore" value="1">
                                    </div>
                                    <label class="col-sm-2 control-label" for="iscore2">否</label>
                                    <div class="radio-inline col-sm-4">
                                        <input class="form-control" type="radio" id="iscore2" name="iscore" value="2">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" contenteditable="true" onclick="saveContact();">保存</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal" contenteditable="true">关闭</button>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>
