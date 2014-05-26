var keepScreenOn = {
    CancelKeepScreenOn: function () {
        cordova.exec(null, null, "KeepScreenOn", "CancelKeepScreenOn", [""]);
    },
    
    KeepScreenOn: function () {
        cordova.exec(null, this.reportError, "KeepScreenOn", "KeepScreenOn", [""]);
    },  
};

module.exports = keepScreenOn;
