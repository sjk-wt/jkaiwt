<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="headHtml.jsp" %>

<div class="container content news">

    <div class="main left">
        <section class="newsFull">
            <div class="newsHeader">
                <h1 style="color: #FFA908">联系方式</h1>
                <h4>posted on
                    06-07-2015
                </h4>
            </div>


            <div class="contact-message">
                <p><span class="contact-name">优源官方合伙人 - 幂幂</span></p>

                <p>
                    <li class="fa fa-phone">&nbsp;&nbsp;&nbsp;&nbsp;手机：18394039665</li>
                </p>

                <p>
                    <li class="fa fa-star">&nbsp;&nbsp;&nbsp;&nbsp;微信：wt081001</li>
                </p>

                <p>
                <li class="fa fa-group">&nbsp;&nbsp;&nbsp;&nbsp;QQ：1013949300</li>
                </p>

                <p>
                <li class="fa fa-envelope-o">&nbsp;&nbsp;&nbsp;&nbsp;邮箱：1013949300@qq.com</li>
                </p>
            </div>

            <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>

            <p><strong style="color: #FFA908">AO！NO！</strong></p>

            <p style="color: #FFA908">如果您害羞不好意思主动联系我，没有关系，您可以在下面留下联系方式，我会主动联系您.&nbsp;<br>
                <br>
                您主动、或者我主动、咱们就有故事了.
            </p>

            <p>
                <form action="#" method="post">
                    <table border="1" class="contact-table-from" >
                        <tr>
                            <td>您的名字：</td>
                            <td><input type="text" name="name" placeholder="称呼" /></td>
                            <td>电话：</td>
                            <td><input type="text" name="name" placeholder="电话"/></td>
                        </tr>
                        <tr>
                            <td>微信：</td>
                            <td><input type="text" name="name" placeholder="微信"/></td>
                            <td>QQ：</td>
                            <td><input type="text" name="name" placeholder="QQ"/></td>
                        </tr>
                        <tr>
                            <td>邮箱：</td>
                            <td><input type="text" name="name" placeholder="邮箱"/></td>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td colspan="4"><center><input type="submit" value="提交"/></center></td>
                        </tr>
                    </table>
                </form>
            </p>

        </section>
    </div>

    <%@include file="rigthHtml.jsp" %>

</div>

<%@include file="footHtml.jsp" %>

<script type="text/javascript">

    $(document).ready(function () {
        $("#contacta").addClass("active");
        $("#contacta").css("color", "#FFA908");
       $("#lxfs").css("border-color", "#FFA908");
        $("#lxfs h3").css("color", "#FFA908");
       $("#showAll").css("color", "#FFA908");
       $("#htmlBody").css("border-color", "#FFA908");
    });

</script>