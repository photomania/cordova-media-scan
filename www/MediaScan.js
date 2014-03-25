var argscheck = require('cordova/argscheck'),
    exec = require('cordova/exec');

var mediaScanExport = {};

mediaScanExport.scan = function(successCallback, errorCallback, options) {
    options = options || {};

    var pathToScan = options.path;

    if (device.platform === "Android") {
        pathToScan = pathToScan.replace('file://', '');
    } else if (device.platform === "iOS") {
        pathToScan = encodeURI(pathToScan.replace('file://localhost', 'file://'));
    }

    var args = [pathToScan];

    exec(successCallback, errorCallback, "MediaScan", "file", args);
};

module.exports = mediaScanExport;
