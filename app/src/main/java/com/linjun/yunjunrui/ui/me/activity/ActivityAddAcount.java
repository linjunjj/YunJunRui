package com.linjun.yunjunrui.ui.me.activity;

import android.app.ProgressDialog;
import android.media.MediaRouter;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.lib.funsdk.support.FunSupport;
import com.lib.funsdk.support.OnFunGetUserInfoListener;
import com.lib.funsdk.support.models.FunUserInfo;
import com.linjun.yunjunrui.R;
import com.linjun.yunjunrui.db.DbHelper;
import com.linjun.yunjunrui.model.Usermodel;
import com.linjun.yunjunrui.ui.base.BaseActivity;
import com.linjun.yunjunrui.ui.login.activity.ActivityRegister;
import com.linjun.yunjunrui.utils.ActionUtils;
import com.linjun.yunjunrui.view.EditTextWithDeleteButton;
import com.throrinstudio.android.common.libs.validator.Form;
import com.throrinstudio.android.common.libs.validator.Validate;
import com.throrinstudio.android.common.libs.validator.validator.NotEmptyValidator;

import org.json.JSONException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 作者：林俊 on 2017/7/31
 * 作用：
 */
public class ActivityAddAcount extends BaseActivity implements OnFunGetUserInfoListener {
    @BindView(R.id.iv_addacountback)
    ImageView ivAddacountback;
    @BindView(R.id.tv_device_name)
    TextView tvDeviceName;
    @BindView(R.id.rbtnremeber)
    CheckBox rbtnremeber;
    @BindView(R.id.tv_forget)
    TextView tvForget;
    @BindView(R.id.btn_adduer)
    Button btnAdduer;
    @BindView(R.id.btn_register)
    Button btnRegister;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.add_account)
    EditTextWithDeleteButton addAccount;
    @BindView(R.id.add_passworld)
    EditTextWithDeleteButton addPassworld;
    private boolean isremember = true;
    private Form form;
    private FunUserInfo info;
    private ProgressDialog progressDialog;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_add_login;
    }

    @Override
    protected void initView() {
        FunSupport.getInstance().registerOnFunGetUserInfoListener(this);

    }

    @Override
    protected void bindEvent() {

    }

    @OnClick({R.id.iv_addacountback, R.id.rbtnremeber, R.id.tv_forget, R.id.btn_adduer, R.id.btn_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_addacountback:
                this.finish();
                break;
            case R.id.rbtnremeber:
                if (rbtnremeber.isChecked()) {
                    isremember = true;
                } else {
                    isremember = false;
                }
                break;
            case R.id.tv_forget:
                ActionUtils.actionStart(this, ActivityFindPsw.class);
                break;
            case R.id.btn_adduer:
                      if (verifier()){
                            progressDialog=new ProgressDialog(this);
                          progressDialog.setTitle("加载中");//2.设置标题
                          progressDialog.setMessage("正在加载中，请稍等......");//3.设置显示内容
                          progressDialog.setCancelable(true);//4.设置可否用back键关闭对话框
                          progressDialog.show();
                          if ( FunSupport.getInstance().login(addAccount.getText().toString().trim(),addPassworld.getText().toString().trim())){

                              ActionUtils.actionStart(this,ActivityAcount.class);
                          }else {
                              Toast.makeText(this,"失败",Toast.LENGTH_SHORT).show();
                          }
                      }

                break;
            case R.id.btn_register:
                ActionUtils.actionStart(this, ActivityRegister.class);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    private boolean verifier() {
        form=new Form();
        Validate account = new Validate(addAccount);
         account.addValidator(new NotEmptyValidator(this));
        Validate password=new Validate(addPassworld);
        password.addValidator(new NotEmptyValidator(this));
          form.addValidates(account);
        form.addValidates(password);
        return  form.validate();
    }


    @Override
    public void onGetUserInfoSuccess(String strUserInfo) throws JSONException {
         info=new Gson().fromJson(strUserInfo,FunUserInfo.class);
          Usermodel usermodel =new Usermodel();
         usermodel.setUserId(Integer.parseInt(info.getUserId()));
          usermodel.setUserName(info.getUserName());
          usermodel.setUserTel(info.getMobile_phone());
          usermodel.setUserEmail(info.getEmail());
          usermodel.setUserPassWorld(addPassworld.getText().toString().trim());
          DbHelper.getInstance().user().insert(usermodel);
        progressDialog.dismiss();
    }

    @Override
    public void onGetUserInfoFailed(int errCode) {
         Toast.makeText(this,"获取用户信息失败",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLogoutSuccess() {

    }

    @Override
    public void onLogoutFailed(int errCode) {

    }
}
