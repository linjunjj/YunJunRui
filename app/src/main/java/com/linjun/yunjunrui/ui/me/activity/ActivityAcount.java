package com.linjun.yunjunrui.ui.me.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.lib.funsdk.support.FunSupport;
import com.linjun.yunjunrui.R;
import com.linjun.yunjunrui.db.DbHelper;
import com.linjun.yunjunrui.model.Usermodel;
import com.linjun.yunjunrui.ui.base.BaseActivity;
import com.linjun.yunjunrui.ui.login.activity.ActivityLogin;
import com.linjun.yunjunrui.ui.me.adapter.AcountApater;
import com.linjun.yunjunrui.utils.ActionUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 作者：林俊 on 2017/7/31
 * 作用：
 */
public class ActivityAcount extends BaseActivity {
    @BindView(R.id.iv_acountback)
    ImageView ivAcountback;
    @BindView(R.id.tv_device_name)
    TextView tvDeviceName;
    @BindView(R.id.iv_logout)
    TextView ivLogout;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.btn_add)
    Button btnAdd;
    @BindView(R.id.list_acount)
    RecyclerView listAcount;
  private AcountApater acountApater;
    private List<Usermodel> lists;
    private LinearLayoutManager mLinearLayoutManager;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_accountm;
    }

    @Override
    protected void initView() {
       lists= DbHelper.getInstance().user().loadAll();
        acountApater=new AcountApater(this,  lists);
         mLinearLayoutManager=new LinearLayoutManager(this);
        listAcount.setLayoutManager(mLinearLayoutManager);
        listAcount.setAdapter(acountApater);

    }

    @Override
    protected void bindEvent() {

    }


    @OnClick({R.id.iv_acountback, R.id.iv_logout, R.id.btn_add})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_acountback:
                this.finish();
                break;
            case R.id.iv_logout:
            ActionUtils.actionStart(this, ActivityLogin.class);
                FunSupport.getInstance().logout();
                break;
            case R.id.btn_add:
                ActionUtils.actionStart(this,ActivityAddAcount.class);
                break;
        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
