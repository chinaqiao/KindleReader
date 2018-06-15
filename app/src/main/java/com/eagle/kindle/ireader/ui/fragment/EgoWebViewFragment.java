package com.eagle.kindle.ireader.ui.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebViewFragment;

import com.eagle.kindle.ireader.R;
import com.eagle.kindle.ireader.model.bean.SectionBean;
import com.eagle.kindle.ireader.model.flag.UserCenterType;
import com.eagle.kindle.ireader.ui.adapter.SectionAdapter;
import com.eagle.kindle.ireader.ui.base.BaseFragment;
import com.eagle.kindle.ireader.ui.base.adapter.BaseListAdapter;
import com.eagle.kindle.ireader.widget.itemdecoration.DividerItemDecoration;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * 用户中心
 */

public class EgoWebViewFragment extends BaseFragment implements BaseListAdapter.OnItemClickListener{
    /***************view******************/
    @BindView(R.id.web_main)
    WebView mWebView;
    private View mContentView;
    private static final String APP_CACAHE_DIRNAME = "/webcache";

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1: {
                    webViewGoBack();
                }
                break;
            }
        }
    };
    private void webViewGoBack() {
        mWebView.goBack();
    }

    @Override
    protected int getContentId() {
        return R.layout.fragment_webview;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mContentView = super.onCreateView(inflater, container, savedInstanceState);
        mWebView = (WebView) mContentView.findViewById(R.id.web_main);

        WebSettings settings = mWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        mWebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        mWebView.getSettings().setSupportZoom(true);  //支持放大缩小
        mWebView.getSettings().setBuiltInZoomControls(true);
        mWebView.loadUrl("http://www.baidu.com");
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        mWebView.getSettings().setSaveFormData(true);// 保存表单数据
        mWebView.setWebViewClient(new WebViewClient());
        String cacheDirPath = getActivity().getFilesDir().getAbsolutePath() + APP_CACAHE_DIRNAME; //缓存路径

        mWebView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);  //缓存模式
        mWebView.getSettings().setAppCachePath(cacheDirPath); //设置缓存路径
        mWebView.getSettings().setAppCacheEnabled(true); //开启缓存功能

        mWebView.setOnKeyListener(new View.OnKeyListener() {

            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((keyCode == KeyEvent.KEYCODE_BACK) && mWebView.canGoBack()) {
                    handler.sendEmptyMessage(1);
                    return true;
                }
                return false;
            }

        });
        return mContentView;
        // return super.onCreateView(inflater, container, savedInstanceState);
    }

    /***********************************init method*************************************************/

    private void initWebView() {
        //加载的路径
        mWebView.loadUrl("http://www.baidu.com");
        //支持App内部JavaScript交互
        mWebView.getSettings().setJavaScriptEnabled(true);
        //自适应屏幕
        mWebView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        mWebView.getSettings().setLoadWithOverviewMode(true);
        //设置可以支持缩放
        mWebView.getSettings().setSupportZoom(true);
        //扩大比例的缩放
        mWebView.getSettings().setUseWideViewPort(true);
        //设置是否出现缩放工具
        mWebView.getSettings().setBuiltInZoomControls(true);

        //设置编码
        mWebView.getSettings().setDefaultTextEncodingName("utf-8");
    }

    /****************************click method********************************/

    public void onItemClick(View view, int pos) {

    }
}
