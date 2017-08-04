package com.linjun.yunjunrui.ui.me.activity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.linjun.yunjunrui.R;
import com.linjun.yunjunrui.ui.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 作者：林俊 on 2017/7/31
 * 作用：
 */
public class ActivityAddAcount extends BaseActivity {
    @BindView(R.id.iv_addacountback)
    ImageView ivAddacountback;
    @BindView(R.id.tv_device_name)
    TextView tvDeviceName;
    @BindView(R.id.rbtnremeber)
    RadioButton rbtnremeber;
    @BindView(R.id.tv_forget)
    TextView tvForget;
    @BindView(R.id.btn_adduer)
    Button btnAdduer;
    @BindView(R.id.btn_register)
    Button btnRegister;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_add_login;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void bindEvent() {

    }

    @OnClick({R.id.iv_addacountback, R.id.rbtnremeber, R.id.tv_forget, R.id.btn_adduer, R.id.btn_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_addacountback:
                  this.finish();
                   break;
            case R.id.rbtnremeber:
                break;
            case R.id.tv_forget:
                break;
            case R.id.btn_adduer:
                break;
            case R.id.btn_register:
                break;
        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
