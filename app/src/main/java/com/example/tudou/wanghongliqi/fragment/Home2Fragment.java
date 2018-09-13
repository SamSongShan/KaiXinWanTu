package com.example.tudou.wanghongliqi.fragment;


import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.example.tudou.wanghongliqi.R;
import com.example.tudou.wanghongliqi.base.BaseFragment;
import com.example.tudou.wanghongliqi.utils.StatusBarUtil;
import com.example.tudou.wanghongliqi.utils.StatusBarUtils;

/**
 * 图片预览
 */
public class Home2Fragment extends BaseFragment {


    private View v;

    public Home2Fragment() {
        // Required empty public constructor
    }


    @Override
    protected int getViewResId() {
        return R.layout.fragment_home2;
    }

    @Override
    protected void init(View v) {
        this.v = v;

        fullScreen(v);

    }

    public void onRefresh() {
        //StatusBarUtils.translucentStatusBar(getActivity(),false);
        fullScreen(v);
    }

    /**
     * 通过设置全屏，设置状态栏透明
     *
     *
     */
    private void fullScreen(View v) {

        View viewById = v.findViewById(R.id.ll);
        StatusBarUtil.setTranslucentForImageViewInFragment(getActivity(), null);




    }



}
