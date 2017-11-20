<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="headHtml.jsp" %>

<input id="colorInput" style="display: none" type="text" value="red"/>
<input id="idInput" style="display: none" type="text" value="${actId}"/>

<div class="container content news">

    <div class="main left">
        <section class="newsFull">
            <div class="newsHeader">
                <h1 id="titleText">${title}</h1>
                <h4>
                    <fmt:formatDate value="${instartTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                    --->
                    <fmt:formatDate value="${endTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                    <span id="engTimeSpan" style="display: none">
                        <fmt:formatDate value="${endTime}" pattern="yyyy/MM/dd HH:mm:ss"/>
                    </span>
                </h4>
            </div>

            <video id="videoStyle" width="775" height="362" controls>
                <source id="videoUrl" type="video/mp4">
                <%--<source src="movie.ogg" type="video/ogg">--%>
                您的浏览器不支持 video 标签。
            </video>
            <p id="videoTxt"></p>

            <h3 id="dayNumH3">剩余时间</h3>
            <p id="dayNumTxt" class="colockbox">
                <span class="day">00</span> <span class="hour">00</span> <span class="minute">00</span> <span class="second">00</span>
            </p>

            <h3></h3>

            <h3 id="outlintH3">产品简介</h3>
            <p id="outlintTxt"></p>


            <h3 id="activityH3">活动说明</h3>
            <p>
                <img id="activityImg" style="float: left; padding-right: 15px" alt="" width="370" height="278">
                <span id="activityTxt"></span>
            </p>
            <br/>

            <h3 id="effectH3">产品功效</h3>
            <p>
                <img id="effectImg" style="float: left; padding-right: 15px" alt="" width="370" height="278">
                <span id="effectTxt"></span>
            </p>
            <br/>

            <h3 id="useH3">使用方法​</h3>
            <p>
                <img id="useImg" style="float: left; padding-right: 15px" alt="" width="370" height="278">
                <span id="useTxt"></span>
            </p>
            <br/>

            <h3 id="capacityH3">产品容量</h3>
            <p>
                <img id="capacityImg" style="float: right; padding-left: 15px" alt="" width="370" height="278">
                <span id="capacityTxt"></span>
            </p>
            <br/>

            <h3 id="ensureH3">售后保障</h3>
            <p>
                <img id="ensureImg" style="float: right; padding-left: 15px" alt="" width="370" height="278">
                <span id="ensureTxt"></span>
                <br>
            </p>

        </section>

    </div>

    <%@include file="rigthHtml.jsp" %>

</div>

<%@include file="footHtml.jsp" %>

<script type="text/javascript">

    $(document).ready(function () {
        //渲染详情页背景、title颜色
        colorFun($("#colorInput").val());

        //主体内容加载
        $.ajax({
            url: "${pageContext.request.contextPath}/rest/product/getActivityMessage",
            type: "POST",
            dataType: "json",
            data: {
                id: $("#idInput").val()
            },
            success: function (result) {
                var activity = result.data;
                proMessage(activity);
            },
            error: function () {
            }
        });

        //倒计时
        countDown($("#engTimeSpan").text().trim(), "#dayNumTxt");

    });

    //渲染详情页背景、title颜色
    function colorFun(color) {
        $("#newPro").css("border-color", color);
        $("#showAll").css("color", color);
        $("#titleText").css("color", color);
        $("#newPro h3").css("color", color);
        $("#htmlBody").css("border-color", color);
    }

    //主体内容加载
    function proMessage(activity) {

        var aEndTime = activity.aEndTime;
        var aTxt = activity.aTxt;
        var aImg = activity.aImg;
        var videlUrl = activity.videlUrl;
        var videotTxt = activity.videotTxt;

        //活动剩余时间
        if (aEndTime == null || aEndTime == '') {
            $("#dayNumH3").css("display", "none");
        }

        //视屏
        if (videotTxt != null && videotTxt != '') {
            $("#videoTxt").text(videotTxt);
        }
        if (videlUrl != null && videlUrl != '') {
            $("#videoUrl").attr("src", "${pageContext.request.contextPath}" + videlUrl);
            $("#videoStyle").load();
        }
        if ((videotTxt == null || videotTxt == '') && (videlUrl == null || videlUrl == '')) {
            $("#videoStyle").css("display", "none");
        }

        //活动说明
        if (aTxt != null && aTxt != '') {
            $("#activityTxt").text(aTxt);
        }
        if (aImg != null && aImg != '') {
            $("#activityImg").attr("src", "${pageContext.request.contextPath}" + aImg);
        }
        if ((aTxt == null || aTxt == '') && (aImg == null || aImg == '')) {
            $("#activityH3").css("display", "none");
        }

        var outlinttent = activity.outline;

        var effectpic = activity.effectpic;
        var effecttent = activity.effecttent;

        var usepic = activity.usepic;
        var usetent = activity.usetent;

        var capacitypic = activity.capacitypic;
        var capacitytent = activity.capacitytent;

        var ensurepic = activity.ensurepic;
        var ensuretent = activity.ensuretent;

        //简介
        if (outlinttent != null && outlinttent != '') {
            $("#outlintTxt").text(outlinttent);
        }
        if (outlinttent == null || outlinttent == '') {
            $("#outlintH3").css("display", "none");
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
            $("#ensureImg").attr("src", "${pageContext.request.contextPath}" + ensurepic);
        }
        if ((ensuretent == null || ensuretent == '') && (ensurepic == null || ensurepic == '')) {
            $("#ensureH3").css("display", "none");
        }
    }

    //倒计时
    function countDown(time,id){
        var day_elem = $(id).find('.day');
        var hour_elem = $(id).find('.hour');
        var minute_elem = $(id).find('.minute');
        var second_elem = $(id).find('.second');
        var end_time = new Date(time).getTime(),//月份是实际月份-1
            sys_second = (end_time-new Date().getTime())/1000;
        var timer = setInterval(function(){
            if (sys_second > 1) {
                sys_second -= 1;
                var day = Math.floor((sys_second / 3600) / 24);
                var hour = Math.floor((sys_second / 3600) % 24);
                var minute = Math.floor((sys_second / 60) % 60);
                var second = Math.floor(sys_second % 60);
                day_elem && $(day_elem).text(day);//计算天
                $(hour_elem).text(hour<10?"0"+hour:hour);//计算小时
                $(minute_elem).text(minute<10?"0"+minute:minute);//计算分钟
                $(second_elem).text(second<10?"0"+second:second);//计算秒杀
                if (day == "0" && hour == "00" && minute == "00" && second == "00") {
                    dataEnd();
                }
            } else {
                clearInterval(timer);
            }
        }, 1000);
    }

    //倒计时结束后
    function dataEnd() {
        console.log("activity is over");
        $.ajax({
            url: "${pageContext.request.contextPath}/rest/product/changeActivity",
            type: "POST",
            dataType: "json",
            data: {
                id: $("#idInput").val()
            },
            success: function (result) {
                var activity = result.data;
                if (activity == 1) {
                    alert("活动结束了!");
                    window.location.href = "${pageContext.request.contextPath}/rest/product/index"
                }
            },
            error: function () {
            }
        });
    }

</script>