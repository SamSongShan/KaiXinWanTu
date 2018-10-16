package com.example.tudou.wanghongliqi.fragment;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tudou.wanghongliqi.MainActivity;
import com.example.tudou.wanghongliqi.R;
import com.example.tudou.wanghongliqi.api.VersionPostApi;
import com.example.tudou.wanghongliqi.base.BaseFragment;
import com.example.tudou.wanghongliqi.base.http.HttpManager;
import com.example.tudou.wanghongliqi.base.listener.HttpOnNextListener;
import com.example.tudou.wanghongliqi.base.subscribers.ProgressSubscriber;
import com.example.tudou.wanghongliqi.custom.RefreshLayout;
import com.example.tudou.wanghongliqi.model.Login;
import com.example.tudou.wanghongliqi.utils.CommonUtil;
import com.example.tudou.wanghongliqi.utils.DesUtil;
import com.example.tudou.wanghongliqi.utils.StatusBarUtil;
import com.facebook.drawee.view.SimpleDraweeView;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static android.app.Activity.RESULT_OK;

/**
 * 图片
 */
public class HomeFragment extends BaseFragment implements RefreshLayout.OnRefreshListener {


    @BindView(R.id.rlf)
    RefreshLayout rlf;
    @BindView(R.id.image)
    SimpleDraweeView image;

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

        //checkVersion();
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


    @OnClick({R.id.btn_pick, R.id.btn_save})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_pick:
                CommonUtil.choosePhoto(this, PictureConfig.CHOOSE_REQUEST);
                break;
            case R.id.btn_save:
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {

            if (requestCode == PictureConfig.CHOOSE_REQUEST) {
                List<LocalMedia> selectList = PictureSelector.obtainMultipleResult(data);
                String path = "";
                if (selectList != null && selectList.size() > 0) {
                    LocalMedia localMedia = selectList.get(0);
                    if (localMedia.isCompressed()) {
                        path = localMedia.getCompressPath();
                    } else if (localMedia.isCut()) {
                        path = localMedia.getCutPath();
                    } else {
                        path = localMedia.getPath();
                    }
                }
                String filepath = CommonUtil.amendRotatePhoto(path, getContext());
//                imageView.setImageBitmap(BitmapFactory.decodeFile(filepath));
                Bitmap bitmap = CommonUtil.createAsciiPic(filepath, getContext());
                image.setImageBitmap(bitmap);
            }
        }
    }
}
