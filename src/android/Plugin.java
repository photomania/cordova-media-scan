package org.apache.cordova.media_scan;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONException;
import org.json.JSONArray;

public class Plugin extends CordovaPlugin {

    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        Scanner scanner = new Scanner(this.cordova.getActivity().getApplicationContext());

        // Get relavent arg
        String entry = "";

        try {
            entry = args.getString(0);
        } catch (JSONException e) {
            callbackContext.error("no entry given");

            return false;
        }

        if (action.equals("file")) {
            scanner.scanItem(entry);
        }

        callbackContext.success("done");

        return true;
    }
}
