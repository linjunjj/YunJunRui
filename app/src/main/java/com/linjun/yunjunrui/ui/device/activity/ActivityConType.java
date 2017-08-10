package com.linjun.yunjunrui.ui.device.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.linjun.yunjunrui.R;
import com.linjun.yunjunrui.eventbus.MessageCode;
import com.linjun.yunjunrui.ui.base.BaseActivity;
import com.linjun.yunjunrui.utils.ActionUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

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
    private MessageCode messageCode;
    private  int i;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_type;
    }

    @Override
    protected void initView() {
        EventBus.getDefault().register(this);
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
                if (i!=0){
                    ActionUtils.actionStart(this,ActivityAddGsm.class);
                }else {
                    ActionUtils.actionStart(this,ActivityAddVideo.class);
                }

                break;
        }
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(MessageCode code) {
        try {
             i = code.isPage;

        } catch (Exception e) {

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
