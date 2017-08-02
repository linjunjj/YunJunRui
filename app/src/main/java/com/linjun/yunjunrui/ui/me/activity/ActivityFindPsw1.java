package com.linjun.yunjunrui.ui.me.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.linjun.yunjunrui.R;
import com.linjun.yunjunrui.ui.base.BaseActivity;
import com.linjun.yunjunrui.view.EditTextWithDeleteButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 作者：林俊 on 2017/7/31
 * 作用：
 */
public class ActivityFindPsw1 extends BaseActivity {
    @BindView(R.id.iv_findpswback2)
    ImageView ivFindpswback2;
    @BindView(R.id.tv_s)
    TextView tvS;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.r_tel)
    RelativeLayout rTel;
    @BindView(R.id.r_email)
    RelativeLayout rEmail;
    @BindView(R.id.ed_auth_code)
    EditTextWithDeleteButton edAuthCode;
    @BindView(R.id.get_auth_code)
    TextView getAuthCode;
    @BindView(R.id.btn_next)
    Button btnNext;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_findpassworld2;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void bindEvent() {

    }

    @OnClick({R.id.iv_findpswback2, R.id.r_tel, R.id.r_email, R.id.get_auth_code, R.id.btn_next})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_findpswback2:
                this.finish();
                break;
            case R.id.r_tel:
                break;
            case R.id.r_email:
                break;
            case R.id.get_auth_code:
                break;
            case R.id.btn_next:
                break;
        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
