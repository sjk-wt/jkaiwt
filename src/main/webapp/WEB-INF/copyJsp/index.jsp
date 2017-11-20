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

            <img src="${pageContext.request.contextPath}/tao/product/images/BO-news-tmb_370_278shar-50_c1.jpg">

        </div>
        <div class="newsContent">
            <h2>优源洗护套装</h2>
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
            <div class="overlay" style="background-color: purple;">
            </div>
            <h2>
                read more
            </h2>

            <img src="${pageContext.request.contextPath}/tao/product/images/aerosleep-safe-sleep_370_278shar-50_c1.jpg">

        </div>
        <div class="newsContent">
            <h2>加盟 代理</h2>
            <h5>
                04-27-2015
            </h5>
            <p>Wij zoeken een digital designer/developer. Een teamplayer, met grafische voeling en technisch talent,
                die meewerkt aan de ontwikkeling van creatieve websites.</p>
        </div>
    </a>

    <%-- 产品遍历 --%>
    <c:forEach items="${products}" var="pro">

        <a class="col3 newsItem" href="${pageContext.request.contextPath}/rest/product/productMessage?id=${pro.id}" target="_blank">
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

    <%-- 公司信誉 --%>
    <a class="col3 newsItem" href="#" target="_blank">
        <div class="newsThumb">
            <div class="overlay" style="background-color:#3982be">
            </div>
            <h2>
                read more
            </h2>

            <img src="${pageContext.request.contextPath}/tao/product/images/dotgent_370_278shar-50_c1.png">

        </div>
        <div class="newsContent">
            <h2>公司信誉</h2>
            <h5>
                07-31-2014
            </h5>
            <p>With .gent, the most beautiful city in Flanders will have its own domain extension. In the course of
                2014, the famous .BE &amp; .COM extensions will be joined by a multitude of new variations,
                including .GENT.&nbsp;</p>
        </div>
    </a>

    <%-- 防伪查询 --%>
    <a class="col3 newsItem" href="http://www.fangwei315.com/" target="_blank">
        <div class="newsThumb">
            <div class="overlay" style="background-color:#ff50a5">
            </div>
            <h2>
                read more
            </h2>

            <img src="${pageContext.request.contextPath}/tao/product/images/BO-news-tmb_370_278shar-50_c1.jpg">

        </div>
        <div class="newsContent">
            <h2>防伪查询</h2>
            <h5>
                06-05-2014
            </h5>
            <p>Bo Struyf is a young architect with a modern view of architecture. Chilli translated that modern
                vision into a playful house style …</p>
        </div>
    </a>

    <%-- 联系方式 --%>
    <a class="col3 newsItem" href="${pageContext.request.contextPath}/rest/product/contactMessage" target="_blank">
            <div class="newsThumb">
                <div class="overlay" style="background-color: #FFA908">
                </div>
                <h2>
                    read more
                </h2>

                <img src="${pageContext.request.contextPath}/tao/product/images/Kalender-news-1_370_278shar-50_c1.jpg">

            </div>
            <div class="newsContent">
                <h2>联系方式</h2>
                <h5>
                    01-01-2014
                </h5>
                <p>Calendars… All too often their pages are torn up, used as scribble pads, flipped over, thrown away or
                    simply forgotten. And those that do eventually make it on to a wall just hang there in plain view
                    all year round. Why not make them into a design object?</p>
            </div>
        </a>

    <%-- 我的故事 --%>
    <a class="col3 newsItem" href="#" target="_blank">
        <div class="newsThumb">
            <div class="overlay" style="background-color:#f22477">
            </div>
            <h2>
                read more
            </h2>

            <img src="${pageContext.request.contextPath}/tao/product/images/ANIMAL_LOGO_THUMB_370_278shar-50_c1.jpg">

        </div>
        <div class="newsContent">
            <h2>我的故事</h2>
            <h5>
                11-11-2013
            </h5>
            <p>Just the other day we discovered this small booklet in our letterbox. ‘Animal Logo’ is a collection
                of inspiring animal logos and symbols. It contains a total of 266 logos, 3 of which are ours.</p>
        </div>
    </a>

    <%-- 企业文化 --%>
    <a class="col3 newsItem" href="#" target="_blank">
        <div class="newsThumb">
            <div class="overlay" style="background-color:#90d471">
            </div>
            <h2>
                read more
            </h2>

            <img src="${pageContext.request.contextPath}/tao/product/images/fonts_370_278shar-50_c1.png">

        </div>
        <div class="newsContent">
            <h2>企业文化</h2>
            <h5>
                06-11-2014
            </h5>
            <p>At Chilli we are passionate about fonts and as you can see from our logos &amp; websites, we always
                attach a great deal of importance to the typographical aspect.</p>
        </div>
    </a>

    <%-- 企业新闻 --%>
    <a class="col3 newsItem" href="#" target="_blank">
            <div class="newsThumb">
                <div class="overlay" style="background-color:#90d471">
                </div>
                <h2>
                    read more
                </h2>

                <img src="${pageContext.request.contextPath}/tao/product/images/fonts_370_278shar-50_c1.png">

            </div>
            <div class="newsContent">
                <h2>企业新闻</h2>
                <h5>
                    06-11-2014
                </h5>
                <p>At Chilli we are passionate about fonts and as you can see from our logos &amp; websites, we always
                    attach a great deal of importance to the typographical aspect.</p>
            </div>
        </a>

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