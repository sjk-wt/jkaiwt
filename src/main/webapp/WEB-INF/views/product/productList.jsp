<%--
  Created by IntelliJ IDEA.
  User: hccl
  Date: 2017/10/20
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="headHtml.jsp" %>

<div class="container content news">

    <div class="main left">
        <section class="newsFull">
            <div class="newsHeader">
                <h1 id="titleText">产品列表</h1>
                <h4>

                </h4>
            </div>

            <div>
                <ol id="messgePro" style="line-height: 25px;">
                </ol>
            </div>

        </section>

    </div>

    <%@include file="rigthHtml.jsp" %>

</div>

<%@include file="footHtml.jsp" %>

<script type="text/javascript">

    $(document).ready(function () {
        //渲染详情页背景、title颜色
        colorFun();

        //主体内容加载
        $.ajax({
            url: "${pageContext.request.contextPath}/rest/product/getProducts",
            type: "POST",
            dataType: "json",
            success: function (result) {
                var activity = result.data;
                proMessage(activity);
            },
            error: function () {
            }
        });

    });

    //渲染详情页背景、title颜色
    function colorFun(color) {
        $("#productlist").addClass("active");
        $("#contacta").removeClass("active");
        $("#productlist").css("color", "#8a1aa3");
        $("#showAll").css("color", "#8a1aa3");
        $("#titleText").css("color", "#8a1aa3");
        $("#htmlBody").css("border-color", "#8a1aa3");
    }

    //主体内容加载
    function proMessage(activity) {
        var olHtml = $("#messgePro");
        for (var i = 0; i<activity.length; i++) {
            console.log(activity[i].id);
            console.log(activity[i].coverpic);
            var liHtml = $('<li class="product-list-li">' +
                '<a href="${pageContext.request.contextPath}/rest/product/productMessage?id='+activity[i].id+'">' +
                '<img src="${pageContext.request.contextPath}'+activity[i].coverpic+'" height="100px" width="100px">' +
                '<span>'+activity[i].name+'</span>' +
                '<span>'+activity[i].outline+'</span>' +
                '</a>' +
                '</li>');
            olHtml.append(liHtml)
        }
    }

</script>
