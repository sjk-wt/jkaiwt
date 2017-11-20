<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assert/css/font.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assert/css/bootstrap.min.css"/>
    <link href="${pageContext.request.contextPath}/app/lib/jqwidgets-ver4.0.0/jqwidgets/styles/jqx.base.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/app/lib/jqwidgets-ver4.0.0/jqwidgets/styles/jqx.custom.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assert/css/index.css"/>
    <link href="${pageContext.request.contextPath}/app/qTip2/jquery.qtip.min.css" rel="stylesheet" type="text/css"/>
    <style>
        body {
            min-width: 1200px;
        }

        .query-list .edit {
            width: 140px;
            top: -46px;
            left: 170px;
        }

        .query-list .edit li {
            margin-left: 10px;
        }

        .query-list .edit li:last-child, .query-list .edit li:nth-child(4) {
            padding: 6px;
        }

        .query-list .query > li input, select {
            width: 100px;
            height: 24px;
            line-height: 24px;
            color: #000;
        }

        .time-box label {
            float: left;
            font-weight: normal;
            position: relative;
            top: 5px;
        }

        .time-box div {
            float: left;
        }

        .time-box div input {
            top: -3px !important;
        }
        .dot{
            display:inline-block;
            width:15px;
            height:15px;
            border-radius:50%;
        }

        .red{
            background:red;
        }

        .green{
            background:green;
        }
        .redRequired {
            color: red;
        }
    </style>
</head>
<body>
<!--提示框-->
<div id="prompt">
    <b>提示！</b>
    <p>请选择要编辑的行。</p>
</div>

<div class="modal fade" id="languagedeleteWindow" tabindex="-1" role="dialog"
     aria-labelledby="languagedeleteWindowLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="languagedeleteWindowLabel">删除客户信息</h4>
            </div>
            <div class="modal-body">
                <div style="max-width: 100%;" align="center">
                    <span class="glyphicon glyphicon-question-sign"></span>&nbsp;确定要删除该客户信息吗？
                </div>
            </div>
            <div class="modal-footer">
                <div align="center">
                    <button id="languageture" type="button" class="btn btn-primary">确定</button>
                    <button class="btn btn-default" type="button" data-dismiss="modal">取消</button>
                </div>
            </div>
        </div>
    </div>
</div>
<!--删除对话框-->

<div class="hidden">
    <div class="query-list">
        <ul class="edit">

            <li class="fa fa-close" id="deleteBut" title="删除语种信息"></li>

            <li class="fa fa-refresh" title="刷新"></li>

        </ul>
        <ul class="query">
            <li>语种名称：
                <input type="text" placeholder="语种名称" id="lanSearch"/>
            </li>
            <li>
                <span class="select-position">支持：</span>
                <section class="main" style=" margin-left: 66px;">
                    <div class="wrapper-demo">
                        <div id="kwSeach"></div>
                    </div>
                </section>
            </li>
            <li>
                <span class="select-position">有效性：</span>
                <section class="main" style="margin-left:66px;">
                    <div class="wrapper-demo">
                        <div id="systemsupport"></div>
                    </div>
                </section>
            </li>
            <li class="time-box">
                <label>创建时间： </label>
                <div id="beginTime"></div>
                <label>-</label>
                <div id="endTime"></div>
            </li>
            <li>
                <button class="glyphicon glyphicon-search" id="engSearch" title="查询"></button>
            </li>
        </ul>
        <ul class="last">
            <li>
                <button title="分页切换" id="pageModeBtn" class="btn glyphicon glyphicon-resize-full"
                        onclick="bs.tooglePageMode('.table-box');"></button>
            </li>
        </ul>
    </div>
</div>
<div class="main-table">
    <div class="table-box" id="table-box"></div>
</div>

