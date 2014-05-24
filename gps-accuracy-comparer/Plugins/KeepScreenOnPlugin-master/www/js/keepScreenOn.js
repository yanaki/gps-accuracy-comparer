var keepScreenOn = {
    CancelKeepScreenOn: function () {
        cordova.exec(null, null, "KeepScreenOn", "CancelKeepScreenOn", [""]);
    },
    
    KeepScreenOn: function () {
        cordova.exec(null, this.reportError, "KeepScreenOn", "KeepScreenOn", [""]);
    },
    echo: function (str, callback) {
        cordova.exec(function(str) {
            alert("success" + str);
        }, this.reportError , "KeepScreenOn", "AlertIn", [str]);
    },
    reportError: function() {
        alert("Error " + arguments[0]);
    }
    
};

module.exports = keepScreenOn;
