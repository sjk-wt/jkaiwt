<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="headHtml.jsp"%>

<div class="container content cols news">

    <%-- 新品发布  特价活动 --%>
    <a class="col3 newsItem" href="${pageContext.request.contextPath}/rest/product/activityMessage?id=${activit.id}" target="_blank">
        <div class="newsThumb">
            <div class="overlay" style="background-color: red;">
            </div>
            <h2>
                read more
            </h2>

            <img src="${pageContext.request.contextPath}${activit.coverpic}">

        </div>
        <div class="newsContent">
            <h2 style="color: red;">${activit.name}</h2>
            <h5>
                <fmt:formatDate value="${activit.activitystarttime}" pattern="yyyy-MM-dd"/>
            </h5>
            <p>${activit.covertxt}</p>
        </div>
    </a>

    <%-- 优源洗护套装 --%>
    <a class="col3 newsItem" href="${pageContext.request.contextPath}/rest/product/productMessage?id=f0542a48-6dce-4785-bb8e-44bb65bbf6f6" target="_blank">
        <div class="newsThumb">
            <div class="overlay" style="background-color: #C98B07;">
            </div>
            <h2>
                read more
            </h2>

            <img src="${pageContext.request.contextPath}/imgs/fengmian/yyxhtzfm.jpg">

        </div>
        <div class="newsContent">
            <h2 style="color: #C98B07;">优源洗护套装</h2>
            <h5>
                06-07-2015
            </h5>
            <p>I am Marlies Verbeken and I would like to introduce myself. As a final-year graphic design student at
                Artevelde University College Ghent, I entered the world of Chilli and I was instantly swept up in
                the adventure.</p>
        </div>
    </a>

    <%-- 加盟 代理 --%>
    <a class="col3 newsItem" href="#" target="_blank">
        <div class="newsThumb">
            <div class="overlay" style="background-color: #8a1aa3;">
            </div>
            <h2>
                read more
            </h2>

            <img src="${pageContext.request.contextPath}/tao/product/images/aerosleep-safe-sleep_370_278shar-50_c1.jpg">

        </div>
        <div class="newsContent">
            <h2 style="color: #8a1aa3;">加盟 代理</h2>
            <h5>
                04-27-2015
            </h5>
            <p>Wij zoeken een digital designer/developer. Een teamplayer, met grafische voeling en technisch talent,
                die meewerkt aan de ontwikkeling van creatieve websites.</p>
        </div>
    </a>

    <%-- 产品遍历 --%>
    <c:forEach items="${products}" var="pro">

        <a class="col3 newsItem productfm" href="${pageContext.request.contextPath}/rest/product/productMessage?id=${pro.id}" target="_blank">
            <div class="newsThumb">
                <div class="overlay" style="background-color: ${pro.pcolor}">
                </div>
                <h2>
                    read more
                </h2>

                <img src="${pageContext.request.contextPath}${pro.coverpic}">

            </div>
            <div class="newsContent">
                <h2>${pro.name}</h2>
                <h5>
                    <fmt:formatDate value="${pro.instarttime}" pattern="yyyy-MM-dd"/>
                </h5>
                <p>${pro.outline}</p>
            </div>
        </a>

    </c:forEach>

</div>

<section class="social">
    <h5>More news on:</h5>
    <a href="https://twitter.com/we_are_chilli">T</a>
    <a href="http://instagram.com/wearechilli">I</a>
    <a href="https://www.facebook.com/wearechilli">F</a>
</section>

<%@include file="footHtml.jsp"%>

<script type="text/javascript">

    $(document).ready(function () {

    });

</script>