package com.linjun.yunjunrui.ui.me.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.linjun.yunjunrui.R;
import com.linjun.yunjunrui.ui.base.BaseActivity;
import com.linjun.yunjunrui.utils.ValidationUtil;
import com.linjun.yunjunrui.view.EditTextWithDeleteButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 作者：林俊 on 2017/8/3
 * 作用：
 */
public class ActivityChangPsd extends BaseActivity {
    @BindView(R.id.iv_changepswback1)
    ImageView ivChangepswback1;
    @BindView(R.id.tv_s)
    TextView tvS;
    @BindView(R.id.ed_oldpsd)
    EditTextWithDeleteButton edOldpsd;
    @BindView(R.id.ed_newpsd)
    EditTextWithDeleteButton edNewpsd;
    @BindView(R.id.ed_netsure)
    EditTextWithDeleteButton edNetsure;
    @BindView(R.id.btn_nsure)
    Button btnNsure;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_changepsd;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void bindEvent() {

    }

    @OnClick({R.id.iv_changepswback1, R.id.btn_nsure})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_changepswback1:
                this.finish();
                break;
            case R.id.btn_nsure:
                if (ValidationUtil.IsEmpty(this,edOldpsd)){

                }


                break;
        }
    }

}
