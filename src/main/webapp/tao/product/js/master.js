s = document.getElementsByTagName("script");
s = s[s.length-1].src;
s = s.substring(0, s.lastIndexOf("/") + 1);

function require(script) {
    $.ajax({
        url: s + script,
        dataType: "script",
        async: false,   
        error: function (jqXHR, textStatus, errorThrown) {
            throw new Error("Could not load script " + script + " | " + errorThrown);
        }
    });
}

var pathname = window.location.host;
var lang = getLang(window.location.href);
var isiPad = navigator.userAgent.match(/iPad/i) != null;
var isiPhone = navigator.userAgent.match(/iPhone/i) != null;
var iOS = false;

if(isiPad == true || isiPhone == true){
	iOS = true;
}

function getLang(url) {
    var splits = url.replace('http://', '').split('/');
    return splits[1];
}

// require("libs/modernizr-2.8.1.min.js");
//require("plugins/jquery.history.js");  
// require("plugins/ajaxEntry.js");
// require("plugins/form.js");
// require("plugins/slider.js");
// require("plugins/fancyFormElements.js");
// require("plugins/jquery.appear.js");
// require("plugins/movies.js");
// require("plugins/pinimages.min.js");



//require("plugins/navigation.js"); 

$(window).load(function(){
    
	/* SHOW INFO ON LOGOS */
	$("a.showInfo").click(function(){
		$(this).parent().toggleClass("active");
	});	
	
	$(".input").click(function(){
		$(this).addClass("active");
		$(this).find("input").focus();
	});	
	
	$("input").focus(function(){
		$(this).parent().find("i").hide();
	});
	$("input").blur(function(){
		if($(this).val() == ""){
			$(this).parent().find("i").show();
			$(this).parent().removeClass("active");
		}
	});
	
	$(".textarea").click(function(){
		$(this).addClass("active");
		$(this).find("textarea").focus();
	});	
	
	$("textarea").focus(function(){
		$(this).parent().find("i").hide();
	});
	
	$("textarea").blur(function(){
		if($(this).val() == ""){
			$(this).parent().find("i").show();
			$(this).parent().removeClass("active");
		}
	});
	
	
	$("#burger").click(function(){
		$("nav").toggleClass("show");
	});	
});

function switchLogos(){
	$(".logo").toggleClass("showLogo2");
}

function shareOnFacebook(u){	 /* CREATE POP-UP */
    w = window.open(u, "Share", "location=0,status=0,scrollbars=0, width=575,height=380");    
}
function shareOnTwitter(u){	 /* CREATE POP-UP */
	console.log(u);
    w = window.open(u, "Share", "location=0,status=0,scrollbars=0, width=575,height=250");    
}

foresight = {
    options: {
        testConn: true,
        minKbpsForHighBandwidth: 300,
       	speedTestUri: "http://" + window.location.hostname + "/inc/js/plugins/speed-test/50K.jpg"
    }
};

/* require("plugins/foresight-debugger.js"); */
// require("plugins/foresight.min.js");
