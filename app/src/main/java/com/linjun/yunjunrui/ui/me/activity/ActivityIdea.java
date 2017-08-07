package com.linjun.yunjunrui.ui.me.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.linjun.yunjunrui.R;
import com.linjun.yunjunrui.ui.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 作者：林俊 on 2017/7/31
 * 作用：
 */
public class ActivityIdea extends BaseActivity {
    @BindView(R.id.iv_ideaback)
    ImageView ivIdeaback;
    @BindView(R.id.activity_send_text)
    EditText activitySendText;
    @BindView(R.id.et_tel)
    EditText etTel;
    @BindView(R.id.btn_submit)
    Button btnSubmit;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_opinion;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void bindEvent() {

    }

    @OnClick({R.id.iv_ideaback, R.id.btn_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_ideaback:
                this.finish();
                break;
            case R.id.btn_submit:
                Toast.makeText(this,"提交成功",Toast.LENGTH_SHORT).show();
                break;
        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
