package com.linjun.yunjunrui.ui.me.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.linjun.yunjunrui.R;
import com.linjun.yunjunrui.ui.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 作者：林俊 on 2017/8/5
 * 作用：
 */
public class ActivityCheck extends BaseActivity {
    @BindView(R.id.iv_checkback)
    ImageView ivCheckback;
    @BindView(R.id.tv_device_name)
    TextView tvDeviceName;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected int getLayoutId() {
        return R.layout.activitycheck;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void bindEvent() {

    }


    @OnClick(R.id.iv_checkback)
    public void onViewClicked() {
        this.finish();
    }
}
