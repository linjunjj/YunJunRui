package com.linjun.yunjunrui.ui.me.activity;

import android.os.Bundle;
import android.widget.ImageView;

import com.linjun.yunjunrui.R;
import com.linjun.yunjunrui.ui.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 作者：林俊 on 2017/7/31
 * 作用：
 */
public class ActivityContact extends BaseActivity {
    @BindView(R.id.iv_contactback)
    ImageView ivContactback;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_contact;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void bindEvent() {

    }


    @OnClick(R.id.iv_contactback)
    public void onViewClicked() {
        this.finish();
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
