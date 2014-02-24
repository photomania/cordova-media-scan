package org.apache.cordova.media_scan;

import android.content.Context;

public class Scanner {
    private Context appContext;

    public Scanner(Context appContext) {
        this.appContext = appContext;
    }

    public void scanItem(String path) {
        ItemScanner scanner = new ItemScanner(this.appContext);
        scanner.scan(path);

        return;
    }
}
