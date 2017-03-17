var exec = require('cordova/exec');

exports.startService = function(arg0, success, error) {
    exec(success, error, "ServicePlugin", "startService", [arg0]);
};
exports.stopService = function(arg0, success, error) {
    exec(success, error, "ServicePlugin", "stopService", [arg0]);
};