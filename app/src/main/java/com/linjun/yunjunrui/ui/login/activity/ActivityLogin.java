package com.linjun.yunjunrui.ui.login.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lib.funsdk.support.FunSupport;
import com.lib.funsdk.support.OnFunLoginListener;
import com.lib.funsdk.support.models.FunLoginType;
import com.linjun.yunjunrui.R;
import com.linjun.yunjunrui.ui.base.BaseActivity;
import com.linjun.yunjunrui.ui.main.MainActivity;
import com.linjun.yunjunrui.utils.ActionUtils;
import com.linjun.yunjunrui.utils.ValidationUtil;
import com.linjun.yunjunrui.view.EditTextWithDeleteButton;
import com.throrinstudio.android.common.libs.validator.Form;
import com.throrinstudio.android.common.libs.validator.Validate;
import com.throrinstudio.android.common.libs.validator.validator.NotEmptyValidator;
import com.vise.xsnow.cache.SpCache;

import butterknife.BindView;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 作者：林俊 on 2017/7/31
 * 作用：
 */
public class ActivityLogin extends BaseActivity implements OnFunLoginListener {
    @BindView(R.id.iv_loginback)
    ImageView ivLoginback;
    @BindView(R.id.tv_device_name)
    TextView tvDeviceName;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.user_icon)
    CircleImageView userIcon;
    @BindView(R.id.user_account)
    EditTextWithDeleteButton userAccount;
    @BindView(R.id.user_passworld)
    EditTextWithDeleteButton userPassworld;
    @BindView(R.id.header)
    LinearLayout header;
    @BindView(R.id.rbtn_remeber)
    CheckBox rbtnRemeber;
    @BindView(R.id.bowwn)
    RelativeLayout bowwn;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.user_register)
    Button userRegister;
    private SpCache spCache;
      private  boolean isCheck=true;
    private Form form;
    private ProgressDialog progressDialog;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        FunSupport.getInstance().setLoginType(FunLoginType.LOGIN_BY_INTENTT);
        FunSupport.getInstance().registerOnFunLoginListener(this);
        spCache=new SpCache(this);
    }
    @Override
    protected void bindEvent() {
    }
private void  tryLogin(){
    String username=userAccount.getText().toString().trim();
    String userpsd=userPassworld.getText().toString().trim();
    if (null==username||username.length()==0){
        Toast.makeText(this,"用户名不能为空",Toast.LENGTH_SHORT).show();
    }else if (null==userpsd||userpsd.length()==0){
        Toast.makeText(this,"密码不能为空",Toast.LENGTH_SHORT).show();
    }else {
        if ( !FunSupport.getInstance().login(username, userpsd) ) {
           Toast.makeText(this,"登入失败",Toast.LENGTH_SHORT).show();
        }else {
            spCache.put("username",username);
            spCache.put("userpsd",userpsd);
        }
    }

}

    @OnClick({R.id.iv_loginback, R.id.rbtn_remeber, R.id.btn_login, R.id.user_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_loginback:
                this.finish();
                break;
            case R.id.rbtn_remeber:
                if (rbtnRemeber.isChecked()){
                //rbtnRemeber.setChecked(false);
                    isCheck=true;
                    FunSupport.getInstance().setSavePasswordAfterLogin(isCheck);
                }else {
                   // rbtnRemeber.setChecked(true);
                    isCheck=false;
                    FunSupport.getInstance().setSavePasswordAfterLogin(isCheck);
                }
                break;
            case R.id.btn_login:
                    if (validator()){
                        tryLogin();
                         progressDialog = new ProgressDialog(this);//1.创建一个ProgressDialog的实例
                        progressDialog.setTitle("加载中");//2.设置标题
                        progressDialog.setMessage("正在加载中，请稍等......");//3.设置显示内容
                        progressDialog.setCancelable(true);//4.设置可否用back键关闭对话框
                        progressDialog.show();
                    }else {
                       Toast.makeText(this,"请输入正确的数据",Toast.LENGTH_SHORT).show();
                    }

//                if (!ValidationUtil.IsEmpty(this,userAccount)){
//                    if (ValidationUtil.IsPhoneMumber(this,userAccount)&&ValidationUtil.IsEmpty(this,userPassworld)){
//                        tryLogin();
//                    }else {
//                        Toast.makeText(this,"账号格式不正确",Toast.LENGTH_SHORT).show();
//                    }
//                }else {
//                    Toast.makeText(this,"账号不能为空",Toast.LENGTH_SHORT).show();
//                }
                break;
            case R.id.user_register:
                ActionUtils.actionStart(this,ActivityRegister.class);
                break;
        }
    }

    private boolean validator(){
        form =new Form();
        Validate acount=new Validate(userAccount);
        acount.addValidator(new NotEmptyValidator(this));
        Validate  psd=new Validate(userPassworld);
        psd.addValidator(new NotEmptyValidator(this));
        form.addValidates(acount);
        form.addValidates(psd);
      return   form.validate();
    }


    @Override
    public void onLoginSuccess() {
     Toast.makeText(this,"登入成功",Toast.LENGTH_SHORT).show();
      progressDialog.dismiss();
        ActionUtils.actionStart(this, MainActivity.class);
    }
    @Override
    public void onLoginFailed(Integer errCode) {
     Toast.makeText(this,"登入失败",Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onLogout() {
    }
    @Override
    protected void onDestroy() {
        FunSupport.getInstance().removeOnFunLoginListener(this);
        super.onDestroy();
    }




}
