package com.linjun.yunjunrui.ui.login.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lib.funsdk.support.FunError;
import com.lib.funsdk.support.FunSupport;
import com.lib.funsdk.support.OnFunRegisterListener;
import com.linjun.yunjunrui.R;
import com.linjun.yunjunrui.ui.base.BaseActivity;
import com.linjun.yunjunrui.utils.ActionUtils;
import com.linjun.yunjunrui.utils.MyCountDownTimer;
import com.linjun.yunjunrui.utils.ValidationUtil;
import com.linjun.yunjunrui.view.EditTextWithDeleteButton;
import com.throrinstudio.android.common.libs.validator.Form;
import com.throrinstudio.android.common.libs.validator.Validate;
import com.throrinstudio.android.common.libs.validator.validator.EmailValidator;
import com.throrinstudio.android.common.libs.validator.validator.NotEmptyValidator;
import com.throrinstudio.android.common.libs.validator.validator.PhoneValidator;

import org.apache.commons.lang3.builder.ToStringBuilder;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.internal.operators.flowable.FlowableWithLatestFrom;

/**
 * 作者：林俊 on 2017/7/31
 * 作用：
 */
public class ActivityRegister extends BaseActivity implements OnFunRegisterListener {

    @BindView(R.id.iv_oneback)
    ImageView ivOneback;
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
    @BindView(R.id.tv_Emial)
    TextView tvEmial;
    @BindView(R.id.tv_Tel)
    TextView tvTel;
    private boolean isemail1 = false;
    private boolean top=true;
    private Form form;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    protected void initView() {
        FunSupport.getInstance().registerOnFunRegisterListener(this);
        showRegisterLayout(isemail1);
        showtop(top);
    }

    @Override
    protected void bindEvent() {

    }

    @OnClick({R.id.iv_oneback, R.id.btn_register1, R.id.btn_login1, R.id.get_auth_code, R.id.tv_Emial,R.id.tv_Tel})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_oneback:
                this.finish();
                break;
            case R.id.btn_register1:
                validator(isemail1);
                 if (form.validate()){
                     register(isemail1);
                 }else {
                     Toast.makeText(this,"请填写正确内容",Toast.LENGTH_SHORT).show();
                 }

               //register(true);
                break;
            case R.id.btn_login1:
                ActionUtils.actionStart(this, ActivityLogin.class);
                break;
            case R.id.get_auth_code:
                final MyCountDownTimer timer=new MyCountDownTimer(60000,1000,getAuthCode);
                 timer.start();
                validator(isemail1);
                break;
            case R.id.tv_Emial:
                isemail1=true;
                 top=false;
                showRegisterLayout(isemail1);
                showtop(top);
                break;
            case R.id.tv_Tel:
                isemail1=false;
                top=true;
                showtop(top);
                showRegisterLayout(isemail1);
                break;
        }
    }

    private void showRegisterLayout(boolean byEmail) {
        if (byEmail) {
            header2.setVisibility(View.VISIBLE);
            header.setVisibility(View.GONE);
        } else {
            header.setVisibility(View.VISIBLE);
            header2.setVisibility(View.GONE);
        }
    }
     private  void showtop(boolean top){
         if (top){
             tvEmial.setVisibility(View.VISIBLE);
             tvTel.setVisibility(View.GONE);
         }else {
               tvEmial.setVisibility(View.GONE);
             tvTel.setVisibility(View.VISIBLE);
         }
     }

//    private void tryGetVerifyCode() {
//        String usertel = userTel.getText().toString().trim();
//        if (ValidationUtil.IsEmpty(this, userEmail)) {
//            Toast.makeText(this, "邮箱不能为空", Toast.LENGTH_SHORT).show();
//        }
//        if (ValidationUtil.IsEmpty(this, userTel)) {
//            Toast.makeText(this, "手机号码不能为空", Toast.LENGTH_SHORT).show();
//        }
//        if (!ValidationUtil.IsPhoneMumber(this, userTel)) {
//            Toast.makeText(this, "手机号码格式不正确", Toast.LENGTH_SHORT).show();
//        } else {
//              FunSupport.getInstance().requestPhoneMsg(null, usertel);
//            if (!FunSupport.getInstance().requestPhoneMsg(null, usertel)) {
//                Toast.makeText(this, "获取验证码成功", Toast.LENGTH_SHORT).show();
//            }
//        }
//        if (!ValidationUtil.IsEmali(this, userEmail)) {
//            Toast.makeText(this, "邮箱格式不正确", Toast.LENGTH_SHORT).show();
//        }
//    }

    private void validator(boolean isemail1){
        form=new Form();
        if (!isemail1){
            Validate name=new Validate(userName);
            name.addValidator(new NotEmptyValidator(this));
            Validate tel=new Validate(userTel);
            tel.addValidator(new NotEmptyValidator(this) );
             tel.addValidator(new PhoneValidator(this));
            Validate code=new Validate(edAuthCode);
            code.addValidator(new NotEmptyValidator(this));
             Validate psd=new Validate(userPassworld);
            psd.addValidator(new NotEmptyValidator(this));
            form.addValidates(name);
             form.addValidates(tel);
             form.addValidates(code);
             form.addValidates(psd);
        }else {
               Validate name=new Validate(userName1);
               name.addValidator(new NotEmptyValidator(this));
               Validate email=new Validate(userEmail);
                 email.addValidator(new  NotEmptyValidator(this));
                 email.addValidator(new EmailValidator(this));
            Validate code=new Validate(edAuthCode1);
            code.addValidator(new NotEmptyValidator(this));
            Validate pad=new Validate(userPassworld1);
            pad.addValidator(new NotEmptyValidator(this));
            form.addValidates(name);
            form.addValidates(email);
            form.addValidates(code);
            form.addValidates(pad);

        }
    }


    private void register(boolean istel){
      if (istel){
        String username=  userName.getText().toString().trim();
        String  tel=tvTel.getText().toString().trim();
          String code=getAuthCode.getText().toString().trim();
          String  passworld=userPassworld.getText().toString().trim();
           FunSupport.getInstance().registerByPhone(username,passworld,code,tel);

      }else {
             String username1=userName1.getText().toString().trim();
            String mail=tvEmial.getText().toString().trim();
          String  code=getAuthCode1.getText().toString().trim();
          String passworld=userPassworld1.getText().toString().trim();
          FunSupport.getInstance().registerByPhone(username1,passworld,code,mail);
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
        Toast.makeText(this,"注册失败",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUserNameFine() {

    }

    @Override
    public void onUserNameUnfine(Integer errCode) {
         Toast.makeText(this, FunError.getErrorStr(errCode),Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        FunSupport.getInstance().removeOnFunRegisterListener(this);
        super.onDestroy();
    }
}
