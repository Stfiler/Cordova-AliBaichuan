var  cordova = require('cordova');
var AliBaiChuan = {
    initAli: function(info,success,fail){
        cordova.exec(success,fail,'CDVBaiChuan','initAliBaiChuan',[info]);
    },
    jumpShop: function(info,success,fail){
        cordova.exec(success,fail,'CDVBaiChuan','jumpToShop',[info]);
    },
    jumpDetail: function(info,success,fail){
        cordova.exec(success,fail,'CDVBaiChuan','jumpToDetail',[info]);
    },
    jumpURL: function(info,success,fail){
        cordova.exec(success,fail,'CDVBaiChuan','jumpToURL',[info]);
    }

};

module.exports = AliBaiChuan;