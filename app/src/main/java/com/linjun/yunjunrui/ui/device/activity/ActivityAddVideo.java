package com.linjun.yunjunrui.ui.device.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.lib.funsdk.support.FunError;
import com.lib.funsdk.support.FunSupport;
import com.lib.funsdk.support.OnFunDeviceListener;
import com.lib.funsdk.support.OnFunDeviceOptListener;
import com.lib.funsdk.support.models.FunDevType;
import com.lib.funsdk.support.models.FunDevice;
import com.lib.funsdk.support.models.FunLoginType;
import com.lib.sdk.struct.H264_DVR_FILE_DATA;
import com.linjun.yunjunrui.R;
import com.linjun.yunjunrui.ui.base.BaseActivity;
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
public class ActivityAddVideo extends BaseActivity implements OnFunDeviceOptListener, OnFunDeviceListener {
    @BindView(R.id.iv_oneback)
    ImageView ivOneback;
    @BindView(R.id.main_text)
    TextView mainText;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.ed_name)
    EditTextWithDeleteButton edName;
    @BindView(R.id.ed_number)
    EditTextWithDeleteButton edNumber;
    @BindView(R.id.ed_telnum)
    EditTextWithDeleteButton edTelnum;
    @BindView(R.id.ed_passworld)
    EditTextWithDeleteButton edPassworld;
    @BindView(R.id.btn_add_video)
    Button btnAddVideo;
    @BindView(R.id.ed_mac_video)
    EditTextWithDeleteButton edMacVideo;
    @BindView(R.id.ed_ip_video)
    EditTextWithDeleteButton edIpVideo;
    private Form form;
    private  FunDevice funDevice;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_add_video;
    }

    @Override
    protected void initView() {
        FunSupport.getInstance().setLoginType(FunLoginType.LOGIN_BY_INTENTT);
        FunSupport.getInstance().registerOnFunDeviceOptListener(this);
        FunSupport.getInstance().registerOnFunDeviceListener(this);
    }

    @Override
    protected void bindEvent() {

    }

    @OnClick({R.id.iv_oneback, R.id.btn_add_video})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_oneback:
                this.finish();
                break;
            case R.id.btn_add_video:
                if (vodicator()){
                    devicelogo();
                }
                break;
        }
    }
  private  boolean  vodicator(){
       form=new Form();
      Validate name=new Validate(edName);
      name.addValidator(new NotEmptyValidator(this));
      Validate num=new Validate(edNumber);
      num.addValidator(new NotEmptyValidator(this));
      Validate mac=new Validate(edMacVideo);
      mac.addValidator(new NotEmptyValidator(this));
      Validate ip=new Validate(edIpVideo);
      ip.addValidator(new NotEmptyValidator(this));
       Validate tel=new Validate(edTelnum);
      tel.addValidator(new NotEmptyValidator(this));
      Validate passworld=new Validate(edPassworld);
      passworld.addValidator(new NotEmptyValidator(this));
     form.addValidates(name);
      form.addValidates(num);
      form.addValidates(mac);
      form.addValidates(ip);
      form.addValidates(tel);
      form.addValidates(passworld);
      return form.validate();
  }

  private  void devicelogo(){
      funDevice=null;
      if (funDevice==null){
          funDevice=new FunDevice();
          funDevice.devIp=edIpVideo.getText().toString().trim();
          funDevice.devMac=edMacVideo.getText().toString().trim();
          funDevice.devType= FunDevType.EE_DEV_NORMAL_MONITOR;
          funDevice.devName=edName.getText().toString().trim();
          funDevice.devSn=edNumber.getText().toString().trim();
          funDevice.loginName=edTelnum.getText().toString().trim();
          funDevice.loginPsw=edPassworld.getText().toString().trim();
          FunSupport.getInstance().requestDeviceLogin(funDevice);

      }
  }
  private  void requestDeviceAdd(){
      if (null!=funDevice){
          FunSupport.getInstance().requestDeviceAdd(funDevice);
      }
  }
    @Override
    protected void onDestroy() {

        FunSupport.getInstance().removeOnFunDeviceListener(this);
        FunSupport.getInstance().removeOnFunDeviceOptListener(this);
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }


    @Override
    public void onDeviceLoginSuccess(FunDevice funDevice) {
     if (null!=funDevice&&null!=funDevice&&funDevice.getId()==funDevice.getId()){
         requestDeviceAdd();
     }
    }

    @Override
    public void onDeviceLoginFailed(FunDevice funDevice, Integer errCode) {
        if (errCode== FunError.EE_DVR_PASSWORD_NOT_VALID){
            Toast.makeText(this,"登入账号密码错误",Toast.LENGTH_SHORT).show();
        }
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

    @Override
    public void onDeviceListChanged() {

    }

    @Override
    public void onDeviceStatusChanged(FunDevice funDevice) {

    }

    @Override
    public void onDeviceAddedSuccess() {

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
}
