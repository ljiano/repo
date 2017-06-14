<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    request.setAttribute("contextPath", request.getContextPath());
    request.setAttribute("path", request.getContextPath());
%>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link href="${contextPath}/script/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"/>
<!-- 可选的Bootstrap主题文件（一般不使用） -->
<link href="${contextPath}/script/bootstrap/3.3.7/css/bootstrap-theme.min.css" rel="stylesheet"/>

<script type="text/javascript" src="${contextPath}/script/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="${contextPath}/script/js/jquery-form.js"></script>
<script type="text/javascript" src="${contextPath}/script/js/page.js"></script>
<script type="text/javascript" src="${contextPath}/script/js/select2/select2.js"></script>

<link href="${contextPath}/script/css/page.css" rel="stylesheet"/>
<link href="${contextPath}/script/css/select2/select2.css" rel="stylesheet"/>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script type="text/javascript" src="${contextPath}/script/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${contextPath}/script/js/company.js"></script>
<!-- width 属性控制设备的宽度。假设您的网站将被带有不同屏幕分辨率的设备浏览，那么将它设置为 device-width 可以确保它能正确呈现在不同设备上。
initial-scale=1.0 确保网页加载时，以 1:1 的比例呈现，不会有任何的缩放。-->
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!--  maximum-scale=1.0 与 user-scalable=no 一起使用。这样禁用缩放功能 -->
<%--<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">--%>