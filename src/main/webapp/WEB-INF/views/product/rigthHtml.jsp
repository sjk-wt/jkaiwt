<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="sidebar right">
    <nav>

        <%--新品发布、优惠活动--%>
        <a id="newPro" href="${pageContext.request.contextPath}/rest/product/activityMessage?id=${activit.id}">
            <h3>${activit.name}</h3>
            <h5>
                06-14-2016
            </h5>
        </a>

        <%--优源洗护套装--%>
        <a id="YYXHTZ" href="${pageContext.request.contextPath}/rest/product/productMessage?id=f0542a48-6dce-4785-bb8e-44bb65bbf6f6">
            <h3>优源洗护套装</h3>
            <h5>
                <fmt:formatDate value="${activit.activitystarttime}" pattern="yyyy-MM-dd"/>
            </h5>
        </a>

        <%--加盟 代理--%>
        <a id="jiaMen" href="https://chilli.be/en/news/chilli-zoekt-designer-developer">
            <h3>加盟 代理</h3>
            <h5>
                04-27-2015
            </h5>
        </a>

        <%--产品列表--%>
        <c:forEach items="${productsName}" var="pro">

            <a id="${pro.code}" href="${pageContext.request.contextPath}/rest/product/productMessage?id=${pro.id}">
                <h3>${pro.name}</h3>
                <h5>
                    <fmt:formatDate value="${pro.instarttime}" pattern="yyyy-MM-dd"/>
                </h5>
            </a>

        </c:forEach>

        <%--联系方式--%>
        <a id="lxfs" href="${pageContext.request.contextPath}/rest/product/contactMessage">
            <h3>联系方式</h3>
            <h5>
                05-15-2014
            </h5>
        </a>

        <a href="${pageContext.request.contextPath}/rest/product/index" class="all">
            <h3 id="showAll">show all</h3>
        </a>

    </nav>
</div>
