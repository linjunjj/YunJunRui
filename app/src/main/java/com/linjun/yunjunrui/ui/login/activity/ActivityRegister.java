package com.linjun.yunjunrui.ui.login.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lib.funsdk.support.FunSupport;
import com.lib.funsdk.support.OnFunRegisterListener;
import com.linjun.yunjunrui.R;
import com.linjun.yunjunrui.ui.base.BaseActivity;
import com.linjun.yunjunrui.utils.ActionUtils;
import com.linjun.yunjunrui.utils.ValidationUtil;
import com.linjun.yunjunrui.view.EditTextWithDeleteButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 作者：林俊 on 2017/7/31
 * 作用：
 */
public class ActivityRegister extends BaseActivity implements OnFunRegisterListener {

    @BindView(R.id.iv_oneback)
    ImageView ivOneback;
    @BindView(R.id.tv_device_name)
    TextView tvDeviceName;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.user_tel)
    EditTextWithDeleteButton userTel;
    @BindView(R.id.user_email)
    EditTextWithDeleteButton userEmail;
    @BindView(R.id.ed_auth_code)
    EditTextWithDeleteButton edAuthCode;
    @BindView(R.id.get_auth_code)
    TextView getAuthCode;
    @BindView(R.id.user_passworld)
    EditTextWithDeleteButton userPassworld;
    @BindView(R.id.header)
    LinearLayout header;
    @BindView(R.id.user_name1)
    EditTextWithDeleteButton userName1;
    @BindView(R.id.user_name)
    EditTextWithDeleteButton userName;
    @BindView(R.id.ed_auth_code1)
    EditTextWithDeleteButton edAuthCode1;
    @BindView(R.id.get_auth_code1)
    TextView getAuthCode1;
    @BindView(R.id.user_passworld1)
    EditTextWithDeleteButton userPassworld1;
    @BindView(R.id.header2)
    LinearLayout header2;
    @BindView(R.id.btn_register1)
    Button btnRegister1;
    @BindView(R.id.btn_login1)
    Button btnLogin1;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    protected void initView() {
        FunSupport.getInstance().registerOnFunRegisterListener(this);
    }

    @Override
    protected void bindEvent() {

    }


    @OnClick({R.id.iv_oneback, R.id.btn_register1, R.id.btn_login1, R.id.get_auth_code})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_oneback:
                this.finish();
                break;
            case R.id.btn_register1:

                break;
            case R.id.btn_login1:
                ActionUtils.actionStart(this, ActivityLogin.class);
                break;
            case R.id.get_auth_code:
                tryGetVerifyCode();
                break;
        }
    }
    private  void showRegisterLayout(boolean byEmail){
      if (byEmail){
          header2.setVisibility(View.VISIBLE);
         header.setVisibility(View.GONE);
      }else{
        header.setVisibility(View.VISIBLE);
         header2.setVisibility(View.GONE);
      }
    }





    private void tryGetVerifyCode() {
        String usertel = userTel.getText().toString().trim();
        if (ValidationUtil.IsEmpty(this, userEmail)) {
            Toast.makeText(this, "邮箱不能为空", Toast.LENGTH_SHORT).show();
        }
        if (ValidationUtil.IsEmpty(this, userTel)) {
            Toast.makeText(this, "手机号码不能为空", Toast.LENGTH_SHORT).show();
        }
        if (!ValidationUtil.IsPhoneMumber(this, userTel)) {
            Toast.makeText(this, "手机号码格式不正确", Toast.LENGTH_SHORT).show();
        } else {
            if (!FunSupport.getInstance().requestPhoneMsg(null, usertel)) {
                Toast.makeText(this, "获取验证码成功", Toast.LENGTH_SHORT).show();
            }
        }
        if (!ValidationUtil.IsEmali(this, userEmail)) {
            Toast.makeText(this, "邮箱格式不正确", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onRequestSendCodeSuccess() {

    }

    @Override
    public void onRequestSendCodeFailed(Integer errCode) {

    }

    @Override
    public void onRegisterNewUserSuccess() {

    }

    @Override
    public void onRegisterNewUserFailed(Integer errCode) {

    }

    @Override
    public void onUserNameFine() {

    }

    @Override
    public void onUserNameUnfine(Integer errCode) {

    }


}
