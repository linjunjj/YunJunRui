package com.linjun.yunjunrui.ui.device.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.linjun.yunjunrui.R;
import com.linjun.yunjunrui.ui.base.BaseActivity;
import com.linjun.yunjunrui.utils.ActionUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 作者：林俊 on 2017/8/3
 * 作用：
 */
public class ActivityConType extends BaseActivity {
    @BindView(R.id.iv_con_cancel)
    ImageView ivConCancel;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.ap_con)
    LinearLayout apCon;
    @BindView(R.id.local_con)
    LinearLayout localCon;
    @BindView(R.id.inten_con)
    LinearLayout intenCon;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_type;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void bindEvent() {

    }


    @OnClick({R.id.iv_con_cancel, R.id.ap_con, R.id.local_con, R.id.inten_con})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_con_cancel:
                this.finish();
                break;
            case R.id.ap_con:

                break;
            case R.id.local_con:
                break;
            case R.id.inten_con:
                ActionUtils.actionStart(this,ActivityAddGsm.class);
                break;
        }
    }
}
