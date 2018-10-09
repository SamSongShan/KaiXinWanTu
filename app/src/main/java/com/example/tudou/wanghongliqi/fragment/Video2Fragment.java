package com.example.tudou.wanghongliqi.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tudou.wanghongliqi.R;
import com.example.tudou.wanghongliqi.base.BaseFragment;
import com.example.tudou.wanghongliqi.utils.StatusBarUtil;
import com.example.tudou.wanghongliqi.utils.StatusBarUtils;

/**
 * 视频预览
 */
public class Video2Fragment extends BaseFragment {


    public Video2Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

    }
    @Override
    protected int getViewResId() {
        return R.layout.fragment_video2;
    }

    @Override
    protected void init(View v) {
        StatusBarUtil.setLightMode(getActivity());

    }

    public void onRefresh() {
        StatusBarUtil.setLightMode(getActivity());

    }
}
