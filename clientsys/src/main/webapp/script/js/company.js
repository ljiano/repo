var comp = new Object();

comp.selectCompany = function (select2_id, flag){
    if (!flag) flag = false;
    $("#" + select2_id).select2({
        width: "150px",
        multiple: flag,
        placeholder: "企业名称或代码",
        minimumInputLength: 1,	//至少输入n个字符，才去加载数据
        allowClear: true,	//是否允许用户清除文本信息
        ajax: {
            url: '/company/comps',	//地址
            contentType:"application/x-www-form-urlencoded;charset=UTF-8",
            delay: 250,
            dataType: 'json',	//接收的数据类型
            data: function (term, pageNo) {		//在查询时向服务器端传输的数据
                term = $.trim(term);
                return {
                    compinput: term, 	//联动查询的字符
                    pageSize: 1,	//一次性加载的数据条数
                    pageNo: pageNo,	//页码
                    time: new Date()//测试
                }
            },
            results: function (data, pageNo) {
                return {results: data};
            }
        },
        initSelection: function (element, callback) {
            var id = $(element).val();
            if (id !== "") {
                $.ajax("/company/comp?comp=" + id, {
                    dataType: "json"
                }).done(function (data) {
                    alert(data);
                    callback(data);
                });
            }
        },
        formatResult: function (obj) {
            return obj.companyname + "(" + obj.companycode + ")";
        },
        formatSelection: function (obj) {
            $("#" + select2_id + "_hiddenname").remove();
            $("#" + select2_id).after("<input type='hidden' id='" + select2_id + "_hiddenname' value='" + obj.id + "' />");
            return obj.companyname + "(" + obj.companycode + ")";
        }
    });
    return true;
};