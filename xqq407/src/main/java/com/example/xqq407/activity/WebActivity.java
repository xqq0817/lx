package com.example.xqq407.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.example.xqq407.R;
import com.example.xqq407.view.DataView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WebActivity<T> extends AppCompatActivity implements DataView<T> {

    @BindView(R.id.web)
    WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        //ButterKnife
        ButterKnife.bind(this);
        //
        setWebViewSettings();
        setWebViewClient();
        //百度网址
        web.loadUrl("https://www.baidu.com/");
    }

    private void setWebViewClient() {
        web.setWebViewClient(new WebViewClient(){
            public boolean shouldOverrideUrlLoading(WebView webView,String url){
                webView.loadUrl(url);
                return true;
            };
        });
    }

    private void setWebViewSettings() {
        WebSettings settings = web.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDisplayZoomControls(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);

        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
    }

    @Override
    public void success(T result) {

    }

    @Override
    public void failure(T error) {

    }

}
