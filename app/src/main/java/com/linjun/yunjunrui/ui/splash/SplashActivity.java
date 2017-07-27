package com.linjun.yunjunrui.ui.splash;

import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.linjun.yunjunrui.R;
import com.linjun.yunjunrui.ui.base.BaseActivity;
import com.linjun.yunjunrui.utils.ActionUtils;

/**
 * 作者：林俊 on 2017/7/27
 * 作用：
 */
public class SplashActivity extends BaseActivity {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView() {
        setFullScreen();
       new Handler().postDelayed(new Runnable() {
           @Override
           public void run() {
               ActionUtils.actionStart(SplashActivity.this,SplashAcivity1.class);
           }
       },500);
        this.finish();
    }
    private void setFullScreen() {
        int flag = WindowManager.LayoutParams.FLAG_FULLSCREEN;
        Window window = SplashActivity.this.getWindow();
        window.setFlags(flag, flag);

    }





    @Override
    protected void bindEvent() {

    }




}
