package com.linjun.yunjunrui.ui.device.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
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
public class ActivityAddGsm extends BaseActivity {
    @BindView(R.id.iv_gsmback)
    ImageView ivGsmback;
    @BindView(R.id.main_text)
    TextView mainText;
    @BindView(R.id.ed_name)
    EditTextWithDeleteButton edName;
    @BindView(R.id.ed_number)
    EditTextWithDeleteButton edNumber;
    @BindView(R.id.ed_telnum)
    EditTextWithDeleteButton edTelnum;
    @BindView(R.id.ed_passworld)
    EditTextWithDeleteButton edPassworld;
    @BindView(R.id.btn_add_gsm)
    Button btnAddGsm;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_add_gsm;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void bindEvent() {

    }

    @OnClick({R.id.iv_gsmback, R.id.btn_add_gsm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_gsmback:
                this.finish();
                break;
            case R.id.btn_add_gsm:

                break;
        }
    }
}
