package org.apache.cordova.media_scan;

import android.net.Uri;
import android.content.Context;
import android.media.MediaScannerConnection;
import android.media.MediaScannerConnection.MediaScannerConnectionClient;

public class ItemScanner implements MediaScannerConnectionClient {

    private Context appContext;
    private MediaScannerConnection msc;
    private String scanPath;

    public ItemScanner(Context appContext) {
        this.appContext = appContext;
    }

    public void scan(String scanPath) {
        this.scanPath = scanPath;
        this.msc = new MediaScannerConnection(this.appContext, this);
        this.msc.connect();
    }

    public void scan(Uri scanUri) {
        this.scan(scanUri.toString());
    }

    public void onMediaScannerConnected() {
        this.msc.scanFile(this.scanPath, null);
    }

    public void onScanCompleted(String path, Uri uri) {
        this.msc.disconnect();
    }
}
