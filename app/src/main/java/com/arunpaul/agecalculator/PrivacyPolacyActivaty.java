package com.arunpaul.agecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebView;
import android.app.Activity;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebViewClient;
import android.widget.Toast;
import android.annotation.TargetApi;

public class PrivacyPolacyActivaty extends AppCompatActivity {


    @SuppressLint("SetJavaScriptEnabled")
    @Override
        public void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);

        WebView webView = new WebView(this);

            webView.getSettings().setJavaScriptEnabled(true); // enable javascript

            final Activity activity = this;

            webView.setWebViewClient(new WebViewClient() {
                @Override
                public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                    Toast.makeText(activity, description, Toast.LENGTH_SHORT).show();
                }
                @TargetApi(android.os.Build.VERSION_CODES.M)
                @Override
                public void onReceivedError(WebView view, WebResourceRequest req, WebResourceError rerr) {
                    onReceivedError(view, rerr.getErrorCode(), rerr.getDescription().toString(), req.getUrl().toString());
                }
            });

            webView.loadUrl("https://eimsinventory.in/android/application/PrivacyPolicy/AgeCalculator/PrivacyPloicy.html");
            setContentView(webView);

        }

    }