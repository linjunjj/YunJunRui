package com.linjun.yunjunrui.ui.me.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.linjun.yunjunrui.R;
import com.linjun.yunjunrui.ui.base.BaseActivity;
import com.linjun.yunjunrui.utils.ActionUtils;
import com.linjun.yunjunrui.view.EditTextWithDeleteButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 作者：林俊 on 2017/7/31
 * 作用：
 */
public class ActivityFindPsw extends BaseActivity {
    @BindView(R.id.iv_findpswback1)
    ImageView ivFindpswback1;
    @BindView(R.id.tv_s)
    TextView tvS;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.ed_acount)
    EditTextWithDeleteButton edAcount;
    @BindView(R.id.btn_next)
    Button btnNext;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_findpassworld;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void bindEvent() {

    }


    @OnClick({R.id.iv_findpswback1, R.id.btn_next})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_findpswback1:
                this.finish();
                break;
            case R.id.btn_next:
                ActionUtils.actionStart(this,ActivityFindPsw1.class);
                break;
        }
    }
}
