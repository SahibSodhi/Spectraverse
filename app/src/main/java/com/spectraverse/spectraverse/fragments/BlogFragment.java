package com.spectraverse.spectraverse.fragments;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
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
import com.spectraverse.spectraverse.activities.MainActivity;

public class BlogFragment extends Fragment {
    WebView webView;
    ProgressDialog progressDialog;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ((MainActivity)getActivity()).getSupportActionBar().setTitle("Blog");
        View view = inflater.inflate(R.layout.fragment_blog, container, false);

        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setTitle("Processing...");
        progressDialog.setMessage("Please wait...");
        progressDialog.setCancelable(true);

        webView = (WebView) view.findViewById(R.id.WebView);
        String url = "https://spectraverseincusivity.wordpress.com";

        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);

        // probably a good idea to check it's not null, to avoid these situations:
        if (webView != null) {

            webView.setWebViewClient(new WebViewClient() {
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    view.loadUrl(url);
                    return true;
                }

                @Override
                public void onPageStarted(WebView view, String url, Bitmap favicon) {
                    progressDialog.show();
                }

                @Override
                public void onPageFinished(WebView view, String url) {
                    progressDialog.dismiss();
                }
            });

            webView.loadUrl(url);
        }

        return view;
    }
}
