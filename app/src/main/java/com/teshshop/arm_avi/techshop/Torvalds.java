package com.teshshop.arm_avi.techshop;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Torvalds extends AppCompatActivity {

    WebView webViewTorvalds;
    private String linkArmGIT = "https://github.com/avimallik";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_torvalds);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        webViewTorvalds = (WebView) findViewById(R.id.wevViewTorvalds);

        WebSettings webSettings = webViewTorvalds.getSettings();

        webViewTorvalds.setWebViewClient(new Torvalds.WebBasicBrowser());

        //Call all WebPage Rendering Function
        webViewTorvalds.getSettings().setLoadsImagesAutomatically(true);
        webViewTorvalds.getSettings().setJavaScriptEnabled(true);
        webViewTorvalds.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webViewTorvalds.getSettings().setPluginState(WebSettings.PluginState.ON);
        webViewTorvalds.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webViewTorvalds.getSettings().setBuiltInZoomControls(true);
        webViewTorvalds.getSettings().setDisplayZoomControls(false);
        webViewTorvalds.getSettings().setAppCacheEnabled(true);
        webViewTorvalds.setInitialScale(0);
        webViewTorvalds.getSettings().setLoadWithOverviewMode(true);
        webViewTorvalds.getSettings().setUseWideViewPort(true);
        webViewTorvalds.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        webViewTorvalds.getSettings().setDomStorageEnabled(true);

        webViewTorvalds.loadUrl(linkArmGIT);

    }

    private class WebBasicBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            webViewTorvalds.loadUrl(url);
            return true;
        }

        public void onLoadResource(WebView view,String url){

        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
//            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
//            progressBar.setVisibility(View.INVISIBLE);
        }

        @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
//           webViewRender.loadUrl(errorConnection);
        }
    }

}
