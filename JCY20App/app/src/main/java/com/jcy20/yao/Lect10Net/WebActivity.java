package com.jcy20.yao.Lect10Net;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.jcy20.yao.R;

public class WebActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String WEB_URL = "webUrl";
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        TextView mTitleTv = findViewById(R.id.tv_title);
        View mBackLayout = findViewById(R.id.layout_back);
        mProgressBar = findViewById(R.id.progress_bar);
        /** WebView 用于显示网页 */
        WebView webView = findViewById(R.id.web_content);

        mTitleTv.setText("姚老师App");
        mBackLayout.setOnClickListener(this);

        /** WebView 相关的设置 */
        String webUrl = getIntent().getStringExtra(WEB_URL);
        WebSettings settings = webView.getSettings();
        // 设置支持javascript
        settings.setJavaScriptEnabled(true);
        MyChromeClient mChromeClient = new MyChromeClient();
        webView.setWebChromeClient(mChromeClient);
        webView.setWebViewClient(mWebClient);

        // 加载指定网页
        webView.loadUrl(webUrl);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.layout_back:{
                /* 关闭当前Activity */
                finish();
            } break;
            default:
                break;
        }
    }
    WebViewClient mWebClient = new WebViewClient(){
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            mProgressBar.setVisibility(View.VISIBLE);
        }
        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            mProgressBar.setVisibility(View.GONE);
        }
    };
    public class MyChromeClient extends WebChromeClient {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
//            super.onProgressChanged(view, newProgress);
            Log.i("MyChromeClient", "--- onProgressChanged: "+ newProgress);
            mProgressBar.setProgress(newProgress);
        }
    }
}
