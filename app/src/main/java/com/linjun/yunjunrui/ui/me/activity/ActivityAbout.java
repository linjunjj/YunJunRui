package com.linjun.yunjunrui.ui.me.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.linjun.yunjunrui.R;
import com.linjun.yunjunrui.ui.base.BaseActivity;
import com.linjun.yunjunrui.utils.ActionUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 作者：林俊 on 2017/7/31
 * 作用：
 */
public class ActivityAbout extends BaseActivity {
    @BindView(R.id.iv_aboutback)
    ImageView ivAboutback;
    @BindView(R.id.r_guide)
    RelativeLayout rGuide;
    @BindView(R.id.r_idea)
    RelativeLayout rIdea;
    @BindView(R.id.r_contact)
    RelativeLayout rContact;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_about;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void bindEvent() {

    }



    @OnClick({R.id.iv_aboutback, R.id.r_guide, R.id.r_idea, R.id.r_contact})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_aboutback:
                this.finish();
                break;
            case R.id.r_guide:
                ActionUtils.actionStart(ActivityAbout.this,ActivityGuide.class);
                break;
            case R.id.r_idea:
                ActionUtils.actionStart(ActivityAbout.this,ActivityIdea.class);
                break;
            case R.id.r_contact:
                ActionUtils.actionStart(ActivityAbout.this,ActivityContact.class);
                break;
        }
    }
}
