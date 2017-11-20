<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title> 幂幂官网后台管理系统</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assert/css/index.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assert/css/font.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assert/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app/qTip2/jquery.qtip.min.css" />
    <script src="${pageContext.request.contextPath}/assert/js/jquery.js" ></script>
    <script src="${pageContext.request.contextPath}/assert/js/bootstrap.min.js"></script>
</head>
<body id="body">

<!--提示框-->
<div class="prompt">
    <b>提示！</b>
    <p>请选择要编辑的行。</p>
</div>

<!--警示框-->
<div class="promptError">
    <b>警示！</b>
    <p></p>
</div>

<!--提示框-->
<div class="prompt" id="promptTip">
    <div><b>提示！</b>
        <span class="pull-right glyphicon glyphicon-remove"></span>
    </div>
    <p>请选择要编辑的行。</p>
</div>

<!--警示框-->
<div class="promptError" id="promptErrorTip">
    <div><b>警示！</b>
        <span class="pull-right glyphicon glyphicon-remove"></span>
    </div>
    <p></p>
</div>

<div class="header-box">
    <div class="title">
        幂幂官网后台管理系统(
        <span>首页</span>
        )
    </div>
    <ul class="header-icon">
        <li class="fa fa-user" id="user" title="修改用户密码"></li>
        <li class="fa fa-power-off" id="logoutButton" title="注销"></li>
    </ul>
</div>

<div class="content-box">
    <div class="aside">
        <ul class="content-list">
            <li class="head">
                <div class="bread"><span class="fa fa-list"></span></div>
                <p>展开菜单</p>
            </li>

            <li class="contain-submenu">
                <p>产品管理</p>
                <a href=""><span class="fa fa-cog">&nbsp;</span>产品管理&nbsp;<b class="fa fa-chevron-right"></b></a>
                <ul class="submenu">
                    <li class="title">
                        <a href="/rest/adminstrate/chanpinxinxi">
                            <span class="fa fa-tumblr-square"></span><i>产品信息管理</i>
                        </a>
                        <p>产品信息管理</p>
                    </li>

                    <li class="title">
                        <a href="/rest/adminstrate/chanpinleixing"><span
                                class="fa fa-odnoklassniki-square"></span><i>产品类型管理</i>
                        </a>
                        <p>产品类型管理</p>
                    </li>
                </ul>
            </li>

            <li class="head"><a href="/rest/customer/kehuxinxi"><span class="fa fa-circle"></span>客户信息管理</a>
                <p>客户信息管理</p>
            </li>

            <li class="contain-submenu">
                <p>活动信息管理</p>
                <a href=""> <span class="fa fa-hourglass-half">&nbsp;</span>活动信息管理&nbsp;<b
                        class="fa fa-chevron-right"></b></a>
                <ul class="submenu">
                    <li class="title">
                        <a href="/rest/adminstrate/youhuihuodong"><span class="fa fa-font"></span><i>优惠活动管理</i></a>
                        <p>优惠活动管理</p>
                    </li>

                    <li class="title">
                        <a href="/rest/adminstrate/xinpinfabu"><span
                                class="fa  fa-commenting-o"></span><i>新品发布管理</i></a>
                        <p>新品发布管理</p>
                    </li>
                </ul>
            </li>

            <li class="contain-submenu">
                <p>账户与安全</p>
                <a href=""> <span class="fa fa-unlock">&nbsp;</span>账户与安全&nbsp;<b
                        class="fa fa-chevron-right"></b></a>
                <ul class="submenu">

                        <li class="title">
                            <a href="/rest/speakerCog/gospeakerCog"><span class="fa fa-user"></span><i>用户管理</i></a>
                            <p>用户管理</p>
                        </li>

                        <li class="title">
                            <a href="/rest/speakerCog/gospeakerCog"><span class="fa fa-users"></span><i>角色管理</i></a>
                            <p>角色管理</p>
                        </li>

                        <li class="title">
                            <a href="/rest/speakerCog/gospeakerCog"><span class="fa fa-lock"></span><i>权限管理</i></a>
                            <p>权限管理</p>
                        </li>

                </ul>
            </li>

            <li class="head"><a href="/rest/speakerCog/gospeakerCog"><span class="fa fa-calendar"></span>日志</a>
                <p>日志</p>
            </li>

        </ul>
        <div class="user-name fa fa-user">&nbsp;&nbsp;&nbsp;<span style="display: none" id="spanId">fuyameng</span>
        </div>
    </div>
    <div class="main-content">
        <iframe src="" frameborder="0" name="myName"></iframe>
    </div>
