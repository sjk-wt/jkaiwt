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

<!--模态框-->
<div class="modal fade" id="languageAddWindow" tabindex="-1" role="dialog"
     aria-labelledby="languageAddWindowLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close"
                        data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="languageAddWindowLabel">
                    新增语种信息
                </h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="lanAddForm">
                    <div class="form-group">
                        <label class="col-sm-3 control-label"></label>
                        <div class="col-sm-8 redTip">
                            有<span style="color: red">*</span>标记的是必填项
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="engNumber" class="col-sm-3 control-label">语种编号</label>
                        <div class="col-sm-8">
                            <input class="form-control" id="engNumber" name='engNumber' type="text">
                        </div>
                        <div class="redRequired">*</div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">语种名称</label>
                        <div class="col-sm-8">
                            <input class="form-control" id='engName' name='engName' type="text">
                        </div>
                        <div class="redRequired">*</div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">支持关键词</label>
                        <div class="col-sm-8">
                            <input type="radio" name='supportKeyword' value="0" checked=true> 不支持
                            <input type="radio" name='supportKeyword' value="1"> 支持
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="serialNumberAdd" class="col-sm-3 control-label">序列号</label>
                        <div class="col-sm-8">
                            <input type="email" class="form-control" id="serialNumberAdd" name='serialNumber'>
                        </div>
                        <div class="redRequired">*</div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">有效性</label>
                        <div class="col-sm-8">
                            <input type="radio" name='systemSupport' value="1"> 有效
                            <input type="radio" name='systemSupport' value="0" checked=true> 无效
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">备注</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" name='remark'>
                        </div>
                    </div>

                    <div class="form-group">
                        <div align="center">
                            <button id="languageAddFormSubmitBtn" type="button" class="btn btn-primary">保存</button>
                            <button class="btn btn-default" type="button" data-dismiss="modal">取消</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<!--添加对话框-->

<div class="modal fade" id="languageEditWindow" tabindex="-1" role="dialog"
     aria-labelledby="languageEditWindowLabe" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close"
                        data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="languageEditWindowLabe">
                    编辑语种信息
                </h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" role="form" id="lanEditForm">
                    <div class="form-group">
                        <label class="col-sm-3 control-label"></label>
                        <div class="col-sm-8 redTip">
                            有<span style="color: red">*</span>标记的是必填项
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="engNumber_e" class="col-sm-3 control-label">语种编号</label>
                        <div class="col-sm-8">
                            <input class="form-control" name='engnumber' id='engNumber_e' type="text">
                        </div>
                        <div class="redRequired">*</div>
                    </div>
                    <div class="form-group">
                        <label for="engName_e" class="col-sm-3 control-label">语种名称</label>
                        <div class="col-sm-8">
                            <input class="form-control" name='engname' id='engName_e' type="text">
                        </div>
                        <div class="redRequired">*</div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">支持关键词</label>
                        <div class="col-sm-8">
                            <input type="radio" name='supportkeyword' value="0" checked=true> 不支持
                            <input type="radio" name='supportkeyword' value="1"> 支持
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">序列号</label>
                        <div class="col-sm-8">
                            <input type="email" class="form-control" id="serialNumber_e" name='serialnumber'>
                        </div>
                        <div class="redRequired">*</div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">有效性</label>
                        <div class="col-sm-8">
                            <input type="radio" name='systemsupport' value="1"> 有效
                            <input type="radio" name='systemsupport' value="0" checked=true> 无效
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">备注</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" name='remark'>
                        </div>
                    </div>
                    <div class="form-group" style="display: none">
                        <label class="col-sm-3 control-label">ID</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" name='id' id="idEdit" placeholder="id">
                        </div>

                    </div>
                    <div class="form-group">
                        <div align="center">
                            <button id="languageEditFormSubmitBtn" type="button" class="btn btn-primary">修改</button>
                            <button class="btn btn-default" type="button" data-dismiss="modal">取消</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<!--修改对话框-->

