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
 * 视频
 */
public class VideoFragment extends BaseFragment {


    public VideoFragment() {
        // Required empty public constructor
    }
    @Override
    protected void init(View v) {
        StatusBarUtil.setTranslucentForImageViewInFragment(getActivity(), null);
    }
    @Override
    public void onSaveInstanceState(Bundle outState) {

    }

    @Override
    protected int getViewResId() {
        return R.layout.fragment_video;
    }

    public void onRefresh() {
        StatusBarUtil.setTranslucentForImageViewInFragment(getActivity(), null);
    }
}
