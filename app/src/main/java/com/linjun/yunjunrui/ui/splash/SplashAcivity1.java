package com.linjun.yunjunrui.ui.splash;

import android.os.Handler;
import android.view.View;

import com.linjun.yunjunrui.R;
import com.linjun.yunjunrui.ui.base.BaseActivity;
import com.linjun.yunjunrui.ui.main.MainActivity;
import com.linjun.yunjunrui.utils.ActionUtils;

/**
 * 作者：林俊 on 2017/7/27
 * 作用：
 */
public class SplashAcivity1 extends BaseActivity {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash1;
    }

    @Override
    protected void initView() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ActionUtils.actionStart(SplashAcivity1.this, MainActivity.class);
            }
        },2000);
        this.finish();
    }

    @Override
    protected void bindEvent() {

    }

}
