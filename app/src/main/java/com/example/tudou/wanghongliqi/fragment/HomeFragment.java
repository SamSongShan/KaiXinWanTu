package com.example.tudou.wanghongliqi.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;

import com.example.tudou.wanghongliqi.R;
import com.example.tudou.wanghongliqi.api.VersionPostApi;
import com.example.tudou.wanghongliqi.base.BaseFragment;
import com.example.tudou.wanghongliqi.base.http.HttpManager;
import com.example.tudou.wanghongliqi.base.listener.HttpOnNextListener;
import com.example.tudou.wanghongliqi.base.subscribers.ProgressSubscriber;
import com.example.tudou.wanghongliqi.custom.RefreshLayout;
import com.example.tudou.wanghongliqi.model.Login;
import com.example.tudou.wanghongliqi.utils.DesUtil;
import com.example.tudou.wanghongliqi.utils.StatusBarUtil;
import com.example.tudou.wanghongliqi.utils.StatusBarUtils;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import butterknife.BindView;

/**
 * 图片
 */
public class HomeFragment extends BaseFragment implements RefreshLayout.OnRefreshListener {


    @BindView(R.id.rlf)
    RefreshLayout rlf;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

    }

    @Override
    protected int getViewResId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void init(View v) {
      // StatusBarUtils.setStatusBarLightMode(getActivity(), Color.WHITE);
        StatusBarUtil.setLightMode(getActivity());
        rlf.setOnRefreshListener(this);

    }

    @Override
    public void onRefresh() {
        //StatusBarUtils.setStatusBarLightMode(getActivity(), Color.WHITE);
        StatusBarUtil.setLightMode(getActivity());

        checkVersion();
    }

    private void checkVersion() {
        HttpOnNextListener httpOnNextListener = new HttpOnNextListener<String>() {
            @Override
            public void onNext(String method, String s) {

                Log.e("登录111", "onNext: " + DesUtil.decrypt(s));
                rlf.endRefresh();


            }

            @Override
            public void onError(String method, Throwable e) {
                super.onError(method, e);
                rlf.endRefresh();

            }

        };

        HttpManager instance = HttpManager.getInstance();
        ProgressSubscriber progressSubscriber = instance.doHttpDealString(new VersionPostApi("AddSignIn", new Login("Mobile", "13632840502", "123456"), httpOnNextListener, (RxAppCompatActivity) getActivity()), "加载中" + 111);


    }

}
