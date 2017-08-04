package com.linjun.yunjunrui.ui.me.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.lib.funsdk.support.FunSupport;
import com.linjun.yunjunrui.R;
import com.linjun.yunjunrui.ui.base.BaseActivity;
import com.linjun.yunjunrui.ui.login.activity.ActivityLogin;
import com.linjun.yunjunrui.utils.ActionUtils;
import com.linjun.yunjunrui.utils.ValidationUtil;
import com.linjun.yunjunrui.view.EditTextWithDeleteButton;
import com.throrinstudio.android.common.libs.validator.Form;
import com.throrinstudio.android.common.libs.validator.Validate;
import com.throrinstudio.android.common.libs.validator.validate.ConfirmValidate;
import com.throrinstudio.android.common.libs.validator.validator.NotEmptyValidator;
import com.vise.xsnow.cache.SpCache;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 作者：林俊 on 2017/8/3
 * 作用：
 */
public class ActivityChangPsd extends BaseActivity {
    @BindView(R.id.iv_changepswback1)
    ImageView ivChangepswback1;
    @BindView(R.id.tv_s)
    TextView tvS;
    @BindView(R.id.ed_oldpsd)
    EditTextWithDeleteButton edOldpsd;
    @BindView(R.id.ed_newpsd)
    EditTextWithDeleteButton edNewpsd;
    @BindView(R.id.ed_netsure)
    EditTextWithDeleteButton edNetsure;
    @BindView(R.id.btn_nsure)
    Button btnNsure;
    private SpCache spCache;
    private  String username,userpassworld;
    private Form form;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_changepsd;
    }

    @Override
    protected void initView() {
         spCache=new SpCache(this);
        username= (String) spCache.get("username");
        userpassworld= (String) spCache.get("userpsd");
    }

    @Override
    protected void bindEvent() {

    }

    @OnClick({R.id.iv_changepswback1, R.id.btn_nsure})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_changepswback1:
                this.finish();
                break;
            case R.id.btn_nsure:
                if (userpassworld==edOldpsd.getText().toString().trim()){
                    if (validator()&& FunSupport.getInstance().changePassw(username,userpassworld,edNewpsd.getText().toString().trim())){
                        ActionUtils.actionStart(this, ActivityLogin.class);
                    }

                }else {
                    Toast.makeText(this,"旧密码不正确",Toast.LENGTH_SHORT).show();
                }

                break;

        }
    }
    private  boolean validator(){
        form=new Form();
        Validate old=new Validate(edOldpsd);
        old.addValidator(new NotEmptyValidator(this));
        Validate newpsd=new Validate(edNewpsd);
        newpsd.addValidator(new NotEmptyValidator(this));
        Validate aginnew=new Validate(edNetsure);
        aginnew.addValidator(new NotEmptyValidator(this));
        ConfirmValidate confirmValidate=new ConfirmValidate(edNewpsd,edNetsure);
        form.addValidates(old);
        form.addValidates(newpsd);
        form.addValidates(aginnew);
        form.addValidates(confirmValidate);

      return form.validate();
    }
}
