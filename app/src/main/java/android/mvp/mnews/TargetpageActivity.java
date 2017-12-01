package android.mvp.mnews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class TargetpageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_targetpage);
        WebView myWebView = (WebView) findViewById(R.id.webview);
        myWebView.loadUrl("http://www.google.com");
    }
}