</div>

</body>
<script src="${pageContext.request.contextPath}/app/qTip2/jquery.qtip.min.js" ></script>
<script>

    $(function () {
        //初始化
        htmlInit.init();
        //页面整体长宽渲染
        htmlRendering.init();
        //显示用户名
        userNameShow.init();
        //主菜单点击切换
        mainMenuClickToggle.init();
        //退出操作
        logout.init();
        //用户修改密码操作
        userModifyPassword.init();
        //下拉子菜单及切换效果
        submenuRendering.init();
        //侧边栏横纵滑动
        menuExpansion.init();
    });

    //页面初始化
    var htmlInit = {
        init: function () {
            htmlInit.ajaxValue();

            //点击提示框的关闭按钮，删除提示框
            $("body").on("click", "span.glyphicon-remove", function () {
                $(this).parents("div.prompt").hide().remove();
                $(this).parents("div.promptError").hide().remove();
            });
        },
        ajaxValue: function () {
            $(".main-content iframe").attr("src", "${pageContext.request.contextPath}/rest/adminstrate/chanpinxinxi");
//            var url = basePath + "/rest/page/iframeScr";
//            $.post(url, function (msg) {
//                if (msg) {
//                    console.log(msg);
//                    console.log(msg.spanHtml);
//                    console.log(msg.iframeSrc);
//                    $(".main-content iframe").attr("src", basePath + msg.iframeSrc);
//                    $(".header-box .title span").html(msg.spanHtml);
//                }
//            });
        }
    };
    //页面整体长宽渲染
    var htmlRendering = {
        init: function () {
            htmlRendering.rendering();
        },
        rendering: function () {
            var height = $(window).height() - $(".header-box").height();
            $(".content-box").css({"height": height + "px"});
            $(".aside").width(56);
            $("body").height($(window).height());
            $(window).resize(function () {
                var height = $(window).height() - $(".header-box").height();
                $("body").height($(window).height());
                $(".content-box").css({"height": height + "px"});
            });
        }
    };
    //显示用户名
    var userNameShow = {
        init: function () {
            userNameShow.nameShow();
        },
        nameShow: function () {
            var url = "${pageContext.request.contextPath}/rest/adminstrate/getAdminName";
            $.post(url, function (msg) {
                if (msg) {
//                    var arr = msg.split(",");
                    $(".user-name span").html(msg);
                }
            });
        }
    };
    //主菜单点击切换
    var mainMenuClickToggle = {
        init: function () {
            mainMenuClickToggle.clickToggle();
        },
        clickToggle: function () {
            var spanHtml = $(".header-box span");
            $(".head a").each(function () {
                $(this).unbind("click").click(function (e) {
                    e.preventDefault();
                    $(".aside").animate({"width": "190px"}, 300);
                    spanHtml.html($(this).siblings("p").html());
                    $(this).parent().siblings().children("a").removeClass("on");
                    $(".submenu>.title>a").removeClass("on");
                    $(".contain-submenu").animate({"margin-bottom": "0px"}, 600);
                    $(".submenu").slideUp();
                    $(this).addClass("on");
                    $(".contain-submenu>a").find("b").attr("class", "fa fa-chevron-right");
                    var subName = $(this).attr("href");
                    $(".main-content iframe").attr("src", "${pageContext.request.contextPath}" + subName);
                    $(".contain-submenu>a").find("b").attr("class", "fa fa-chevron-right");
                })

            });
        }
    };
    //退出操作
    var logout = {
        init: function () {
            logout.logoutFu();
        },
        logoutFu: function () {
            $('#logoutButton').click(function () {
                location.href = "${pageContext.request.contextPath}/rest/adminstrate/login";
            });
        }
    };
    //用户修改密码操作
    var userModifyPassword = {
        init: function () {
            userModifyPassword.modifyPasswordClick();
        },
        modifyPasswordClick: function () {
            $('#user').click(function () {
                location.href = "${pageContext.request.contextPath}/rest/user/passwdUpdate";
            });
        }
    };
    //下拉子菜单及切换效果
    var submenuRendering = {
        init: function () {
            submenuRendering.submenuRendering();
        },
        submenuRendering: function () {
            $(".contain-submenu>a").unbind("click").on("click", function (e) {
                e.preventDefault();
                var marginBottom = $(this).next(".submenu").find("li").length * 40;
                $(".aside").animate({"width": "190px"}, 300);
                $(this).parent().siblings(".contain-submenu").find("b").attr("class", "fa fa-chevron-right");
                if ($(this).parent().css("margin-bottom") == "0px") {
                    $(this).parent().siblings(".contain-submenu").find(".submenu").slideUp();
                    $(this).siblings(".submenu").slideDown();
                    $(this).parent().animate({"margin-bottom": marginBottom + "px"}, 300);
                    $(this).parent().siblings(".contain-submenu").animate({"margin-bottom": "0px"}, 300);
                    $(this).find("b").attr("class", "fa fa-chevron-down");
                } else {
                    $(this).siblings(".submenu").slideUp();
                    $(this).parent().animate({"margin-bottom": "0px"}, 300);
                    $(this).find("b").attr("class", "fa fa-chevron-right");

                }
                //子菜单点击切换
                submenuClickSwitch.init();
            });
        }
    };
    //子菜单点击切换
    var submenuClickSwitch = {
        init: function () {
            submenuClickSwitch.clickSwitch();
        },
        clickSwitch: function () {
            //子菜单点击切换
            var spanHtml = $(".header-box span");
            $(".submenu>.title>a").unbind("click").click(function (e) {
                e.preventDefault();
                $(".aside").animate({"width": "190px"}, 300);
                spanHtml.html($(this).find("i").html());
                $(this).parent().siblings().children("a").removeClass("on");
                $(".head a").removeClass("on");
                $(this).addClass("on");
                var subName = $(this).attr("href");
                $(".main-content iframe").attr("src", "${pageContext.request.contextPath}" + subName);
            });
        }
    };
    //菜单横纵伸缩
    var menuExpansion = {
        init: function () {
            menuExpansion.portraitExpansion();
            menuExpansion.transverseExpansion();
        },
        //菜单纵向伸缩
        portraitExpansion: function () {
            $(".bread").unbind("click").on("click", function () {
                if ($(".aside").width() !== 56) {
                    $(".aside").animate({"width": "56px"}, 300);
                    $(".user-name span").hide();
                } else {
                    $(".aside").animate({"width": "190px"}, 300);
                    $(".user-name span").show();
                }
            });
        },
        //菜单横向伸缩
        transverseExpansion: function () {
            $(".aside").on("mouseenter", function () {
                $(".aside").stop().animate({"width": "190px"}, 300);
                $(".user-name span").show();
            })
                    .on("mouseleave", function () {
                        $(".aside").stop().animate({"width": "56px"}, 300);
                        $(".user-name span").hide();
                    });
        }
    };
    //按钮增加qtip样式
    var addQtip = {
        init: function () {
            this.addLiQtip();
        },
        addLiQtip: function () {
            $(".header-box li").each(function () {
                var title = $(this).attr("title");
                if (title) {
                    bs.addQtip($(this), title, 'top left', 'yellow');
                }
            });
        }
    };
    //显示模态框
    function showModal(obj) {
        if (obj) {
            $("#" + obj).modal('show');
        }
    }
</script>
</html>