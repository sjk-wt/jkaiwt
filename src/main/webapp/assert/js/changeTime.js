/**
 * Created by fu on 2016/11/16.
 */
function dateFormatUtil(longTypeDate) {
    if (!longTypeDate || longTypeDate == null || longTypeDate == "")
        return "";
    var dateTypeDate = "";
    var date = new Date();
    date.setTime(longTypeDate);
    dateTypeDate += date.getFullYear(); //年
    dateTypeDate += "-" + getMonth(date); //月
    dateTypeDate += "-" + getDay(date); //日
    dateTypeDate += " " + getHours(date); //时
    dateTypeDate += ":" + getMinutes(date); //分
    dateTypeDate += ":" + getSeconds(date); //秒
    return dateTypeDate;
}
//返回 01-12 的月份值
function getMonth(date) {
    var month = "";
    month = date.getMonth() + 1; //getMonth()得到的月份是0-11
    if (month < 10) {
        month = "0" + month;
    }
    return month;
}

//返回01-30的日期
function getDay(date) {
    var day = "";
    day = date.getDate();
    if (day < 10) {
        day = "0" + day;
    }
    return day;
}
//    返回小时
function getHours(date) {
    var hours = "";
    hours = date.getHours();
    if (hours < 10) {
        hours = "0" + hours;
    }
    return hours;
}
//    返回分钟
function getMinutes(date) {
    var minutes = "";
    minutes = date.getMinutes();
    if (minutes < 10) {
        minutes = "0" + minutes;
    }
    return minutes;
}
//    返回秒
function getSeconds(date) {
    var seconds = "";
    seconds = date.getSeconds();
    if (seconds < 10) {
        seconds = "0" + seconds;
    }
    return seconds;
}