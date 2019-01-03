package com.spectraverse.spectraverse.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.spectraverse.spectraverse.R;

public class BlogFragment extends Fragment {
    WebView webView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blog, container, false);
        webView = (WebView) view.findViewById(R.id.WebView);

        webView.getSettings().setJavaScriptEnabled(true);
        String url = "https://spectraverseincusivity.wordpress.com";
        // probably a good idea to check it's not null, to avoid these situations:
        if (webView != null) {
            webView.loadUrl(url);
            webView.setWebViewClient(new WebViewClient() {
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    view.loadUrl(url);
                    return true;
                }
            });
        }

        return view;
    }
}
