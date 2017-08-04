package com.linjun.yunjunrui.ui.me.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lib.funsdk.support.FunSupport;
import com.linjun.yunjunrui.R;
import com.linjun.yunjunrui.ui.base.BaseActivity;
import com.linjun.yunjunrui.ui.login.activity.ActivityLogin;
import com.linjun.yunjunrui.utils.ActionUtils;
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
    @BindView(R.id.iv_tel)
    ImageView ivTel;
    @BindView(R.id.iv_email)
    ImageView ivEmail;
    @BindView(R.id.ed_psd)
    EditTextWithDeleteButton edPsd;
    private String username;
    private boolean isEmail = false;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_findpassworld2;
    }

    @Override
    protected void initView() {
        Bundle data = this.getIntent().getExtras();
        username = data.getString("username");

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
                isEmail = false;
                showtrue(false);
                break;
            case R.id.r_email:
                isEmail = true;
                showtrue(isEmail);
                break;
            case R.id.get_auth_code:
                getCode(isEmail);
                break;
            case R.id.btn_next:
                changepsd(isEmail);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    private void showtrue(boolean isEmail) {
        if (isEmail) {
            ivTel.setVisibility(View.GONE);
            ivEmail.setVisibility(View.VISIBLE);
        } else {
            ivTel.setVisibility(View.VISIBLE);
            ivEmail.setVisibility(View.GONE);
        }
    }

    private void getCode(boolean isEmail) {
        if (isEmail) {
            String mail = username;
            FunSupport.getInstance().requestSendEmailCodeForResetPW(mail);
        } else {
            String tel=username;
            FunSupport.getInstance().requestSendPhoneMsgForResetPW(tel);
        }
    }
  private  void changepsd(boolean isEmail){
      if (isEmail){
         if ( FunSupport.getInstance().requestResetPasswByEmail(username,edPsd.getText().toString().trim())){
             ActionUtils.actionStart(this, ActivityLogin.class);
         }else {
             Toast.makeText(this,"修改失败",Toast.LENGTH_SHORT).show();
         }

      }else {
            if ( FunSupport.getInstance().requestResetPasswByPhone(username,edPsd.getText().toString().trim())){
                ActionUtils.actionStart(this,ActivityLogin.class);
            }else {
                Toast.makeText(this,"修改失败",Toast.LENGTH_SHORT).show();
            }
      }
  }

}
