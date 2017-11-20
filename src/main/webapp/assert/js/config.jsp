<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2016/9/7
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
    var baseCodeContentPath = "<%=basePath%>";