<div class="modal fade" id="languagedeleteWindow" tabindex="-1" role="dialog"
     aria-labelledby="languagedeleteWindowLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="languagedeleteWindowLabel">删除语种信息</h4>
            </div>
            <div class="modal-body">
                <div style="max-width: 100%;" align="center">
                    <span class="glyphicon glyphicon-question-sign"></span>&nbsp;确定要删除该语种信息吗？
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

            <li class="fa fa-plus" data-toggle="modal" data-target="#languageAddWindow" title="添加语种信息"></li>

            <li class="fa fa-pencil" id="editBut" title="修改语种信息"></li>

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
            var url = "${pageContext.request.contextPath}/rest/lanCog/lanSearch";
            var source = {
                dataType: "json",
                dataFields: [
                    {name: 'id'},
                    {name: 'engname'},
                    {name: 'engnumber'},
                    {name: 'remark'},
                    {name: 'serialnumber'},
                    {name: 'supportkeyword'},
                    {name: 'systemsupport'},
                    {name: 'createtime', type: 'number'},
                    {name: 'modifytime', type: 'number'}
                ],
                root: "content",
                url: url
            };
            var dataAdapter = new $.jqx.dataAdapter(source, {
                formatData: function (data) {
                    var param = {
                        engname: $("#lanSearch").val(),
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
                    {text: '序列号', datafield: 'serialnumber', width: "auto"},
                    {text: '语种编号', datafield: 'engnumber', width: "auto"},
                    {text: '语种名称', datafield: 'engname', width: "auto"},
                    {
                        text: '支持关键词', datafield: 'supportkeyword', width: "auto",
                        cellsRenderer: function (row, column, value, rowData) {
                            if (value == "0") {
                                return "不支持";
                            } else {
                                return "支持";
                            }
                        }
                    }, {
                        text: '有效性', datafield: 'systemsupport', width: "auto",
                        cellsRenderer: function (row, column, value, rowData) {
                            if (value == "1") {
                                return "<span class='dot green' title='有效'></span>";
                            } else {
                                return "<span class='dot red' title='无效'></span>";
                            }
                        }
                    },
                    {text: '备注', datafield: 'remark', width: "auto"},
                    {
                        text: '创建时间', dataField: 'createtime', width: 150,
                        cellsRenderer: function (row, column, value, rowData) {
                            if (value == null || value == "") {
                                return "";
                            } else {
                                return dateFormatUtil(value);
                            }
                        }
                    },
                    {text: '唯一标识', datafield: 'id', width: "auto", hidden: true},
                    {text: '修改时间', dataField: 'modifytime', width: 'auto', hidden: true}
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

    var lanAdd = {

        init: function () {

            this.initKeyValidator();

            this.initSave();

            $("#languageAddWindow").on('hidden.bs.modal', function (e) {
                lanAdd.hideHints();
            });

        },// end spAdd.init

        //隐藏form的警告提示
        hideHints: function () {
            var form = $("#lanAddForm");
            form.jqxValidator('hideHint', "#engNumber");
            form.jqxValidator('hideHint', "#engName");
            form.jqxValidator('hideHint', "#serialNumberAdd");
        },// end keyAdd.hideHints

        initKeyValidator: function () {

            $("#lanAddForm").jqxValidator({
                rules: [
                    {
                        input: '#engNumber',
                        message: '语种编号不能为空!',
                        action: 'keyup, blur',
                        rule: function (input, commit) {
                            return input.val() != "";
                        }
                    }, {
                        input: '#engNumber',
                        message: '语种编号只能是英文!',
                        action: 'keyup, blur',
                        rule: function (input, commit) {
                            var validate = false;
                            var rep3 = /^[a-zA-Z]+$/;//仅为英文
                            var accoutAdd = input.val().trim();
                            if (rep3.test(accoutAdd)) {
                                validate = true;
                            }
                            return validate;
                        }
                    }, {
                        input: '#engName',
                        message: '语种名称不能为空!',
                        action: 'keyup, blur',
                        rule: function (input, commit) {
                            return input.val() != "";
                        }
                    }, {
                        input: '#engNumber',
                        message: "编号已经存在!",
                        action: 'blur',
                        rule: function (input, commit) {
                            var validate = true;
                            var url = "${pageContext.request.contextPath}/rest/lanCog/lanUniqueness";
                            var data = {
                                id: '',
                                engNumber: input.val()
                            };
                            $.get(url, data, function (result) {
                                if (result.success) {
                                    validate = false;
                                    parent.tip.showRightTop("编号已存在！", 'error');
                                    input.focus();
                                }
                            });
                            return validate;
                        }
                    }, {
                        input: '#serialNumberAdd',
                        message: '序列号只能是正整数!',
                        action: 'keyup, blur',
                        rule: function (input, commit) {
                            var validate = false;
                            var rep3 = /^[1-9]\d*$/;//仅为数字
                            var accoutAdd = input.val().trim();
                            if (rep3.test(accoutAdd)) {
                                validate = true;
                            }
                            return validate;
                        }
                    }
                ],
                hintType: "label"
            });
        },

        initSave: function () {

            $("#languageAddFormSubmitBtn").unbind().on("click", function () {
                $("#lanAddForm").jqxValidator("validate");
            });

            $("#lanAddForm").on("validationSuccess", function (event) {
                var data = $('#lanAddForm').serialize();
                var url = "${pageContext.request.contextPath}/rest/lanCog/save";
                $.post(url, data, function (result) {
                    $("#languageAddWindow").modal('hide');
                    $("#lanAddForm")[0].reset();
                    if (result.success) {
                        parent.tip.showRightTop("添加成功！");
                        mytable.refresh();
                    } else {
                        parent.tip.showRightTop("添加失败！", 'error');
                    }
                });
            });
        }
    };

    var lanEdit = {

        init: function () {

            this.initKeyValidator();

            this.initSave();

        },// end spAdd.init

        initKeyValidator: function () {

            $("#lanEditForm").jqxValidator({
                rules: [
                    {
                        input: '#engNumber_e',
                        message: '语种编号不能为空!',
                        action: 'keyup, blur',
                        rule: function (input, commit) {
                            return input.val() != "";
                        }
                    }, {
                        input: '#engNumber_e',
                        message: '语种编号只能是英文!',
                        action: 'keyup, blur',
                        rule: function (input, commit) {
                            var validate = false;
                            var rep3 = /^[a-zA-Z]+$/;//仅为英文
                            var accoutAdd = input.val().trim();
                            if (rep3.test(accoutAdd)) {
                                validate = true;
                            }
                            return validate;
                        }
                    }, {
                        input: '#engName_e',
                        message: '语种名称不能为空!',
                        action: 'keyup, blur',
                        rule: function (input, commit) {
                            return input.val() != "";
                        }
                    }, {
                        input: '#engNumber_e',
                        message: "编号已经存在!",
                        action: 'blur',
                        rule: function (input, commit) {
                            var validate = true;
                            var url = "${pageContext.request.contextPath}/rest/lanCog/lanUniqueness";
                            var data = {
                                id: $('#idEdit').val(),
                                engNumber: input.val()
                            };
                            $.get(url, data, function (result) {
                                if (result.success) {
                                    validate = false;
                                    parent.tip.showRightTop("编号已存在！", 'error');
                                    input.focus();
                                }
                            });
                            return validate;
                        }
                    }, {
                        input: '#serialNumber_e',
                        message: '序列号只能是正整数!',
                        action: 'keyup, blur',
                        rule: function (input, commit) {
                            var validate = false;
                            var rep3 = /^[1-9]\d*$/;//仅为数字
                            var accoutAdd = input.val().trim();
                            if (rep3.test(accoutAdd)) {
                                validate = true;
                            }
                            return validate;
                        }
                    }
                ],
                hintType: "label"
            });
        },

        initSave: function () {

            $('#editBut').unbind().on("click", function () {
                var selection = $("#table-box").jqxDataTable('getSelection');
                if (selection.length === 0) {
                    parent.tip.showRightTop("请勾选要修改的行！", 'error');
                    return;
                } else if (selection.length > 1) {
                    parent.tip.showRightTop("请选择一行进行修改！", 'error');
                    return;
                } else {
                    var rowData = selection[0];
                    bs.loadFormData($('#lanEditForm'), rowData);
                    $('#languageEditWindow').modal('show');
                }
            });

            $("#languageEditFormSubmitBtn").unbind().on("click", function () {
                console.log(0);
                $("#lanEditForm").jqxValidator("validate");
            });

            $("#lanEditForm").on("validationSuccess", function (event) {
                var data = $('#lanEditForm').serialize();
                var url = basePath + "${pageContext.request.contextPath}rest/lanCog/update";
                $.post(url, data, function (result) {
                    $("#languageEditWindow").modal('hide');
                    if (result.success) {
                        parent.tip.showRightTop("修改成功！");
                        mytable.refresh();
                    } else {
                        parent.tip.showRightTop("修改失败！", 'error');
                    }
                });
            });

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
                var url = basePath + "rest/lanCog/delete";
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
            draggable($('#languageAddWindow'));
            draggable($('#languageEditWindow'));
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
        lanAdd.init();
        lanEdit.init();
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