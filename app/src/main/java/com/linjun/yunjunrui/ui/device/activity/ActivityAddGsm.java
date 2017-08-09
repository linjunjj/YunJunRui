package com.linjun.yunjunrui.ui.device.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.lib.funsdk.support.FunSupport;
import com.lib.funsdk.support.OnFunDeviceListener;
import com.lib.funsdk.support.OnFunDeviceOptListener;
import com.lib.funsdk.support.models.FunDevType;
import com.lib.funsdk.support.models.FunDevice;
import com.lib.funsdk.support.models.FunLoginType;
import com.lib.sdk.struct.H264_DVR_FILE_DATA;
import com.linjun.yunjunrui.R;
import com.linjun.yunjunrui.ui.base.BaseActivity;
import com.linjun.yunjunrui.ui.login.activity.ActivityLogin;
import com.linjun.yunjunrui.utils.ActionUtils;
import com.linjun.yunjunrui.view.EditTextWithDeleteButton;
import com.throrinstudio.android.common.libs.validator.Form;
import com.throrinstudio.android.common.libs.validator.Validate;
import com.throrinstudio.android.common.libs.validator.validator.NotEmptyValidator;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 作者：林俊 on 2017/7/31
 * 作用：
 */
public class ActivityAddGsm extends BaseActivity implements OnFunDeviceListener, OnFunDeviceOptListener {
    @BindView(R.id.iv_gsmback)
    ImageView ivGsmback;
    @BindView(R.id.main_text)
    TextView mainText;
    @BindView(R.id.ed_name)
    EditTextWithDeleteButton edName;
    @BindView(R.id.ed_number)
    EditTextWithDeleteButton edNumber;
    @BindView(R.id.ed_telnum)
    EditTextWithDeleteButton edTelnum;
    @BindView(R.id.ed_passworld)
    EditTextWithDeleteButton edPassworld;
    @BindView(R.id.btn_add_gsm)
    Button btnAddGsm;
    @BindView(R.id.ed_mac)
    EditTextWithDeleteButton edMac;
    @BindView(R.id.ed_ip)
    EditTextWithDeleteButton edIp;
    private FunDevice funDevice;
   private Form form;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_add_gsm;
    }

    @Override
    protected void initView() {
        FunSupport.getInstance().setLoginType(FunLoginType.LOGIN_BY_INTENTT);
        FunSupport.getInstance().registerOnFunDeviceListener(this);
        FunSupport.getInstance().registerOnFunDeviceOptListener(this);
        if (!FunSupport.getInstance().hasLogin()) {
            ActionUtils.actionStart(ActivityAddGsm.this, ActivityLogin.class);
        }
    }

    @Override
    protected void bindEvent() {

    }

    @OnClick({R.id.iv_gsmback, R.id.btn_add_gsm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_gsmback:
                this.finish();
                break;
            case R.id.btn_add_gsm:
                if (validator()){
                    initdata();
                }else {
                    Toast.makeText(this,"请输入正确的格式",Toast.LENGTH_SHORT).show();
                }



                break;
        }
    }
private  boolean validator(){
    form=new Form();
    Validate name=new Validate(edName);
    name.addValidator(new NotEmptyValidator(this));
    Validate sn=new Validate(edNumber);
    sn.addValidator(new NotEmptyValidator(this));
    Validate mac=new Validate(edMac);
    mac.addValidator(new NotEmptyValidator(this));
    Validate ip=new Validate(edIp);
    ip.addValidator(new NotEmptyValidator(this));
    Validate tel=new Validate(edTelnum);
    tel.addValidator(new NotEmptyValidator(this));
    Validate psd=new Validate(edPassworld);
    psd.addValidator(new NotEmptyValidator(this));
    form.addValidates(name);
    form.addValidates(sn);
    form.addValidates(mac);
    form.addValidates(ip);
    form.addValidates(psd);
    form.addValidates(tel);
    return form.validate();
}



    private void initdata() {
        funDevice=null;
        if (null==funDevice){
        funDevice = new FunDevice();
        funDevice.devName =edName.getText().toString().trim();
        funDevice.devMac=edMac.getText().toString().trim();
        funDevice.devIp=edIp.getText().toString().trim();
        funDevice.devSn=edNumber.getText().toString().trim();
        funDevice.loginName=edTelnum.getText().toString().trim();
        funDevice.loginPsw=edPassworld.getText().toString().trim();
            funDevice.devType= FunDevType.EE_GSM_DEVICE;
        }
       FunSupport.getInstance().requestDeviceLogin(funDevice);
    }

    private  void requestDeviceAdd(){
        if (null!=funDevice){
            FunSupport.getInstance().requestDeviceAdd(funDevice);
        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }


    @Override
    public void onDeviceListChanged() {

    }

    @Override
    public void onDeviceStatusChanged(FunDevice funDevice) {

    }

    @Override
    public void onDeviceAddedSuccess() {
        requestDeviceAdd();
    }

    @Override
    public void onDeviceAddedFailed(Integer errCode) {

    }

    @Override
    public void onDeviceRemovedSuccess() {

    }

    @Override
    public void onDeviceRemovedFailed(Integer errCode) {

    }

    @Override
    public void onAPDeviceListChanged() {

    }

    @Override
    public void onLanDeviceListChanged() {

    }

    @Override
    public void onDeviceLoginSuccess(FunDevice funDevice) {

    }

    @Override
    public void onDeviceLoginFailed(FunDevice funDevice, Integer errCode) {

    }

    @Override
    public void onDeviceGetConfigSuccess(FunDevice funDevice, String configName, int nSeq) {

    }

    @Override
    public void onDeviceGetConfigFailed(FunDevice funDevice, Integer errCode) {

    }

    @Override
    public void onDeviceSetConfigSuccess(FunDevice funDevice, String configName) {

    }

    @Override
    public void onDeviceSetConfigFailed(FunDevice funDevice, String configName, Integer errCode) {

    }

    @Override
    public void onDeviceChangeInfoSuccess(FunDevice funDevice) {

    }

    @Override
    public void onDeviceChangeInfoFailed(FunDevice funDevice, Integer errCode) {

    }

    @Override
    public void onDeviceOptionSuccess(FunDevice funDevice, String option) {

    }

    @Override
    public void onDeviceOptionFailed(FunDevice funDevice, String option, Integer errCode) {

    }

    @Override
    public void onDeviceFileListChanged(FunDevice funDevice) {

    }

    @Override
    public void onDeviceFileListChanged(FunDevice funDevice, H264_DVR_FILE_DATA[] datas) {

    }

    @Override
    public void onDeviceFileListGetFailed(FunDevice funDevice) {

    }


}
