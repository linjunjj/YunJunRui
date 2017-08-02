package com.linjun.yunjunrui.ui.device.activity;

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
 * 作者：林俊 on 2017/7/31
 * 作用：
 */
public class ActivityGsmDetail extends BaseActivity {
    @BindView(R.id.iv_gsmdetailback)
    ImageView ivGsmdetailback;
    @BindView(R.id.tv_device_name)
    TextView tvDeviceName;
    @BindView(R.id.iv_set)
    ImageView ivSet;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_gsmdetail;
    }
    @Override
    protected void initView() {

    }

    @Override
    protected void bindEvent() {

    }


    @OnClick(R.id.iv_gsmdetailback)
    public void onViewClicked() {
        this.finish();
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
