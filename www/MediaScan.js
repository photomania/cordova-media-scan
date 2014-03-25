var argscheck = require('cordova/argscheck'),
    exec = require('cordova/exec');

var mediaScanExport = {};

mediaScanExport.scan = function(successCallback, errorCallback, options) {
    options = options || {};

    var args = [options.path];

    exec(successCallback, errorCallback, "MediaScan", "file", args);
};

module.exports = mediaScanExport;
