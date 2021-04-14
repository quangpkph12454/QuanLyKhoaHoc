package com.example.assigment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
         webView= findViewById(R.id.webView);
        Intent i = getIntent();
        String ten = i.getStringExtra("Ten");
        webView.loadUrl(ten);
        webView.setWebViewClient(new WebViewClient());
    }
}