<script src="${pageContext.request.contextPath}/assert/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/assert/js/ajaxfileupload.js"></script>
<script src="${pageContext.request.contextPath}/assert/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/assert/js/changeTime.js"></script>
<script src="${pageContext.request.contextPath}/app/lib/jqwidgets-ver4.0.0/jqwidgets/jqx-all.js"></script>
<script src="${pageContext.request.contextPath}/app/lib/jqwidgets-ver4.0.0/jqwidgets/localization.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/app/lib/jqwidgets-ver4.0.0/jqwidgets/globalization/globalize.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/app/lib/jqwidgets-ver4.0.0/jqwidgets/globalization/globalize.culture.zh-CN.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/app/js/base.js"></script>
<script src="${pageContext.request.contextPath}/app/qTip2/jquery.qtip.min.js"></script>
<script src="${pageContext.request.contextPath}/assert/js/jquery-ui.min.js"></script><!--用户拖动元素，链接：http://api.jqueryui.com/draggable/#method-disable/-->
<script>

    var mytable = {

        validateParam: null,

        queryParam: null,

        initTable: function () {
            //渲染表格
            var url = "${pageContext.request.contextPath}/rest/customer/customerSearch";
            var source = {
                dataType: "json",
                dataFields: [
                    {name: 'id'},
                    {name: 'name'},
                    {name: 'phone'},
                    {name: 'wx'},
                    {name: 'qq'},
                    {name: 'email'},
                    {name: 'remak'},
                    {name: 'instertime', type: 'number'}
                ],
                root: "content",
                url: url
            };
            var dataAdapter = new $.jqx.dataAdapter(source, {
                formatData: function (data) {
                    var param = {
                        cusname: $("#lanSearch").val(),
                        beginTime: $("#beginTime").val(),
                        endTime: $("#endTime").val(),
                        supportkeyword: $("#kwSeach").val(),
                        systemsupport: $("#systemsupport").val()
                    };
                    $.extend(data, param);
                    mytable.queryParam = data;
                    return data;
                },
                downloadComplete: function (data, status, xhr) {
                    source.totalRecords = data.page.totalCount;
                }
            });
            $("#table-box").jqxDataTable({
                width: "100%",
                height: "100%",
                pageable: true,
                pageSize: 20,
                pagerMode: "advanced",
                pagerButtonsCount: 5,
                pageSizeOptions: ["20", "40", "60", "80", "100"],
                source: dataAdapter,
                showToolbar: true,
                renderToolbar: function (toolbar) {
                    var toolBarAppendItems = $('.query-list');
                    toolbar.append(toolBarAppendItems);
                },
                columns: [
                    {text: '序列号', datafield: 'id', width: "auto"},
                    {text: '客户名称', datafield: 'name', width: "auto"},
                    {text: '客户电话', datafield: 'phone', width: "auto"},
                    {text: '客户微信', datafield: 'wx', width: "auto"},
                    {text: '客户QQ', datafield: 'qq', width: "auto"},
                    {text: '客户邮箱', datafield: 'email', width: "auto"},
                    {text: '客户留言', datafield: 'remak', width: "auto"},
                    {
                        text: '创建时间', dataField: 'instertime', width: 150,
                        cellsRenderer: function (row, column, value, rowData) {
                            if (value == null || value == "") {
                                return "";
                            } else {
                                return dateFormatUtil(value);
                            }
                        }
                    }
                ],
                localization: Local.getLocalization()
                , rendered: function () {
                    //找到设置表格行数那个下拉框，使下拉框的宽度自增20
                    var drop = $("#dropdownlistContentgridpagerlistbottom" + "table-box");
                    drop.width(drop.width() + 20);
                }
            });
            $("#table-box").find("div").css("word-wrap", "break-word");//表格中的字段长度过长时自动换行显示
        },

        refresh: function () {
            $("#table-box").jqxDataTable("updateBoundData");
        }

    };

    var lanDel = {

        init: function () {

            this.initVaidator();

            this.initDel();

        },

        initVaidator: function () {

            $('#deleteBut').unbind().on("click", function () {
                var selection = $("#table-box").jqxDataTable('getSelection');
                if (selection.length === 0) {
                    parent.tip.showRightTop("请选择要删除的记录！", 'error');
                    return false;
                } else {
                    bs.loadFormData($('#languagedeleteWindow'));
                    $('#languagedeleteWindow').modal('show');
                }
            });

        },

        initDel: function () {

            $('#languageture').unbind().on("click", function () {
                var selection = $("#table-box").jqxDataTable('getSelection');
                var ids;
                for (var i = 0; i < selection.length; i++) {
                    if (i === 0) {
                        ids = selection[i].id;
                    } else {
                        ids = ids + ',' + selection[i].id;
                    }
                }
                var url = basePath + "rest/customer/delete";
                var data = {
                    id : ids
                };
                $.post(url, data, function (msg) {
                    $('#languagedeleteWindow').modal('hide');
                    mytable.refresh();
                });
            });

        }

    };

    var addQtip = {
        init:function () {
            this.addLiQtip();
            this.addBtnQtip();
        },
        addLiQtip:function () {
            $(".query-list li").each(function () {
                var title = $(this).attr("title");
                if (title) {
                    bs.addQtip($(this), title, 'top left', 'yellow');
                }
            });
        },
        addBtnQtip:function () {
            $(".query-list button").each(function () {
                var title = $(this).attr("title");
                if (title) {
                    bs.addQtip($(this), title, 'top right', 'yellow');
                }
            });
        }
    };

    var draggables = {
        init:function () {
            draggable($('#languagedeleteWindow'));
        }
    };

    $(function () {
        //初始化
        $(".main-table").height($(window).height() - 20);
        $(window).resize(function () {
            $(".main-table").height($(window).height() - 20);
        });
        mytable.initTable();
        lanDel.init();
        addQtip.init();
        draggables.init();

        //刷新按钮点击事件
        $(".fa-refresh, #engSearch").click(function () {
            mytable.refresh();
        });

        //分页切换按钮图标切换
        $('#pageModeBtn').click(function () {
            var classType = $(this).attr("class");
            if (classType === "btn glyphicon glyphicon-resize-full") {
                $(this).attr("class", "btn glyphicon glyphicon-resize-small");
            } else {
                $(this).attr("class", "btn glyphicon glyphicon-resize-full");
            }
        });

        //input边框阴影样式
        $("input").on("focus", function () {
            $(this).css({"-webkit-box-shadow": "0 0 5px #006633"});
        }).on("blur", function () {
            $(this).css({"-webkit-box-shadow": "0 0 5px #fff"});
        });
        //关键词支持
        var kwSource = [
            {name: "全部", value: ""},
            {name: "支持", value: "1"},
            {name: "不支持", value: "0"}
        ];
        $("#kwSeach").jqxDropDownList({
            source: kwSource,
            selectedIndex: 0,
            width: '80',
            height: '22',
            autoDropDownHeight: true,
            displayMember: "name",
            valueMember: "value"
        });
        //有效性
        var systemsupportSource = [
            {name: "全部", value: ""},
            {name: "无效", value: "0"},
            {name: "有效", value: "1"}
        ];
        $("#systemsupport").jqxDropDownList({
            source: systemsupportSource,
            selectedIndex: 0,
            width: '80',
            height: '22',
            autoDropDownHeight: true,
            displayMember: "name",
            valueMember: "value"
        });
        //日历
        $("#beginTime").jqxDateTimeInput({
            formatString: "yyyy-MM-dd",
            value: null,
            showTimeButton: false,
            culture: "zh-CN",
            dayNameFormat: "shortest",
            readonly: true,
            showFooter: true,
            clearString: "清空",
            todayString: "今天",
            width: '100px',
            height: '22px'
        }).on('valueChanged', function (event) {
            var jsDate = event.args.date;
            if (jsDate)
                $("#endTime").jqxDateTimeInput({min: jsDate});
            else
                $("#endTime").jqxDateTimeInput({min: "1978/08/01"});
        });

        $("#endTime").jqxDateTimeInput({
            formatString: "yyyy-MM-dd",
            value: null,
            showTimeButton: false,
            culture: "zh-CN",
            dayNameFormat: "shortest",
            readonly: true,
            showFooter: true,
            clearString: "清空",
            todayString: "今天",
            width: '100px',
            height: '22px'
        }).on('valueChanged', function (event) {
            var jsDate = event.args.date;
            if (jsDate)
                $("#beginTime").jqxDateTimeInput({max: jsDate});
            else
                $("#beginTime").jqxDateTimeInput({max: "2320/12/31"});
        });
    });

    function draggable(obj) {
        $(obj).draggable();
    }

</script>
</body>
</html>