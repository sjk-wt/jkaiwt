/**
 * Created by BanAiqin on 2016/11/10.
 */

//公共弹出提示框
var tip = {

    //右上方提示提示信息
    showRightTop: function (msg, error) {
        var prom = $("#promptTip").clone();
        if (error == "error" || error == false) {
            prom = $("#promptErrorTip").clone();
        }
        var id = prom.attr("id");
        var time = new Date().getTime();
        prom.attr("id", id + time);
        prom.appendTo($("#body"));
        prom.find("p").text(msg);
        prom.show().css({
            "top": 10,
            "right": 100
        }).stop().animate({"right": 200}, 400).animate({"right": 10}, 400).fadeOut(8000, function () {
            $(this).remove();
        });
        prom.hover(function () {
            // 鼠标悬停时停止动画，透明度恢复为1，即完全不透明
            prom.css("opacity", "1").stop();
        }, function () {
            // 鼠标离开时重新开始动画，并逐渐消失
            prom.animate({"right": 10}, 400).fadeOut(8000, function () {
                $(this).remove();
            });
        });

    }

    ,//右下方提示信息
    showRightBottom: function (msg, error) {
        var prom = $("#promptTip").clone();
        if (error == "error" || error == false) {
            prom = $(".promptError").clone();
        }
        var id = prom.attr("id");
        var time = new Date().getTime();
        prom.attr("id", id + time);
        prom.appendTo($("#body"));
        var h = $(window).height() - prom.height();
        prom.find("p").text(msg);
        prom.show().css({
            "top": h + 80,
            "right": 10
        }).stop().animate({"top": h - 65}, 400).animate({"top": h - 35}, 700).fadeOut(8000, function () {
            $(this).remove();
        });
        prom.hover(function () {
            // 鼠标悬停时停止动画，透明度恢复为1，即完全不透明
            prom.css("opacity", "1").stop();
        }, function () {
            // 鼠标离开时重新开始动画，并逐渐消失
            prom.animate({"top": h - 35}, 400).fadeOut(8000, function () {
                $(this).remove();
            });
        })
    }

};

//公共基础类
var bs = {
    /**
     * 根据dataJson填充表单对象
     * @param {Jquery Form Object} formObject 需要设置属性的表单jquery对象
     * @param {Json} dataJson
     */
    loadFormData: function (formObject, dataJson) {
        for (var index in dataJson) {
            var elm = formObject.find("[name='" + index + "']");
            /**
             * radio 赋值
             */
            if ("radio" == elm.attr("type")) {
                for (var i = 0; i < elm.length; i++) {
                    var radio = elm[i];
                    if (radio.value == dataJson[index]) {
                        radio.checked = true;
                    }
                }
            } else {
                if (elm.hasClass('select')) {
                    elm.setValue(dataJson[index]);
                } else {
                    elm.val(dataJson[index]);
                }
            }
        }
    }//end bs.loadFormData

    //给页面元素添加提示tip
    , addQtip: function (obj, title, position, color) { //公共方法：给元素添加qtip
        if (!color)
            color = 'blue';
        if (!position)
            position = 'top left';
        obj.qtip({
            content: title,
            fixed: true,
            theme: "custom",
            style: {classes: 'qtip-' + color, "font-size": "15px"},
            position: {
                my: position,  // Position my top left...
                at: 'bottom center', // at the bottom right of...
                target: 'mouse',// my target
                adjust: {x: 0, y: 20}
            }

        });
    }//end bs.addQtip

    //功能：将浮点数四舍五入，取小数点后1位
    , toDecimal1: function (x) {
        var f = parseFloat(x);
        if (isNaN(f)) {
            return;
        }
        f = Math.round(x * 10) / 10;
        return f;
    }//end bs.toDecimal1

    //功能：将以s为单位的时间改为mm:ss格式的时间
    , toTimeMin: function (t) {
        t = parseInt(t);
        var m = parseInt(t / 60);
        var s = t % 60;
        return m + ":" + s;
    }//end bs.toTimeMin

    //切换表格的分页模式
    , tooglePageMode: function (obj) {
        var mode = $(obj).jqxDataTable('pagerMode');
        if (mode == 'advanced') {
            $(obj).jqxDataTable({pagerButtonsCount: 10, pagerMode: "default"});
        } else if (mode == 'default') {
            $(obj).jqxDataTable({pagerMode: "advanced"});
        }
    }

};