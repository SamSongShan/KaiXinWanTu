package com.example.tudou.wanghongliqi.api;

import com.example.tudou.wanghongliqi.HttpPostService;
import com.example.tudou.wanghongliqi.base.Api.BaseApiString;
import com.example.tudou.wanghongliqi.base.listener.HttpOnNextListener;
import com.example.tudou.wanghongliqi.model.Login;
import com.example.tudou.wanghongliqi.utils.DesUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import io.reactivex.Observable;
import retrofit2.Retrofit;

/**
 * Created by tudou on 2018/5/7.
 */

public class VersionPostApi extends BaseApiString {

    private boolean all;
    private Login json;

    public VersionPostApi(String method,Login json,HttpOnNextListener listener, RxAppCompatActivity rxAppCompatActivity) {
        super(listener, rxAppCompatActivity);
        this.json = json;


        setShowProgress(true);
        setCancel(true);
        setCache(false);
        setMethod(method);
        setCookieNetWorkTime(60);
        setCookieNoNetWorkTime(24 * 60 * 60);

    }


    public boolean isAll() {
        return all;
    }

    public void setAll(boolean all) {
        this.all = all;
    }

    @Override
    public Observable getObservable(Retrofit retrofit) {
        HttpPostService service = retrofit.create(HttpPostService.class);
        Gson gson = new GsonBuilder().create();
        String mobile = gson.toJson(json);

        return service.getAllVedioBy(DesUtil.encrypt(mobile));
    }

}
