package com.linjun.yunjunrui.ui.device.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
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
public class ActivityGsmParticular extends BaseActivity {
    @BindView(R.id.iv_gsmparback)
    ImageView ivGsmparback;
    @BindView(R.id.tv_device_name)
    TextView tvDeviceName;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.devide_icon)
    ImageView devideIcon;
    @BindView(R.id.device_title)
    TextView deviceTitle;
    @BindView(R.id.iv_set)
    ImageView ivSet;
    @BindView(R.id.btn_delete)
    Button btnDelete;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_gsm_particular;
    }

    @Override
    protected void initView() {
    }
    @Override
    protected void bindEvent() {

    }

    @OnClick({R.id.iv_gsmparback, R.id.btn_delete})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_gsmparback:
                this.finish();
                break;
            case R.id.btn_delete:
                break;
        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
