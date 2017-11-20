/**
 * Created by Banaiqin on 2016/8/10.
 */
var Local = {
    getLocalization: function () {
        var localizationobj = {};
        localizationobj.pagerGoToPageString = "转到:";
        localizationobj.pagerShowRowsString = "每页行数:";
        localizationobj.pagerRangeString = " 共 ";
        localizationobj.pagerPreviousButtonString = "上一页";
        localizationobj.pagerFirstButtonsSring = "第一页";
        localizationobj.pagerNextButtonString = "下一页";
        localizationobj.pagerLastButtonString = "最后页";
        var days = {
            // full day names
            names: ["星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"],
            // abbreviated day names
            namesAbbr: ["周日", "周一", "周二", "周三", "周四", "周五", "周六"],
            // shortest day names
            namesShort: ["日", "一", "二", "三", "四", "五", "六"]
        };
        localizationobj.days = days;
        var months = {
            // full month names (13 months for lunar calendards -- 13th month should be "" if not lunar)
            names: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月", ""],
            // abbreviated month names
            namesAbbr: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月", ""]
        };
        var patterns = {
            d: "dd.MM.yyyy",
            D: "dddd, d. MMMM yyyy",
            t: "HH:mm",
            T: "HH:mm:ss",
            f: "dddd, d. MMMM yyyy HH:mm",
            F: "dddd, d. MMMM yyyy HH:mm:ss",
            M: "dd MMMM",
            Y: "MMMM yyyy"
        };
        localizationobj.patterns = patterns;
        localizationobj.months = months;
        return localizationobj;

    }
};

