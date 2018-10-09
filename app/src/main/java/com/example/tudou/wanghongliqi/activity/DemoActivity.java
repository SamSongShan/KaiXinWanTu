package com.example.tudou.wanghongliqi.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.tudou.wanghongliqi.R;
import com.example.tudou.wanghongliqi.base.BaseActivity;
import com.example.tudou.wanghongliqi.utils.StatusBarUtil;
import com.example.tudou.wanghongliqi.utils.StatusBarUtils;
import com.example.tudou.wanghongliqi.utils.ToolBarUtil;

import butterknife.BindView;
import butterknife.ButterKnife;


public class DemoActivity extends BaseActivity {


    @BindView(R.id.toolbar_text)
    Toolbar toolbarText;

    @Override
    protected int getViewResId() {
        return R.layout.activity_demo;
    }

    @Override
    protected void init() {
        StatusBarUtils.setStatusBarLightMode(this, Color.WHITE);

        ToolBarUtil.initToolBar(toolbarText, "测试专用", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
