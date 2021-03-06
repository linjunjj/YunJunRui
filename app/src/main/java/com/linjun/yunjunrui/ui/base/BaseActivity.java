package com.linjun.yunjunrui.ui.base;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.linjun.yunjunrui.event.BusManager;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 作者：林俊 on 2017/7/26
 * 作用：Activity的基类
 */
public  abstract class BaseActivity extends AppCompatActivity {
   protected abstract  int getLayoutId();
    protected abstract  void initView();
    private Unbinder unbinder;
    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        fullScreen();
        setContentView(getLayoutId());
       unbinder=ButterKnife.bind(this);
        initView();
        bindEvent();
        if (isRegisterEvent()){
            BusManager.getBus().register(this);
        }
    }

    protected  void fullScreen(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            window.setFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
            );
        }
    }
    protected boolean isRegisterEvent(){
        return false;
    }

    protected   abstract  void bindEvent();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
