package com.linjun.yunjunrui.ui.login.activity;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.linjun.yunjunrui.R;
import com.linjun.yunjunrui.ui.base.BaseActivity;
import com.linjun.yunjunrui.utils.ActionUtils;
import com.linjun.yunjunrui.utils.ValidationUtil;
import com.linjun.yunjunrui.view.EditTextWithDeleteButton;

import butterknife.BindView;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 作者：林俊 on 2017/7/31
 * 作用：
 */
public class ActivityLogin extends BaseActivity {
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
    RadioButton rbtnRemeber;
    @BindView(R.id.bowwn)
    RelativeLayout bowwn;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.user_register)
    Button userRegister;
      private  boolean isCheck=true;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void bindEvent() {

    }


    @OnClick({R.id.iv_loginback, R.id.rbtn_remeber, R.id.btn_login, R.id.user_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_loginback:
                this.finish();
                break;
            case R.id.rbtn_remeber:
                if (isCheck){
                rbtnRemeber.setChecked(false);
                    isCheck=false;
                }else {
                    rbtnRemeber.setChecked(true);
                    isCheck=true;
                }
                break;
            case R.id.btn_login:
                if (ValidationUtil.IsEmpty(this,userAccount)){
                    if (ValidationUtil.IsPhoneMumber(this,userAccount)&&ValidationUtil.IsEmpty(this,userPassworld)){


                    }else {
                        Toast.makeText(this,"账号格式不正确",Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(this,"账号不能为空",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.user_register:
                ActionUtils.actionStart(this,ActivityRegister.class);
                break;
        }
    }

}
