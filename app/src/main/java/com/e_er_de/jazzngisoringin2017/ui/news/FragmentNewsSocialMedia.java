package com.e_er_de.jazzngisoringin2017.ui.news;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.e_er_de.jazzngisoringin2017.R;
import com.wang.avi.AVLoadingIndicatorView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by e_er_de on 01/02/2017.
 */

public class FragmentNewsSocialMedia extends Fragment {
    @BindView(R.id.webview_social_media)WebView mWebView;
    @BindView(R.id.avi)AVLoadingIndicatorView avi;

    private static String TAG = FragmentNewsSocialMedia.class.getSimpleName();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_news_social_media, container, false);
        ButterKnife.bind(this, rootView);

        mWebView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (Uri.parse(url).getHost().endsWith("loenpiajazz.com")) {
                    return false;
                }
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                view.getContext().startActivity(intent);
                startAnim();
                return super.shouldOverrideUrlLoading(view, url);
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                startAnim();
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                view.loadUrl("javascript:if (typeof(document.getElementsByClassName('titleclass')[0]) != 'undefined' && document.getElementsByClassName('titleclass')[0] != null){document.getElementsByClassName('titleclass')[0].style.display = 'none';} void 0");
                view.loadUrl("javascript:if (typeof(document.getElementsByClassName('footerclass')[0]) != 'undefined' && document.getElementsByClassName('footerclass')[0] != null){document.getElementsByClassName('footerclass')[0].style.display = 'none';} void 0");
                view.loadUrl("javascript:if (typeof(document.getElementsByClassName('banner headerclass kad-header-style-basic')[0]) != 'undefined' && document.getElementsByClassName('banner headerclass kad-header-style-basic')[0] != null){document.getElementsByClassName('banner headerclass kad-header-style-basic')[0].style.display = 'none';} void 0");
                view.loadUrl("javascript:if (typeof(document.getElementsByClassName('twitter-share')[0]) != 'undefined' && document.getElementsByClassName('twitter-share')[0] != null){document.getElementsByClassName('twitter-share')[0].style.display = 'none';} void 0");
                view.loadUrl("javascript:if (typeof(document.getElementsByClassName('comment-respond')[0]) != 'undefined' && document.getElementsByClassName('comment-respond')[0] != null){document.getElementsByClassName('comment-respond')[0].style.display = 'none';} void 0");
                view.loadUrl("javascript:if (typeof(document.getElementsByClassName('widget-1 widget-first widget widget_search')[0]) != 'undefined' && document.getElementsByClassName('widget-1 widget-first widget widget_search')[0] != null){document.getElementsByClassName('widget-1 widget-first widget widget_search')[0].style.display = 'none';} void 0");
                view.loadUrl("javascript:if (typeof(document.getElementsByClassName('widget-2 widget widget_recent_entries')[0]) != 'undefined' && document.getElementsByClassName('widget-2 widget widget_recent_entries')[0] != null){document.getElementsByClassName('widget-2 widget widget_recent_entries')[0].style.display = 'none';} void 0");
                view.loadUrl("javascript:if (typeof(document.getElementsByClassName('widget-3 widget widget_archive')[0]) != 'undefined' && document.getElementsByClassName('widget-3 widget widget_archive')[0] != null){document.getElementsByClassName('widget-3 widget widget_archive')[0].style.display = 'none';} void 0");
                stopAnim();
            }
        });

        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        mWebView.loadUrl("http://loenpiajazz.com/?page_id=173");

        return rootView;
    }

    void startAnim(){
        avi.smoothToShow();
    }

    void stopAnim(){
        avi.smoothToHide();
    }

}
