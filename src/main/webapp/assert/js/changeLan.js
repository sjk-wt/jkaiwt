/**
 * Created by dell on 2017/7/5.
 */
var Uighur={
    chars:{
        old:["ا","ە","ې","ى","و","ۇ","ۆ","ۈ","ب","پ","ت","ن","ل","م","ك","ق","ف","غ","ھ","ج","خ","ۋ","ي","ز","ژ","د","ر","ڭ","س","ش","چ","گ","ئ"],
        new:["a","E","e","i","o","u","O","v","b","p","t","n","l","m","k","K","f","G","H","j","h","w","y","z","Z","d","r","N","s","x","q","g",""],
        latin:["a","a6","e","i","o","u","o6","v","b","p","t","n","l","m","k","q","f","g6","h","j","x","w","y","z","z6","d","r","n6","s","s6","c","g",""]
    },
    regs:{/*
     oldReg:/(ا|ە|ې|ى|و|ۇ|ۆ|ۈ|ب|پ|ت|ن|ل|م|ك|ق|ف|غ|ھ|ج|خ|ۋ|ي|ز|ژ|د|ر|ڭ|س|ش|چ|گ|ئ)/g,
     newReg:/(a|E|e|i|o|u|O|v|b|p|t|n|l|m|k|K|f|G|H|j|h|w|y|z|Z|d|r|N|s|x|q|g)/g,
     latinReg:/(o6|a6|g6|z6|n6|s6|f|v|b|p|t|n|l|m|k|q|e|i|h|j|x|w|y|z|o|d|r|u|s|a|c|g)/g
     */},
    change:function(str,from,to){
        return str.replace(Uighur.regs[from],function(char){
            var i = Uighur.chars[from].indexOf(char);
            return i<0?char:Uighur.chars[to][i];
        });
    }
};
(function(){
    for(var key in Uighur.chars){
        var chars_ = [];
        var tooLong=0;
        for(var i=0,n=Uighur.chars[key].length;i<n;i++){
            chars_[i]=Uighur.chars[key][i];
            if(chars_[i].length>1)tooLong++;
        }
        if(tooLong>0)chars_.sort(function(a,b){return b.length-a.length});
        Uighur.regs[key]=new RegExp(chars_.join("|").replace(/^\||\|$/,""),"g");
    }
})();
