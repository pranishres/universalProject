package com.pranish.universalapplication;

import android.os.Bundle;
import android.util.Log;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView myWebView = (WebView) findViewById(R.id.tiledesk);
        myWebView.loadUrl("https://widget.tiledesk.com/v2/index.html?tiledesk_projectid=5d3ea8b7a90df900171bcec0&tiledesk_isopen=true&tiledesk_fullscreenMode=true&tiledesk_hideHeaderCloseButton=true");
//        myWebView.loadUrl("https://stackoverflow.com/questions/12543301/android-webview-can-not-open-a-url-but-browser-of-mobile-can-open-it");

        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
      /*  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WebView.setWebContentsDebuggingEnabled(true);
        }*/

        myWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                Log.d("MyApplication", consoleMessage.message() + " -- From line "
                        + consoleMessage.lineNumber() + " of "
                        + consoleMessage.sourceId());
                return super.onConsoleMessage(consoleMessage);
            }
        });

//        allow to snap photos
        webSettings.setAllowFileAccess(true);

        //allow storage persistance
        webSettings.setDomStorageEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);

    }
}
