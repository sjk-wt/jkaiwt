<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="headHtml.jsp" %>

<input id="colorInput" style="display: none" type="text" value="${pcolor}"/>
<input id="codeInput" style="display: none" type="text" value="${proCode}"/>
<input id="idInput" style="display: none" type="text" value="${proId}"/>

<div class="container content news">

    <div class="main left">
        <section class="newsFull">
            <div class="newsHeader">
                <h1 id="titleText">${title}</h1>
                <h4>posted on
                    <fmt:formatDate value="${instartTime}" pattern="yyyy-MM-dd"/>
                </h4>
            </div>

            <p><strong>Hi.优源</strong></p>
            <p id="outlintTxt"></p>

            <h3></h3>

            <div class="message-div">
                <h3 id="effectH3">产品功效</h3>
                <p>
                    <span id="effectTxt"></span>
                    <img id="effectImg" style="float: right; padding-left: 15px" alt="" width="370" height="278">
                </p>
            </div>

            <div class="message-div">
                <h3 id="useH3">使用方法​</h3>
                <p>
                    <img id="useImg" style="float: left; padding-right: 15px" alt="" width="370" height="278">
                    <span id="useTxt"></span>
                </p>
            </div>

            <div class="message-div">
                <h3 id="capacityH3">产品容量</h3>
                <p>
                    <img id="capacityImg" style="float: right; padding-left: 15px" alt="" width="370" height="278">
                    <span id="capacityTxt"></span>
                </p>
            </div>

            <div class="message-div">
                <h3 id="ensureH3">售后保障</h3>
                <span id="ensureTxt"></span>
                <p>
                    <img id="ensureImg1" style="float: left; padding-right: 15px" alt="" width="370" height="278">
                    <img id="ensureImg2" style="float: left; padding-right: 15px" alt="" width="370" height="278">
                    <img id="ensureImg3" style="float: left; padding-right: 15px" alt="" width="370" height="278">
                    <img id="ensureImg4" style="float: left; padding-right: 15px" alt="" width="370" height="278">
                    <br>
                </p>
            </div>

        </section>

    </div>

    <%@include file="rigthHtml.jsp" %>

</div>

<%@include file="footHtml.jsp" %>

<script type="text/javascript">

    $(document).ready(function () {
        //渲染详情页背景、title颜色
        colorFun($("#codeInput").val(), $("#colorInput").val());

        //主体内容加载
        $.ajax({
            url: "${pageContext.request.contextPath}/rest/product/getProMessage",
            type: "GET",
            dataType: "json",
            data: {
                id: $("#idInput").val()
            },
            success: function (result) {
                var product = result.data;
                console.log(product);
                proMessage(product);
            },
            error: function () {

            }
        });
    });

    //渲染详情页背景、title颜色
    function colorFun(id, color) {
        $("#" + id).css("border-color", color);
        $("#showAll").css("color", color);
        $("#titleText").css("color", color);
        $("#" + id + " h3").css("color", color);
        $("#htmlBody").css("border-color", color);
    }

    //主体内容加载
    function proMessage(product) {
        var outlinttent = product.outline;

        var effectpic = product.effectpic;
        var effecttent = product.effecttent;

        var usepic = product.usepic;
        var usetent = product.usetent;

        var capacitypic = product.capacitypic;
        var capacitytent = product.capacitytent;

        var ensurepic = product.ensurepic;
        var ensuretent = product.ensuretent;

        //简介
        if (outlinttent != null && outlinttent != '') {
            $("#outlintTxt").text(outlinttent);
        }

        //产品功效
        if (effecttent != null && effecttent != '') {
            $("#effectTxt").text(effecttent);
        }
        if (effectpic != null && effectpic != '') {
            $("#effectImg").attr("src", "${pageContext.request.contextPath}" + effectpic);
        }
        if ((effecttent == null || effecttent == '') && (effectpic == null || effectpic == '')) {
            $("#effectH3").css("display", "none");
        }

        //使用方法​
        if (usetent != null && usetent != '') {
            $("#useTxt").text(usetent);
        }
        if (usepic != null && usepic != '') {
            $("#useImg").attr("src", "${pageContext.request.contextPath}" + usepic);
        }
        if ((usetent == null || usetent == '') && (usepic == null || usepic == '')) {
            $("#useH3").css("display", "none");
        }

        //产品容量
        if (capacitytent != null && capacitytent != '') {
            $("#capacityTxt").text(capacitytent);
        }
        if (capacitypic != null && capacitypic != '') {
            $("#capacityImg").attr("src", "${pageContext.request.contextPath}" + capacitypic);
        }
        if ((capacitytent == null || capacitytent == '') && (capacitypic == null || capacitypic == '')) {
            $("#capacityH3").css("display", "none");
        }

        //售后保障
        if (ensuretent != null && ensuretent != '') {
            $("#ensureTxt").text(ensuretent);
        }
        if (ensurepic != null && ensurepic != '') {
            var urls = ensurepic.split(",");
            for (var i = 0; i< urls.length; i++) {
                $("#ensureImg" + (i+1)).attr("src", "${pageContext.request.contextPath}" + urls[i]);
            }
        }
        if ((ensuretent == null || ensuretent == '') && (ensurepic == null || ensurepic == '')) {
            $("#ensureH3").css("display", "none");
        }

    }

</script>